package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class NewMsgInformBadge {

    private int think;
    private int know;
    private int hottest;
    private int completion;
    private int de;
    private int movie;
    private int questionMark;

    public NewMsgInformBadge(int think, int know,
                             int hottest, int completion,
                             int de, int movie, int questionMark) {
        this.think = think;
        this.know = know;
        this.hottest = hottest;
        this.completion = completion;
        this.de = de;
        this.movie = movie;
        this.questionMark = questionMark;
    }

    public NewMsgInformBadge() {
    }

    public int getThink() {
        return think;
    }

    public void setThink(int think) {
        this.think = think;
    }

    public int getKnow() {
        return know;
    }

    public void setKnow(int know) {
        this.know = know;
    }

    public int getHottest() {
        return hottest;
    }

    public void setHottest(int hottest) {
        this.hottest = hottest;
    }

    public int getCompletion() {
        return completion;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    public int getDe() {
        return de;
    }

    public void setDe(int de) {
        this.de = de;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(int questionMark) {
        this.questionMark = questionMark;
    }

    public int getTotal(){
        return think
                + know
                + hottest
                + completion
                + de
                + movie
                + questionMark;
    }
}
