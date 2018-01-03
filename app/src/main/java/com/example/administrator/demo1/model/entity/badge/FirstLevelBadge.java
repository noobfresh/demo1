package com.example.administrator.demo1.model.entity.badge;

import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public class FirstLevelBadge {

    private int a;

    private int b;

    private SecondLevelBadge[] secondLevelBadgeList;

    private static FirstLevelBadge firstLevelBadge;

    public static synchronized FirstLevelBadge getInstance(){
        if(firstLevelBadge == null){
            firstLevelBadge = new FirstLevelBadge(0, 5, new SecondLevelBadge[]{
                    new SecondLevelBadge(1, 25, 1, new ThirdLevelBadge[]{
                            new ThirdLevelBadge(1,1,1,1,1,1,1),
                            new ThirdLevelBadge(1,1,1,1,1,1,1),
                            new ThirdLevelBadge(1,1,1,1,1,1,1)
                    }),
                    new SecondLevelBadge(1, 1, 1, new ThirdLevelBadge[]{
                            new ThirdLevelBadge(),
                            new ThirdLevelBadge(),
                            new ThirdLevelBadge()})
            });
        }
        return firstLevelBadge;
    }

    private FirstLevelBadge(int a, int b, SecondLevelBadge[] secondLevelBadgeList) {
        this.a = a;
        this.b = b;
        this.secondLevelBadgeList = secondLevelBadgeList;
    }

    private FirstLevelBadge() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public SecondLevelBadge[] getSecondLevelBadgeList() {
        return secondLevelBadgeList;
    }

    public void setSecondLevelBadgeList(SecondLevelBadge[] secondLevelBadgeList) {
        this.secondLevelBadgeList = secondLevelBadgeList;
    }

    public int getTotal(){
        int temp = 0;
        for(SecondLevelBadge secondLevelBadge : secondLevelBadgeList){
            temp += secondLevelBadge.getTotal();
        }
        return a + b + temp;
    }

}
