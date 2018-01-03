package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class NewMsgNotifyBadge {

    private int kd;
    private int westbrook;
    private int anthony;
    private int george;
    private int zimuge;
    private int cute;
    private int gordan;

    public NewMsgNotifyBadge(int kd, int westbrook,
                             int anthony, int george,
                             int zimuge, int cute, int gordan) {
        this.kd = kd;
        this.westbrook = westbrook;
        this.anthony = anthony;
        this.george = george;
        this.zimuge = zimuge;
        this.cute = cute;
        this.gordan = gordan;
    }

    public NewMsgNotifyBadge() {
    }

    public int getKd() {
        return kd;
    }

    public void setKd(int kd) {
        this.kd = kd;
    }

    public int getWestbrook() {
        return westbrook;
    }

    public void setWestbrook(int westbrook) {
        this.westbrook = westbrook;
    }

    public int getAnthony() {
        return anthony;
    }

    public void setAnthony(int anthony) {
        this.anthony = anthony;
    }

    public int getGeorge() {
        return george;
    }

    public void setGeorge(int george) {
        this.george = george;
    }

    public int getZimuge() {
        return zimuge;
    }

    public void setZimuge(int zimuge) {
        this.zimuge = zimuge;
    }

    public int getCute() {
        return cute;
    }

    public void setCute(int cute) {
        this.cute = cute;
    }

    public int getGordan() {
        return gordan;
    }

    public void setGordan(int gordan) {
        this.gordan = gordan;
    }

    public int getTotal(){
        return kd
                + westbrook
                + anthony
                + george
                + zimuge
                + cute
                + gordan;
    }
}
