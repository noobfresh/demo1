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

public class FirstSettingActivity extends AppCompatActivity implements View.OnClickListener{

    private Intent intent = new Intent();
    private Intent intent1;
    private Badge badgeAccount;
    private Badge badgeNewMsgInform;
    private Badge badgeChat;
    private Badge badgePrivacy;
    private Badge badgeAbout;
    private Badge badgeHelp;
    //帐号与安全
    private LinearLayout linearLayout1;
    //隐私
    private LinearLayout linearLayout2;
    //新消息提醒
    private LinearLayout linearLayout3;
    //聊天
    private LinearLayout linearLayout4;
    //关于
    private LinearLayout linearLayout5;
    //帮助
    private LinearLayout linearLayout6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_setting);
        linearLayout1 = findViewById(R.id.linearSetting5);
        linearLayout1.setOnClickListener(this);
        linearLayout2 = findViewById(R.id.linearSetting3);
        linearLayout2.setOnClickListener(this);
        linearLayout3 = findViewById(R.id.linearSetting1);
        linearLayout3.setOnClickListener(this);
        linearLayout4 = findViewById(R.id.linearSetting2);
        linearLayout4.setOnClickListener(this);
        linearLayout5 = findViewById(R.id.linearSetting4);
        linearLayout5.setOnClickListener(this);
        linearLayout6 = findViewById(R.id.linearSetting6);
        linearLayout6.setOnClickListener(this);


        badgeAccount = new QBadgeView(this).bindTarget(findViewById(R.id.textAccount));
        BadgeUtil.badgeSetForTextView(badgeAccount, BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getTotal());
        badgeNewMsgInform = new QBadgeView(this).bindTarget(findViewById(R.id.textNewMsgInform));
        BadgeUtil.badgeSetForTextView(badgeNewMsgInform, BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getTotal());
        badgeChat = new QBadgeView(this).bindTarget(findViewById(R.id.textChat));
        BadgeUtil.badgeSetForTextView(badgeChat, BadgeUtil.settingBadge.getSetting1Badge().getChat());
        badgePrivacy = new QBadgeView(this).bindTarget(findViewById(R.id.textPrivacy));
        BadgeUtil.badgeSetForTextView(badgePrivacy, BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getTotal());
        badgeAbout = new QBadgeView(this).bindTarget(findViewById(R.id.textAbout));
        BadgeUtil.badgeSetForTextView(badgeAbout, BadgeUtil.settingBadge.getSetting1Badge().getAbout());
        badgeHelp = new QBadgeView(this).bindTarget(findViewById(R.id.textHelp));
        BadgeUtil.badgeSetForTextView(badgeHelp, BadgeUtil.settingBadge.getSetting1Badge().getHelp());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //隐私
            case R.id.linearSetting3:
                intent1 = new Intent(FirstSettingActivity.this, FirstFirstActivity.class);
                startActivityForResult(intent1, 1);
                break;
            //账号
            case R.id.linearSetting5:
                intent1 = new Intent(FirstSettingActivity.this, FirstSecondActivity.class);
                startActivityForResult(intent1,2);
                break;
            //新消息提醒
            case R.id.linearSetting1:
                intent1 = new Intent(FirstSettingActivity.this, FirstThirdActivity.class);
                startActivityForResult(intent1, 3);
                break;
            //聊天
            case R.id.linearSetting2:
                BadgeUtil.settingBadge.getSetting1Badge().setChat(0);
                updataBadge(R.id.linearSetting2);
                break;
            //关于
            case R.id.linearSetting4:
                BadgeUtil.settingBadge.getSetting1Badge().setAbout(0);
                updataBadge(R.id.linearSetting4);
                break;
            //帮助
            case R.id.linearSetting6:
                BadgeUtil.settingBadge.getSetting1Badge().setHelp(0);
                updataBadge(R.id.linearSetting6);
                break;
            default:
                break;
        }
    }


    public void updataBadge(final int id){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (id){
                    //隐私
                    case R.id.linearSetting3:
                        badgePrivacy.setBadgeNumber(BadgeUtil.settingBadge.getSetting1Badge().getPrivacyBadge().getTotal());
                        intent.putExtra("update", true);
                        break;
                    //账号
                    case R.id.linearSetting5:
                        badgeAccount.setBadgeNumber(BadgeUtil.settingBadge.getSetting1Badge().getAccountBadge().getTotal());
                        intent.putExtra("update", true);
                        break;
                    //新消息提醒
                    case R.id.linearSetting1:
                        badgeNewMsgInform.setBadgeNumber(BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getTotal());
                        intent.putExtra("update", true);
                        break;
                    //聊天
                    case R.id.linearSetting2:
                        badgeChat.setBadgeNumber(0);
                        //回调上一级的刷新页面
                        intent.putExtra("update", true);
                        break;
                    //关于
                    case R.id.linearSetting4:
                        badgeAbout.setBadgeNumber(0);
                        intent.putExtra("update", true);
                        //回调
                        break;
                    //帮助
                    case R.id.linearSetting6:
                        badgeHelp.setBadgeNumber(0);
                        intent.putExtra("update", true);
                        //回调
                        break;
                    default:
                        break;
                }
                setResult(RESULT_OK, intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            //隐私
            case 1:
                if(resultCode == RESULT_OK && data.getBooleanExtra("update", false) == true){
                    updataBadge(R.id.linearSetting3);
                }
                break;
            //账号
            case 2:
                if(resultCode == RESULT_OK && data.getBooleanExtra("update", false) == true){
                    updataBadge(R.id.linearSetting5);
                }
                break;
            //新消息提醒
            case 3:
                if(resultCode == RESULT_OK && data.getBooleanExtra("update", false) == true){
                    updataBadge(R.id.linearSetting1);
                }
                break;
            default:
                break;
        }
    }
}
