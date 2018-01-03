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

public class FirstThirdActivity extends AppCompatActivity implements View.OnClickListener{

    private Badge badgeThink;
    private Badge badgeKnow;
    private Badge badgeHottest;
    private Badge badgeCompletion;
    private Badge badgeDe;
    private Badge badgeMovie;
    private Badge badgeQuestionMark;

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
        setContentView(R.layout.activity_first_third);
        badgeThink = new QBadgeView(this).bindTarget(findViewById(R.id.textThink));
        badgeKnow = new QBadgeView(this).bindTarget(findViewById(R.id.textKnow));
        badgeHottest = new QBadgeView(this).bindTarget(findViewById(R.id.textHottest));
        badgeCompletion = new QBadgeView(this).bindTarget(findViewById(R.id.textCompletion));
        badgeDe = new QBadgeView(this).bindTarget(findViewById(R.id.textDe));
        badgeMovie = new QBadgeView(this).bindTarget(findViewById(R.id.textMovie));
        badgeQuestionMark = new QBadgeView(this).bindTarget(findViewById(R.id.textQuestionMark));
        BadgeUtil.badgeSetForTextView(badgeThink, BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getThink());
        BadgeUtil.badgeSetForTextView(badgeKnow, BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getKnow());
        BadgeUtil.badgeSetForTextView(badgeHottest, BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getHottest());
        BadgeUtil.badgeSetForTextView(badgeCompletion, BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getCompletion());
        BadgeUtil.badgeSetForTextView(badgeDe, BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getDe());
        BadgeUtil.badgeSetForTextView(badgeMovie, BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getMovie());
        BadgeUtil.badgeSetForTextView(badgeQuestionMark, BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().getQuestionMark());

        //想
        linearLayout1 = findViewById(R.id.linearFirstThird5);
        //知道
        linearLayout2 = findViewById(R.id.linearFirstThird1);
        //最热
        linearLayout3 = findViewById(R.id.linearFirstThird2);
        //最全
        linearLayout4 = findViewById(R.id.linearFirstThird3);
        //的
        linearLayout5 = findViewById(R.id.linearFirstThird4);
        //电影
        linearLayout6 = findViewById(R.id.linearFirstThird6);
        //吗？
        linearLayout7 = findViewById(R.id.linearFirstThird);

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
            //想
            case R.id.linearFirstThird5:
                BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().setThink(0);
                updateBadge(R.id.linearFirstThird5);
                break;
            //知道
            case R.id.linearFirstThird1:
                BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().setKnow(0);
                updateBadge(R.id.linearFirstThird1);
                break;
            //最热
            case R.id.linearFirstThird2:
                BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().setHottest(0);
                updateBadge(R.id.linearFirstThird2);
                break;
            //最全
            case R.id.linearFirstThird3:
                BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().setCompletion(0);
                updateBadge(R.id.linearFirstThird3);
                break;
            //的
            case R.id.linearFirstThird4:
                BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().setDe(0);
                updateBadge(R.id.linearFirstThird4);
                break;
            //电影
            case R.id.linearFirstThird6:
                BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().setMovie(0);
                updateBadge(R.id.linearFirstThird6);
                break;
            //吗？
            case R.id.linearFirstThird:
                BadgeUtil.settingBadge.getSetting1Badge().getNewMsgInformBadge().setQuestionMark(0);
                updateBadge(R.id.linearFirstThird);
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
                    //想
                    case R.id.linearFirstThird5:
                        badgeThink.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //知道
                    case R.id.linearFirstThird1:
                        badgeKnow.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //最热
                    case R.id.linearFirstThird2:
                        badgeHottest.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //最全
                    case R.id.linearFirstThird3:
                        badgeCompletion.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //的
                    case R.id.linearFirstThird4:
                        badgeDe.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //电影
                    case R.id.linearFirstThird6:
                        badgeMovie.setBadgeNumber(0);
                        //
                        intent.putExtra("update", true);
                        break;
                    //吗？
                    case R.id.linearFirstThird:
                        badgeQuestionMark.setBadgeNumber(0);
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
