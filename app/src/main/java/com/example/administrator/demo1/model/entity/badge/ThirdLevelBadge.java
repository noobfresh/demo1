package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2018/1/3.
 */

public class ThirdLevelBadge {

    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;


    public ThirdLevelBadge() {
    }

    public ThirdLevelBadge(int a, int b, int c, int d, int e, int f, int g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
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

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getTotal(){
        return a + b + c + d + e + f + g;
    }
}
