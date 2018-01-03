package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class AccountBadge {

    private int email;
    private int hello;
    private int thisIs;
    private int huanJu;
    private int times;
    private int company;
    private int carnival;

    public AccountBadge() {
    }

    public AccountBadge(int email, int hello, int thisIs, int huanJu, int times, int company, int carnival) {
        this.email = email;
        this.hello = hello;
        this.thisIs = thisIs;
        this.huanJu = huanJu;
        this.times = times;
        this.company = company;
        this.carnival = carnival;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public int getHello() {
        return hello;
    }

    public void setHello(int hello) {
        this.hello = hello;
    }

    public int getThisIs() {
        return thisIs;
    }

    public void setThisIs(int thisIs) {
        this.thisIs = thisIs;
    }

    public int getHuanJu() {
        return huanJu;
    }

    public void setHuanJu(int huanJu) {
        this.huanJu = huanJu;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public int getCarnival() {
        return carnival;
    }

    public void setCarnival(int carnival) {
        this.carnival = carnival;
    }

    public int getTotal(){
        return email
                + hello
                + thisIs
                + huanJu
                + times
                + company
                + carnival;
    }
}
