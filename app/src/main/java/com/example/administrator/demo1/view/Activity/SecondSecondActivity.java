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

public class SecondSecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Badge badgeAgentsOfShield;
    private Badge badgeCharlie;
    private Badge badgeMadMen;
    private Badge badgeHouseOfCard;
    private Badge badgeAmericanHorrorStory;
    private Badge badgeSilconValley;
    private Badge badgeDesperateHousewife;

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout4;
    private LinearLayout linearLayout5;
    private LinearLayout linearLayout6;
    private LinearLayout linearLayout7;

    //携带数据回去，退出当前活动时，把红点数据带回去，并修改界面
    private Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_second);
        badgeAgentsOfShield = new QBadgeView(this).bindTarget(findViewById(R.id.textAgentsOfShield));
        badgeCharlie = new QBadgeView(this).bindTarget(findViewById(R.id.textCharlie));
        badgeMadMen = new QBadgeView(this).bindTarget(findViewById(R.id.textMadMen));
        badgeHouseOfCard = new QBadgeView(this).bindTarget(findViewById(R.id.textHouseOfCard));
        badgeAmericanHorrorStory = new QBadgeView(this).bindTarget(findViewById(R.id.textAmericanHorrorStory));
        badgeSilconValley = new QBadgeView(this).bindTarget(findViewById(R.id.textSilconValley));
        badgeDesperateHousewife = new QBadgeView(this).bindTarget(findViewById(R.id.textDesperateHousewife));
        BadgeUtil.badgeSetForTextView(badgeAgentsOfShield, BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getAgentsOfShield());
        BadgeUtil.badgeSetForTextView(badgeCharlie, BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getCharlie());
        BadgeUtil.badgeSetForTextView(badgeMadMen, BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getMadMen());
        BadgeUtil.badgeSetForTextView(badgeHouseOfCard, BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getHouseOfCard());
        BadgeUtil.badgeSetForTextView(badgeAmericanHorrorStory, BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getAmericanHorrorStory());
        BadgeUtil.badgeSetForTextView(badgeSilconValley, BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getSilconValley());
        BadgeUtil.badgeSetForTextView(badgeDesperateHousewife, BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().getDesperateHousewife());


        //神盾局特工
        linearLayout1 = findViewById(R.id.linearSecondSecond5);
        //查理的成长日记
        linearLayout2 = findViewById(R.id.linearSecondSecond1);
        //广告狂人
        linearLayout3 = findViewById(R.id.linearSecondSecond2);
        //纸牌屋
        linearLayout4 = findViewById(R.id.linearSecondSecond3);
        //美国恐怖故事
        linearLayout5 = findViewById(R.id.linearSecondSecond4);
        //硅谷
        linearLayout6 = findViewById(R.id.linearSecondSecond6);
        //绝望主妇
        linearLayout7 = findViewById(R.id.linearSecondSecond);

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
            //神盾局特工
            case R.id.linearSecondSecond5:
                BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().setAgentsOfShield(0);
                updateBadge(R.id.linearFirstSecond5);
                break;
            //查理的成长日记
            case R.id.linearSecondSecond1:
                BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().setCharlie(0);
                updateBadge(R.id.linearFirstSecond1);
                break;
            //广告狂人
            case R.id.linearSecondSecond2:
                BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().setMadMen(0);
                updateBadge(R.id.linearFirstSecond2);
                break;
            //纸牌屋
            case R.id.linearSecondSecond3:
                BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().setHouseOfCard(0);
                updateBadge(R.id.linearFirstSecond3);
                break;
            //美国恐怖故事
            case R.id.linearSecondSecond4:
                BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().setAmericanHorrorStory(0);
                updateBadge(R.id.linearFirstSecond4);
                break;
            //硅谷
            case R.id.linearSecondSecond6:
                BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().setSilconValley(0);
                updateBadge(R.id.linearFirstSecond6);
                break;
            //绝望主妇
            case R.id.linearSecondSecond:
                BadgeUtil.settingBadge.getCardBadge().getVibrationBadge().setDesperateHousewife(0);
                updateBadge(R.id.linearFirstSecond);
                break;
        }

    }

    public void updateBadge(final int id){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (id){
                    //神盾局特工
                    case R.id.linearFirstSecond5:
                        badgeAgentsOfShield.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //查理的成长日记
                    case R.id.linearFirstSecond1:
                        badgeCharlie.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //广告狂人
                    case R.id.linearFirstSecond2:
                        badgeMadMen.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //纸牌屋
                    case R.id.linearFirstSecond3:
                        badgeHouseOfCard.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //美国恐怖故事
                    case R.id.linearFirstSecond4:
                        badgeAmericanHorrorStory.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //硅谷
                    case R.id.linearFirstSecond6:
                        badgeSilconValley.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //绝望主妇
                    case R.id.linearFirstSecond:
                        badgeDesperateHousewife.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                }
                setResult(RESULT_OK, intent);
            }
        });
    }

}
