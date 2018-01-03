package com.example.administrator.demo1.view.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.demo1.R;
import com.example.administrator.demo1.model.entity.badge.FirstLevelBadge;
import com.example.administrator.demo1.model.entity.badge.SecondLevelBadge;
import com.example.administrator.demo1.util.BadgeUtil;
import com.example.administrator.demo1.util.DBUtil;
import com.example.administrator.demo1.view.Activity.FirstSettingActivity;
import com.example.administrator.demo1.view.Activity.MainActivity;
import com.example.administrator.demo1.view.Activity.SecondSettingActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by Administrator on 2017/12/21.
 */

public class SettingFragment extends Fragment implements View.OnClickListener{

    public static final String TAG = "SettingFragment";


    private Map<Integer, Item> itemMap;



    private View settingLayout;
    private View cardLayout;
    private View collectLayout;
    private View albumLayout;
    private Intent intent = new Intent();
    private Badge badgeCollect;
    private Badge badgeCard;
    private Badge badgeAlbum;
    private Badge badgeSetting;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_setting, container, false);

        mainActivity = (MainActivity)getActivity();
//        settingLayout = view.findViewById(R.id.linear4);
//        settingLayout.setOnClickListener(this);
//        cardLayout = view.findViewById(R.id.linear2);
//        cardLayout.setOnClickListener(this);
//        collectLayout = view.findViewById(R.id.linear1);
//        collectLayout.setOnClickListener(this);
//        albumLayout = view.findViewById(R.id.linear3);
//        albumLayout.setOnClickListener(this);
//        badgeCollect = new QBadgeView(getContext())
//                .bindTarget(view.findViewById(R.id.textCollect));
//        BadgeUtil.badgeSetForTextView(badgeCollect, BadgeUtil.settingBadge.getCollectBadge());
//        badgeCard = new QBadgeView(getContext())
//                .bindTarget(view.findViewById(R.id.textCard));
//        BadgeUtil.badgeSetForTextView(badgeCard, BadgeUtil.settingBadge.getCardBadge().getTotal());
//        badgeAlbum = new QBadgeView(getContext())
//                .bindTarget(view.findViewById(R.id.textAlbum));
//        BadgeUtil.badgeSetForTextView(badgeAlbum, BadgeUtil.settingBadge.getAlbumBadge());
//        badgeSetting = new QBadgeView(getContext())
//                .bindTarget(view.findViewById(R.id.textSetting));
//        BadgeUtil.badgeSetForTextView(badgeSetting, BadgeUtil.settingBadge.getSetting1Badge().getTotal());
        //return view;


        //初始化map
        itemMap = new ArrayMap<>();
        ViewGroup viewGroup = (ViewGroup) view;
        for(int i = 0; i < viewGroup.getChildCount(); i++){
            View view1 = viewGroup.getChildAt(i);
            if(view1 instanceof ViewGroup){
                for(int j = 0; j < ((ViewGroup) view1).getChildCount(); j++){
                    View view2 = ((ViewGroup) view1).getChildAt(j);
                    if(view2 instanceof ViewGroup){
                        Item item = new Item();
                        view2.setOnClickListener(this);
                        item.viewGroup = (ViewGroup) view2;
                        for(int k = 0; k < ((ViewGroup) view2).getChildCount(); k++){
                            View view3 = ((ViewGroup) view2).getChildAt(k);
                            if(view3 instanceof TextView){
                                Badge badge = new QBadgeView(getContext()).bindTarget(view3);
                                item.badge = badge;
                                itemMap.put(view2.getId(), item);
                                break;
                            }
                        }
                    }
                }
            }
        }

        //
        Field[] fields = BadgeUtil.firstLevelBadge.getClass().getFields();
        Set<Integer> set = itemMap.keySet();
        int count = 0;
        //数组下标
        int count1 = 0;
        for(Integer id : set){
            Item item = itemMap.get(id);
            item.attrIndex = count;
            if(fields[count].getType() == int.class || fields[count].getType().equals(Integer.class)){
                BadgeUtil.badgeSetForTextView(item.badge,
                        (Integer) DBUtil.getter(BadgeUtil.firstLevelBadge,
                                DBUtil.upperFirstLetter(fields[count].getName())));
            }else {
                SecondLevelBadge[] secondLevelBadges = (SecondLevelBadge[]) DBUtil.getter(BadgeUtil.firstLevelBadge,
                        DBUtil.upperFirstLetter(fields[count].getName()));
                item.arrayIndex = count1;
                BadgeUtil.badgeSetForTextView(item.badge, secondLevelBadges[count1].getTotal());
                count1++;
            }

            count++;
        }
        return view;
    }


    private int requestCode = 1;

    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.linear2:
