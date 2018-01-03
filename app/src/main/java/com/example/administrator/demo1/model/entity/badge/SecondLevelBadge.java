package com.example.administrator.demo1.model.entity.badge;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */

public class SecondLevelBadge {

    private int a;
    private int b;
    private int c;

    private ThirdLevelBadge[] thirdLevelBadgeList;

    public SecondLevelBadge() {
    }

    public SecondLevelBadge(int a, int b, int c, ThirdLevelBadge[] thirdLevelBadgeList) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.thirdLevelBadgeList = thirdLevelBadgeList;
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

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public ThirdLevelBadge[] getThirdLevelBadgeList() {
        return thirdLevelBadgeList;
    }

    public void setThirdLevelBadgeList(ThirdLevelBadge[] thirdLevelBadgeList) {
        this.thirdLevelBadgeList = thirdLevelBadgeList;
    }

    public int getTotal(){
        int temp = 0;
        for(ThirdLevelBadge thirdLevelBadge : thirdLevelBadgeList){
            temp += thirdLevelBadge.getTotal();
        }
        return temp + a + b + c;
    }
}
