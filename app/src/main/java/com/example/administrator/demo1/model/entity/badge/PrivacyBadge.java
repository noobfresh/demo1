package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class PrivacyBadge {

    private int mail;
    private int username;
    private int banana;
    private int password;
    private int fingerPrint;
    private int security;
    private int runOut;

    public PrivacyBadge(int mail, int username, int banana, int password, int fingerPrint, int security, int runOut) {
        this.mail = mail;
        this.username = username;
        this.banana = banana;
        this.password = password;
        this.fingerPrint = fingerPrint;
        this.security = security;
        this.runOut = runOut;
    }

    public PrivacyBadge() {
    }

    public int getMail() {
        return mail;
    }

    public void setMail(int mail) {
        this.mail = mail;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public int getBanana() {
        return banana;
    }

    public void setBanana(int banana) {
        this.banana = banana;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(int fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public int getRunOut() {
        return runOut;
    }

    public void setRunOut(int runOut) {
        this.runOut = runOut;
    }

    public int getTotal(){
        return mail
                + username
                + banana
                + password
                + fingerPrint
                + security
                + runOut;
    }
}