//                intent = new Intent(getContext(), SecondSettingActivity.class);
//                startActivityForResult(intent,1);
//                break;
//            case R.id.linear4:
//                intent = new Intent(getContext(), FirstSettingActivity.class);
//                startActivityForResult(intent, 2);
//                break;
//            case R.id.linear1:
//                BadgeUtil.settingBadge.setCollectBadge(0);
//                updateBadgeView(R.id.linear1);
//                break;
//            case R.id.linear3:
//                BadgeUtil.settingBadge.setAlbumBadge(0);
//                updateBadgeView(R.id.linear3);
//                break;
//            default:
//                break;
//        }

        //
        Field[] fields = BadgeUtil.firstLevelBadge.getClass().getFields();
        Item item = itemMap.get(v.getId());
        if(fields[item.attrIndex].getType().equals(SecondLevelBadge[].class)){
            if(item.activityClazz != null){
                intent = new Intent(getContext(), item.activityClazz);
                startActivityForResult(intent,item.arrayIndex);
            }else {
                if(item.arrayIndex == 0){
                    item.activityClazz = SecondSettingActivity.class;
                    intent = new Intent(getContext(), item.activityClazz);
                    startActivityForResult(intent,item.arrayIndex);
                }else {
                    item.activityClazz = FirstSettingActivity.class;
                    intent = new Intent(getContext(), item.activityClazz);
                    startActivityForResult(intent,item.arrayIndex);
                }
            }
        }else {
            DBUtil.setter(BadgeUtil.firstLevelBadge, DBUtil.upperFirstLetter(fields[item.attrIndex].getName()), 0, int.class);
            updateBadgeView(v.getId());
        }
    }

    public void updateBadgeView(final int id){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                switch (id){
//                    //收藏
//                    case R.id.linear1:
//                        badgeCollect.setBadgeNumber(0);
//                        mainActivity.updateSettingBadge();
//                        break;
//                    //相册
//                    case R.id.linear3:
//                        badgeAlbum.setBadgeNumber(0);
//                        mainActivity.updateSettingBadge();
//                        break;
//                    //卡包
//                    case R.id.linear2:
//                        badgeCard.setBadgeNumber(BadgeUtil.settingBadge.getCardBadge().getTotal());
//                        mainActivity.updateSettingBadge();
//                        break;
//                    //设置
//                    case R.id.linear4:
//                        badgeSetting.setBadgeNumber(BadgeUtil.settingBadge.getSetting1Badge().getTotal());
//                        mainActivity.updateSettingBadge();
//                        break;
//                    default:
//                        break;
//                }

                Field[] fields = BadgeUtil.firstLevelBadge.getClass().getFields();
                Item item = itemMap.get(id);
                if(fields[item.attrIndex].getType().equals(SecondLevelBadge[].class)){
                    item.badge.setBadgeNumber(BadgeUtil.firstLevelBadge.getSecondLevelBadgeList()[item.arrayIndex].getTotal());
                }else {
                    item.badge.setBadgeNumber(0);
                }
                mainActivity.updateSettingBadge();
            }
        });

        //

    }

    public void updateSettingBadgeView(){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                badgeCard.setBadgeNumber(BadgeUtil.settingBadge.getCardBadge().getTotal());
//                badgeSetting.setBadgeNumber(BadgeUtil.settingBadge.getSetting1Badge().getTotal());
//                badgeCollect.setBadgeNumber(BadgeUtil.settingBadge.getCollectBadge());
//                badgeAlbum.setBadgeNumber(BadgeUtil.settingBadge.getAlbumBadge());

                //
                Field[] fields = BadgeUtil.firstLevelBadge.getClass().getFields();
                Set<Integer> set = itemMap.keySet();
                for(Integer id : set){
                    Item item = itemMap.get(id);
                    if(fields[item.attrIndex].getType().equals(SecondLevelBadge[].class)){
                        SecondLevelBadge[] secondLevelBadges = (SecondLevelBadge[]) DBUtil.getter(BadgeUtil.firstLevelBadge,
                                DBUtil.upperFirstLetter(fields[item.attrIndex].getName()));
                        item.badge.setBadgeNumber(secondLevelBadges[item.arrayIndex].getTotal());
                    }else {
                        item.badge.setBadgeNumber((Integer) DBUtil.getter(BadgeUtil.firstLevelBadge,
                                DBUtil.upperFirstLetter(fields[item.attrIndex].getName())));
                    }
                }
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == -1 && data.getBooleanExtra("update", false) == true){
                    updateBadgeView(R.id.linear2);
                }
                break;
            case 2:
                if(resultCode == -1 && data.getBooleanExtra("update", false) == true){
                    updateBadgeView(R.id.linear4);
                }
                break;
        }
    }

    static class Item{
        Badge badge;
        Integer attrIndex;
        ViewGroup viewGroup;
        Class activityClazz;
        Integer arrayIndex;

        public Item(Badge badge, Integer attrIndex, ViewGroup viewGroup, Class activityClazz, Integer arrayIndex) {
            this.badge = badge;
            this.attrIndex = attrIndex;
            this.viewGroup = viewGroup;
            this.activityClazz = activityClazz;
            this.arrayIndex = arrayIndex;
        }

        public Item() {
        }
    }
}
