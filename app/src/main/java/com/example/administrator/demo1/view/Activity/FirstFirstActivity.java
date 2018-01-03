package com.example.administrator.demo1.view.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.util.BadgeUtil;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class FirstFirstActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = "FirstFirstActivity";
    
    private Badge badgemail;
    private Badge badgeUsername;
    private Badge badgeBanana;
    private Badge badgePassword;
    private Badge badgeFingerprint;
    private Badge badgeSecurity;
    private Badge badgeRunOut;

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
        setContentView(R.layout.activity_first_first);
        badgemail = new QBadgeView(this).bindTarget(findViewById(R.id.textMail));
        badgeUsername = new QBadgeView(this).bindTarget(findViewById(R.id.textUsername));
        badgeBanana = new QBadgeView(this).bindTarget(findViewById(R.id.textBanana));
        badgePassword = new QBadgeView(this).bindTarget(findViewById(R.id.textPassword));
        badgeFingerprint = new QBadgeView(this).bindTarget(findViewById(R.id.textFingerprint));
        badgeSecurity = new QBadgeView(this).bindTarget(findViewById(R.id.textSecurity));
        badgeRunOut = new QBadgeView(this).bindTarget(findViewById(R.id.textRunOut));
        BadgeUtil.badgeSetForTextView(badgemail, BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getMail());
        BadgeUtil.badgeSetForTextView(badgeUsername, BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getUsername());
        BadgeUtil.badgeSetForTextView(badgeBanana, BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getBanana());
        BadgeUtil.badgeSetForTextView(badgePassword, BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getPassword());
        BadgeUtil.badgeSetForTextView(badgeFingerprint, BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getFingerPrint());
        BadgeUtil.badgeSetForTextView(badgeSecurity, BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getSecurity());
        BadgeUtil.badgeSetForTextView(badgeRunOut, BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getRunOut());


        //邮箱
        linearLayout1 = findViewById(R.id.linearAccount5);
        //用户名
        linearLayout2 = findViewById(R.id.linearAccount1);
        //香蕉
        linearLayout3 = findViewById(R.id.linearAccount2);
        //登录密码
        linearLayout4 = findViewById(R.id.linearAccount3);
        //指纹
        linearLayout5 = findViewById(R.id.linearAccount4);
        //安全中心
        linearLayout6 = findViewById(R.id.linearAccount6);
        //想不出来了
        linearLayout7 = findViewById(R.id.linearAccount);

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
            case R.id.linearAccount5:
                BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().setMail(0);
                updateBadge(R.id.linearAccount5);
                break;
            //用户名
            case R.id.linearAccount1:
                BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().setUsername(0);
                updateBadge(R.id.linearAccount1);
                break;
            //香蕉
            case R.id.linearAccount2:
                BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().setBanana(0);
                updateBadge(R.id.linearAccount2);
                break;
            //登录密码
            case R.id.linearAccount3:
                BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().setPassword(0);
                updateBadge(R.id.linearAccount3);
                break;
            //指纹
            case R.id.linearAccount4:
                BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().setFingerPrint(0);
                updateBadge(R.id.linearAccount4);
                break;
            //安全中心
            case R.id.linearAccount6:
                BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().setSecurity(0);
                updateBadge(R.id.linearAccount6);
                break;
            //想不出来了
            case R.id.linearAccount:
                BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().setRunOut(0);
                updateBadge(R.id.linearAccount);
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
                    case R.id.linearAccount5:
                        badgemail.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //用户名
                    case R.id.linearAccount1:
                        badgeUsername.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //香蕉
                    case R.id.linearAccount2:
                        badgeBanana.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //登录密码
                    case R.id.linearAccount3:
                        badgePassword.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //指纹
                    case R.id.linearAccount4:
                        badgeFingerprint.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //安全中心
                    case R.id.linearAccount6:
                        badgeSecurity.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //想不出来了
                    case R.id.linearAccount:
                        badgeRunOut.setBadgeNumber(0);
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
