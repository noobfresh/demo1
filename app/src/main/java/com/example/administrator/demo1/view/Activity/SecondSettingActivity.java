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

public class SecondSettingActivity extends AppCompatActivity implements View.OnClickListener{


    private static final String TAG = "SecondSettingActivity";
    private Badge badgeNewMsgNotify;
    private Badge badgeAccpetVoiceVideo;
    private Badge badgeVoice;
    private Badge badgeVibration;
    private Badge badgeNonAccpetMsg;
    private Badge badgePay;

    //
    private LinearLayout linearLayout1;
    //
    private LinearLayout linearLayout2;
    //
    private LinearLayout linearLayout3;
    //
    private LinearLayout linearLayout4;
    //
    private LinearLayout linearLayout5;
    //
    private LinearLayout linearLayout6;

    private Intent intent = new Intent();
    private Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_setting);


        linearLayout1 = findViewById(R.id.linearSecondSetting5);
        linearLayout1.setOnClickListener(this);
        linearLayout2 = findViewById(R.id.linearSecondSetting3);
        linearLayout2.setOnClickListener(this);
        linearLayout3 = findViewById(R.id.linearSecondSetting1);
        linearLayout3.setOnClickListener(this);
        linearLayout4 = findViewById(R.id.linearSecondSetting2);
        linearLayout4.setOnClickListener(this);
        linearLayout5 = findViewById(R.id.linearSecondSetting4);
        linearLayout5.setOnClickListener(this);
        linearLayout6 = findViewById(R.id.linearSecondSetting6);
        linearLayout6.setOnClickListener(this);



        badgeNewMsgNotify = new QBadgeView(this).bindTarget(findViewById(R.id.textNewMsgNotify));
        BadgeUtil.badgeSetForTextView(badgeNewMsgNotify, BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getTotal());
        badgeAccpetVoiceVideo = new QBadgeView(this).bindTarget(findViewById(R.id.textAccpetVoiceVideo));
        BadgeUtil.badgeSetForTextView(badgeAccpetVoiceVideo, BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getTotal());
        badgeVoice = new QBadgeView(this).bindTarget(findViewById(R.id.textVoice));
        BadgeUtil.badgeSetForTextView(badgeVoice, BadgeUtil.settingBadge.getCardBadge().getVoice());
        badgeVibration = new QBadgeView(this).bindTarget(findViewById(R.id.textVibration));
        BadgeUtil.badgeSetForTextView(badgeVibration, BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getTotal());
        badgeNonAccpetMsg = new QBadgeView(this).bindTarget(findViewById(R.id.textNonAccpetMsg));
        BadgeUtil.badgeSetForTextView(badgeNonAccpetMsg, BadgeUtil.settingBadge.getCardBadge().getNonAccpetMsg());
        badgePay = new QBadgeView(this).bindTarget(findViewById(R.id.textPay));
        BadgeUtil.badgeSetForTextView(badgePay, BadgeUtil.settingBadge.getCardBadge().getPay());




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //接收语音和视频聊天邀请通知
            case R.id.linearSecondSetting1:
                intent1 = new Intent(SecondSettingActivity.this,
                        SecondFirstActivity.class);
                startActivityForResult(intent1, 1);
                break;
            //振动
            case R.id.linearSecondSetting3:
                intent1 = new Intent(SecondSettingActivity.this,
                        SecondSecondActivity.class);
                startActivityForResult(intent1, 2);
                break;
            //接收新消息通知
            case R.id.linearSecondSetting5:
                intent1 = new Intent(SecondSettingActivity.this,
                        SecondThirdActivity.class);
                startActivityForResult(intent1, 3);
                break;
            //声音
            case R.id.linearSecondSetting2:
                BadgeUtil.settingBadge.getCardBadge().setVoice(0);
                updateBadge(R.id.linearSecondSetting2);
                break;
            //不接收新消息
            case R.id.linearSecondSetting4:
                BadgeUtil.settingBadge.getCardBadge().setNonAccpetMsg(0);
                updateBadge(R.id.linearSecondSetting4);
                break;
            //充值
            case R.id.linearSecondSetting6:
                BadgeUtil.settingBadge.getCardBadge().setPay(0);
                updateBadge(R.id.linearSecondSetting6);
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
                    //接收语音和视频聊天邀请通知
                    case R.id.linearSecondSetting1:
                        //首先刷新
                        badgeAccpetVoiceVideo.setBadgeNumber(BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getTotal());
                        //再通知上层
                        intent.putExtra("update", true);
                        break;
                    //振动
                    case R.id.linearSecondSetting3:
                        badgeVibration.setBadgeNumber(BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getTotal());
                        intent.putExtra("update", true);
                        break;
                    //接收新消息通知
                    case R.id.linearSecondSetting5:
                        badgeNewMsgNotify.setBadgeNumber(BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getTotal());
                        intent.putExtra("update", true);
                        break;
                    //声音
                    case R.id.linearSecondSetting2:
                        badgeVoice.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //不接收新消息
                    case R.id.linearSecondSetting4:
                        badgeNonAccpetMsg.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //充值
                    case R.id.linearSecondSetting6:
                        badgePay.setBadgeNumber(0);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //
        switch (requestCode){
            //接收语音和视频聊天邀请通知
            case 1:
                if(resultCode == RESULT_OK && data.getBooleanExtra("update", false) == true){
                    updateBadge(R.id.linearSecondSetting1);
                }
                break;
            //振动
            case 2:
                if(resultCode == RESULT_OK && data.getBooleanExtra("update", false) == true){
                    updateBadge(R.id.linearSecondSetting3);
                }
                break;
            //接收新消息通知
            case 3:
                if(resultCode == RESULT_OK && data.getBooleanExtra("update", false) == true){
                    updateBadge(R.id.linearSecondSetting5);
                }
                break;
            default:
                break;
        }
    }


}



