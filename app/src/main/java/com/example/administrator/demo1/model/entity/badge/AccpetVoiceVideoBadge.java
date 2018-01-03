package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class AccpetVoiceVideoBadge {

    private int brokeGirls;
    private int howIMetYourMother;
    private int bigBang;
    private int modernFamily;
    private int friends;
    private int gameOfThrones;
    private int walkingDead;

    public AccpetVoiceVideoBadge() {
    }

    public AccpetVoiceVideoBadge(int brokeGirls, int howIMetYourMother,
                                 int bigBang, int modernFamily,
                                 int friends, int gameOfThrones, int walkingDead) {
        this.brokeGirls = brokeGirls;
        this.howIMetYourMother = howIMetYourMother;
        this.bigBang = bigBang;
        this.modernFamily = modernFamily;
        this.friends = friends;
        this.gameOfThrones = gameOfThrones;
        this.walkingDead = walkingDead;
    }

    public int getBrokeGirls() {
        return brokeGirls;
    }

    public void setBrokeGirls(int brokeGirls) {
        this.brokeGirls = brokeGirls;
    }

    public int getHowIMetYourMother() {
        return howIMetYourMother;
    }

    public void setHowIMetYourMother(int howIMetYourMother) {
        this.howIMetYourMother = howIMetYourMother;
    }

    public int getBigBang() {
        return bigBang;
    }

    public void setBigBang(int bigBang) {
        this.bigBang = bigBang;
    }

    public int getModernFamily() {
        return modernFamily;
    }

    public void setModernFamily(int modernFamily) {
        this.modernFamily = modernFamily;
    }

    public int getFriends() {
        return friends;
    }

    public void setFriends(int friends) {
        this.friends = friends;
    }

    public int getGameOfThrones() {
        return gameOfThrones;
    }

    public void setGameOfThrones(int gameOfThrones) {
        this.gameOfThrones = gameOfThrones;
    }

    public int getWalkingDead() {
        return walkingDead;
    }

    public void setWalkingDead(int walkingDead) {
        this.walkingDead = walkingDead;
    }

    public int getTotal(){
        return brokeGirls
                + howIMetYourMother
                + bigBang
                + modernFamily
                + friends
                + gameOfThrones
                + walkingDead;
    }
}
