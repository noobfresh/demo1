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

public class SecondThirdActivity extends AppCompatActivity implements View.OnClickListener{


    private Badge badgeKD;
    private Badge badgeWestbrook;
    private Badge badgeAnthony;
    private Badge badgeGeorge;
    private Badge badgeZimuge;
    private Badge badgeCute;
    private Badge badgeGordan;

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
        setContentView(R.layout.activity_second_third);
        badgeKD = new QBadgeView(this).bindTarget(findViewById(R.id.textKD));
        badgeWestbrook = new QBadgeView(this).bindTarget(findViewById(R.id.textWestbrook));
        badgeAnthony = new QBadgeView(this).bindTarget(findViewById(R.id.textAnthony));
        badgeGeorge = new QBadgeView(this).bindTarget(findViewById(R.id.textGeorge));
        badgeZimuge = new QBadgeView(this).bindTarget(findViewById(R.id.textZimuge));
        badgeCute = new QBadgeView(this).bindTarget(findViewById(R.id.textCute));
        badgeGordan = new QBadgeView(this).bindTarget(findViewById(R.id.textGordan));
        BadgeUtil.badgeSetForTextView(badgeKD, BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getKd());
        BadgeUtil.badgeSetForTextView(badgeWestbrook, BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getWestbrook());
        BadgeUtil.badgeSetForTextView(badgeAnthony, BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getAnthony());
        BadgeUtil.badgeSetForTextView(badgeGeorge, BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getGeorge());
        BadgeUtil.badgeSetForTextView(badgeZimuge, BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getZimuge());
        BadgeUtil.badgeSetForTextView(badgeCute, BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getCute());
        BadgeUtil.badgeSetForTextView(badgeGordan, BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().getGordan());


        //KD
        linearLayout1 = findViewById(R.id.linearSecondThird5);
        //威少
        linearLayout2 = findViewById(R.id.linearSecondThird1);
        //安东尼
        linearLayout3 = findViewById(R.id.linearSecondThird2);
        //乔治
        linearLayout4 = findViewById(R.id.linearSecondThird3);
        //字母哥
        linearLayout5 = findViewById(R.id.linearSecondThird4);
        //卡哇伊
        linearLayout6 = findViewById(R.id.linearSecondThird6);
        //戈登
        linearLayout7 = findViewById(R.id.linearSecondThird);

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
            //KD
            case R.id.linearSecondThird5:
                BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().setKd(0);
                updateBadgeView(R.id.linearSecondThird5);
                break;
            //威少
            case R.id.linearSecondThird1:
                BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().setWestbrook(0);
                updateBadgeView(R.id.linearSecondThird1);
                break;
            //安东尼
            case R.id.linearSecondThird2:
                BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().setAnthony(0);
                updateBadgeView(R.id.linearSecondThird2);
                break;
            //乔治
            case R.id.linearSecondThird3:
                BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().setGeorge(0);
                updateBadgeView(R.id.linearSecondThird3);
                break;
            //字母哥
            case R.id.linearSecondThird4:
                BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().setZimuge(0);
                updateBadgeView(R.id.linearSecondThird4);
                break;
            //卡哇伊
            case R.id.linearSecondThird6:
                BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().setCute(0);
                updateBadgeView(R.id.linearSecondThird6);
                break;
            //戈登
            case R.id.linearSecondThird:
                BadgeUtil.settingBadge.getCardBadge().getNewMsgNotifyBadge().setGordan(0);
                updateBadgeView(R.id.linearSecondThird);
                break;
            default:
                break;
        }
    }

    public void updateBadgeView(final int id){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (id){
                    //KD
                    case R.id.linearSecondThird5:
                        badgeKD.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //威少
                    case R.id.linearSecondThird1:
                        badgeWestbrook.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //安东尼
                    case R.id.linearSecondThird2:
                        badgeAnthony.setBadgeNumber(0);
                        intent.putExtra("update", true);
                        break;
                    //乔治
                    case R.id.linearSecondThird3:
                        badgeGeorge.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //字母哥
                    case R.id.linearSecondThird4:
                        badgeZimuge.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //卡哇伊
                    case R.id.linearSecondThird6:
                        badgeCute.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //戈登
                    case R.id.linearSecondThird:
                        badgeGordan.setBadgeNumber(0);
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
