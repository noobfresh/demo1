package com.example.administrator.demo1.util;

import android.content.Intent;
import android.util.Log;
import android.view.Gravity;

import com.example.administrator.demo1.model.entity.badge.AccpetVoiceVideoBadge;
import com.example.administrator.demo1.model.entity.badge.CardBadge;
import com.example.administrator.demo1.model.entity.badge.FirstLevelBadge;
import com.example.administrator.demo1.model.entity.badge.SettingBadge;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import q.rorbin.badgeview.Badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class BadgeUtil {

    public static final String TAG = "BadgeUtil";

    public static SettingBadge settingBadge = new SettingBadge(1, 1,
            new CardBadge(10,3,5,null,
            new AccpetVoiceVideoBadge(1,1,1,1,
                    1,1,1), null),
            null);

    public static FirstLevelBadge firstLevelBadge = FirstLevelBadge.getInstance();

    public static void badgeSetForTextView(Badge badge, int num){
        badge.setBadgeNumber(num)
                .setExactMode(true)
                .setBadgeGravity(Gravity.CENTER| Gravity.END)
                .setShowShadow(true);
    }


    public static void randomBadge(){
        Random random = new Random();
        //有没什么聪明的办法 - -随机给属性赋值。
        List<Model> modelList = getAllIntField();
        int i = random.nextInt(modelList.size());
        Model model = modelList.get(i);
        try {
            int count = getter(model.object, upperFirstLetter(model.field.getName()), int.class) + 1;
            setter(model.object, upperFirstLetter(model.field.getName()), count, int.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "randomBadge: " + modelList.size());
    }

    public static List<Model> getAllIntField(){
        List<Model> fieldList = new ArrayList<>();
        Field[] fieldsSetting = settingBadge.getClass().getDeclaredFields();
        Field[] fieldsCard = settingBadge.getCardBadge().getClass().getDeclaredFields();
        Field[] fieldsNewMsgNotify = settingBadge.getCardBadge().getNewMsgNotifyBadge().getClass().getDeclaredFields();
        Field[] fieldsVoiceVideo = settingBadge.getCardBadge().getAccpetVoiceVideoBadge().getClass().getDeclaredFields();
        Field[] fieldsVibration = settingBadge.getCardBadge().getVibrationBadge().getClass().getDeclaredFields();
        Field[] fieldsSetting1 = settingBadge.getSetting1Badge().getClass().getDeclaredFields();
        Field[] fieldsAccount = settingBadge.getSetting1Badge().getAccountBadge().getClass().getDeclaredFields();
        Field[] fieldsNewMsgInform = settingBadge.getSetting1Badge().getNewMsgInformBadge().getClass().getDeclaredFields();
        Field[] fieldsPrivacy = settingBadge.getSetting1Badge().getPrivacyBadge().getClass().getDeclaredFields();
        for(Field field : fieldsSetting){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge));
            }
        }
        for(Field field : fieldsCard){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge.getCardBadge()));
            }
        }
        for(Field field : fieldsNewMsgNotify){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge.getCardBadge().getNewMsgNotifyBadge()));
            }
        }
        for(Field field : fieldsVoiceVideo){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge.getCardBadge().getAccpetVoiceVideoBadge()));
            }
        }
        for(Field field : fieldsVibration){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge.getCardBadge().getVibrationBadge()));
            }
        }
        for(Field field : fieldsSetting1){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge.getSetting1Badge()));
            }
        }
        for(Field field : fieldsAccount){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge.getSetting1Badge().getAccountBadge()));
            }
        }
        for(Field field : fieldsNewMsgInform){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge.getSetting1Badge().getNewMsgInformBadge()));
            }
        }
        for(Field field : fieldsPrivacy){
            if(field.getType() == int.class){
                fieldList.add(new Model(field, settingBadge.getSetting1Badge().getPrivacyBadge()));
            }
        }
        return fieldList;
    }

    static class Model{
        Field field;
        Object object;

        public Model() {
        }

        public Model(Field field, Object object) {
            this.field = field;
            this.object = object;
        }
    }


    private static void setter(Object object, String attr, Object value, Class type){
        try{
            Method method = object.getClass().getMethod("set" + attr, type);
            method.invoke(object, value);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    private static int getter(Object object, String attr, Class type){
        try{
            Method method = object.getClass().getMethod("get" + attr);
            Object ans = method.invoke(object);
            return (int) ans;
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    private static String upperFirstLetter(String attr){
        return attr.substring(0,1).toUpperCase() + attr.substring(1);
    }

}
