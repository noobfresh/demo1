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

public class SecondFirstActivity extends AppCompatActivity implements View.OnClickListener{

    private Badge badgeBrokenGirls;
    private Badge badgeHowIMetYourMother;
    private Badge badgeBigBang;
    private Badge badgeModernFamily;
    private Badge badgeFriends;
    private Badge badgeGameOfThrones;
    private Badge badgeWalkingDead;

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
        setContentView(R.layout.activity_second_first);
        badgeBrokenGirls = new QBadgeView(this).bindTarget(findViewById(R.id.textBrokenGirls));
        badgeHowIMetYourMother = new QBadgeView(this).bindTarget(findViewById(R.id.textHowIMetYourMother));
        badgeBigBang = new QBadgeView(this).bindTarget(findViewById(R.id.textBigBang));
        badgeModernFamily = new QBadgeView(this).bindTarget(findViewById(R.id.textModernFamily));
        badgeFriends = new QBadgeView(this).bindTarget(findViewById(R.id.textFriends));
        badgeGameOfThrones = new QBadgeView(this).bindTarget(findViewById(R.id.textGameOfThrones));
        badgeWalkingDead = new QBadgeView(this).bindTarget(findViewById(R.id.textWalkingDead));
        BadgeUtil.badgeSetForTextView(badgeBrokenGirls, BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getBrokeGirls());
        BadgeUtil.badgeSetForTextView(badgeHowIMetYourMother, BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getHowIMetYourMother());
        BadgeUtil.badgeSetForTextView(badgeBigBang, BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getBigBang());
        BadgeUtil.badgeSetForTextView(badgeModernFamily, BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getModernFamily());
        BadgeUtil.badgeSetForTextView(badgeFriends, BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getFriends());
        BadgeUtil.badgeSetForTextView(badgeGameOfThrones, BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getGameOfThrones());
        BadgeUtil.badgeSetForTextView(badgeWalkingDead, BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getWalkingDead());


        //破产姐妹
        linearLayout1 = findViewById(R.id.linearSecondFirst5);
        //老爸老妈的浪漫史
        linearLayout2 = findViewById(R.id.linearSecondFirst1);
        //生活大爆炸
        linearLayout3 = findViewById(R.id.linearSecondFirst2);
        //摩登家庭
        linearLayout4 = findViewById(R.id.linearSecondFirst3);
        //老友记
        linearLayout5 = findViewById(R.id.linearSecondFirst4);
        //权利的游戏
        linearLayout6 = findViewById(R.id.linearSecondFirst6);
        //行尸走肉
        linearLayout7 = findViewById(R.id.linearSecondFirst);

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
            //破产姐妹
            case R.id.linearSecondFirst5:
                BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().setBrokeGirls(0);
                updateBadge(R.id.linearSecondFirst5);
                break;
            //老爸老妈的浪漫史
            case R.id.linearSecondFirst1:
                BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().setHowIMetYourMother(0);
                updateBadge(R.id.linearSecondFirst1);
                break;
            //生活大爆炸
            case R.id.linearSecondFirst2:
                BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().setBigBang(0);
                updateBadge(R.id.linearSecondFirst2);
                break;
            //摩登家庭
            case R.id.linearSecondFirst3:
                BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().setModernFamily(0);
                updateBadge(R.id.linearSecondFirst3);
                break;
            //老友记
            case R.id.linearSecondFirst4:
                BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().setFriends(0);
                updateBadge(R.id.linearSecondFirst4);
                break;
            //权利的游戏
            case R.id.linearSecondFirst6:
                BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().setGameOfThrones(0);
                updateBadge(R.id.linearSecondFirst6);
                break;
            //行尸走肉
            case R.id.linearSecondFirst:
                BadgeUtil.settingBadge.getCardBadge().getAccpetVoiceVideoBadge().setWalkingDead(0);
                updateBadge(R.id.linearSecondFirst);
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
                    //破产姐妹
                    case R.id.linearSecondFirst5:
                        badgeBrokenGirls.setBadgeNumber(0);
                        intent.putExtra("update", true);
                        //
                        break;
                    //老爸老妈的浪漫史
                    case R.id.linearSecondFirst1:
                        badgeHowIMetYourMother.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //生活大爆炸
                    case R.id.linearSecondFirst2:
                        badgeBigBang.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //摩登家庭
                    case R.id.linearSecondFirst3:
                        badgeModernFamily.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //老友记
                    case R.id.linearSecondFirst4:
                        badgeFriends.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //权利的游戏
                    case R.id.linearSecondFirst6:
                        badgeGameOfThrones.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //行尸走肉
                    case R.id.linearSecondFirst:
                        badgeWalkingDead.setBadgeNumber(0);
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
