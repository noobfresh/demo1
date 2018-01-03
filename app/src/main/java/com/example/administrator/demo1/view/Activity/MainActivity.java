package com.example.administrator.demo1.view.Activity;


import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.News;
import com.example.administrator.demo1.presenter.IDisplayNewsPresenter;
import com.example.administrator.demo1.util.BadgeUtil;
import com.example.administrator.demo1.util.DBUtil;
import com.example.administrator.demo1.util.rxjava.RxJavaUtil;
import com.example.administrator.demo1.view.Fragment.NewsFragment;
import com.example.administrator.demo1.view.Fragment.PhotoFragment;
import com.example.administrator.demo1.view.Fragment.SettingFragment;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener{


    private IDisplayNewsPresenter newsPresenter;

    private List<News> newsList = new ArrayList<>();

    public static Fragment mContent;

    public static FragmentManager manager;

    //红点尝试
    private BottomNavigationItemView actionNews;
    private BottomNavigationItemView actionPhoto;
    private BottomNavigationItemView actionSetting;
    private Badge badgeView2;
    private Badge badgeView;
    //
    private Fragment fragmentNews;
    private Fragment fragmentPhoto;
    private SettingFragment fragmentSetting;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initDatabase();
//        HttpUtil.testOkHttp();
//        RxJavaUtil.test14();
        ProgressBar progressBar = findViewById(R.id.progressBar);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.n);
        manager = getSupportFragmentManager();
        fragmentNews = new NewsFragment();
        fragmentPhoto = new PhotoFragment();
        fragmentSetting = new SettingFragment();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        actionPhoto = bottomNavigationView.findViewById(R.id.action_photo);
        actionSetting = bottomNavigationView.findViewById(R.id.action_setting);
        badgeView2 = new QBadgeView(this).bindTarget(actionPhoto)
                //这里未读数字的获取，应该交由presenter层
                .setBadgeNumber(DBUtil.countRecords())
                .setExactMode(true)
                .setBadgeGravity(Gravity.TOP| Gravity.END)
                .setGravityOffset(40.0f, 0, true)
                .setShowShadow(true);
        NavigationView navigationView = findViewById(R.id.navView);
        navigationView.setCheckedItem(R.id.navCall);
        replaceFragment(fragmentNews);

        badgeView = new QBadgeView(this).bindTarget(actionSetting)
                .setBadgeNumber(BadgeUtil.settingBadge.getTotal())
                .setExactMode(true)
                .setBadgeGravity(Gravity.TOP| Gravity.END)
                .setGravityOffset(40.0f, 0, true)
                .setShowShadow(true);
//        BadgeUtil.randomBadge();
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

    }


    public void initDatabase(){
        DBUtil.initDBHelper(MainActivity.this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                ((DrawerLayout)findViewById(R.id.drawerLayout)).openDrawer(GravityCompat.START);
                break;
            default:
        }

        return true;
    }


    //bottomNavigation的切换
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        mContent = fragment;
        fragmentTransaction.replace(R.id.frameLayout2, fragment);
        fragmentTransaction.commit();
    }

    public static void switchContent(Fragment from, Fragment to){
        if(mContent != to){
            mContent = to;
            FragmentTransaction transaction = manager.beginTransaction();
            if(!to.isAdded()){
                transaction.hide(from).add(R.id.frameLayout2, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
        }

    }

    public void updateBadgeView(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                badgeView2.setBadgeNumber(DBUtil.countRecords());
            }
        });

    }

    public void updateSettingBadge(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                badgeView.setBadgeNumber(BadgeUtil.settingBadge.getTotal());
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_news:
                switchContent(mContent, fragmentNews);
                return true;
            case R.id.action_photo:
                switchContent(mContent, fragmentPhoto);
                return true;
            case R.id.action_setting:
                switchContent(mContent, fragmentSetting);
                return true;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                BadgeUtil.randomBadge();
                updateSettingBadge();
                if(fragmentSetting.isAdded()){
                    fragmentSetting.updateSettingBadgeView();
                }
                break;
            default:
                break;
        }
    }
}
