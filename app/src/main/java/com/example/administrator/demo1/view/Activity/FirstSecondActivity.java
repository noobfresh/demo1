package com.example.administrator.demo1.view.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.util.BadgeUtil;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class FirstSecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Badge badgeEmail;
    private Badge badgeHello;
    private Badge badgeThisIs;
    private Badge badgeHuanJu;
    private Badge badgeTimes;
    private Badge badgeCompany;
    private Badge badgeCarnival;

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout4;
    private LinearLayout linearLayout5;
    private LinearLayout linearLayout6;
    private LinearLayout linearLayout7;

    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_second);
        badgeEmail = new QBadgeView(this).bindTarget(findViewById(R.id.textEmail));
        badgeHello = new QBadgeView(this).bindTarget(findViewById(R.id.textHello));
        badgeThisIs = new QBadgeView(this).bindTarget(findViewById(R.id.textThisIs));
        badgeHuanJu = new QBadgeView(this).bindTarget(findViewById(R.id.textHuanJu));
        badgeTimes = new QBadgeView(this).bindTarget(findViewById(R.id.textTimes));
        badgeCompany = new QBadgeView(this).bindTarget(findViewById(R.id.textCompany));
        badgeCarnival = new QBadgeView(this).bindTarget(findViewById(R.id.textCarnival));
        BadgeUtil.badgeSetForTextView(badgeEmail, BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getEmail());
        BadgeUtil.badgeSetForTextView(badgeHello, BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getHello());
        BadgeUtil.badgeSetForTextView(badgeThisIs, BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getThisIs());
        BadgeUtil.badgeSetForTextView(badgeHuanJu, BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getHuanJu());
        BadgeUtil.badgeSetForTextView(badgeTimes, BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getTimes());
        BadgeUtil.badgeSetForTextView(badgeCompany, BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getCompany());
        BadgeUtil.badgeSetForTextView(badgeCarnival, BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getCarnival());

        //邮箱
        linearLayout1 = findViewById(R.id.linearFirstSecond5);
        //你好
        linearLayout2 = findViewById(R.id.linearFirstSecond1);
        //这是
        linearLayout3 = findViewById(R.id.linearFirstSecond2);
        //欢聚
        linearLayout4 = findViewById(R.id.linearFirstSecond3);
        //时代
        linearLayout5 = findViewById(R.id.linearFirstSecond4);
        //公司
        linearLayout6 = findViewById(R.id.linearFirstSecond6);
        //嘉年华
        linearLayout7 = findViewById(R.id.linearFirstSecond);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
        linearLayout5.setOnClickListener(this);
        linearLayout6.setOnClickListener(this);
        linearLayout7.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //邮箱
            case R.id.linearFirstSecond5:
                BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().setEmail(0);
                updateBadge(R.id.linearFirstSecond5);
                break;
            //你好
            case R.id.linearFirstSecond1:
                BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().setHello(0);
                updateBadge(R.id.linearFirstSecond1);
                break;
            //这是
            case R.id.linearFirstSecond2:
                BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().setThisIs(0);
                updateBadge(R.id.linearFirstSecond2);
                break;
            //欢聚
            case R.id.linearFirstSecond3:
                BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().setHuanJu(0);
                updateBadge(R.id.linearFirstSecond3);
                break;
            //时代
            case R.id.linearFirstSecond4:
                BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().setTimes(0);
                updateBadge(R.id.linearFirstSecond4);
                break;
            //公司
            case R.id.linearFirstSecond6:
                BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().setCompany(0);
                updateBadge(R.id.linearFirstSecond6);
                break;
            //嘉年华
            case R.id.linearFirstSecond:
                BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().setCarnival(0);
                updateBadge(R.id.linearFirstSecond);
                break;
            default:
                break;
        }
    }

    public void updateBadge(final int id){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (id){
                    //邮箱
                    case R.id.linearFirstSecond5:
                        badgeEmail.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //你好
                    case R.id.linearFirstSecond1:
                        badgeHello.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //这是
                    case R.id.linearFirstSecond2:
                        badgeThisIs.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //欢聚
                    case R.id.linearFirstSecond3:
                        badgeHuanJu.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //时代
                    case R.id.linearFirstSecond4:
                        badgeTimes.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //公司
                    case R.id.linearFirstSecond6:
                        badgeCompany.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //嘉年华
                    case R.id.linearFirstSecond:
                        badgeCarnival.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    default:
                        break;
                }
                setResult(RESULT_OK, intent);
            }
        });
    }

}
