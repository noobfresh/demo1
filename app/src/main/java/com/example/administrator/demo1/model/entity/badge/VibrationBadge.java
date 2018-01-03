package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class VibrationBadge {
    private int agentsOfShield;
    private int charlie;
    private int madMen;
    private int houseOfCard;
    private int americanHorrorStory;
    private int silconValley;
    private int desperateHousewife;

    public VibrationBadge() {
    }

    public VibrationBadge(int agentsOfShield, int charlie,
                          int madMen, int houseOfCard,
                          int americanHorrorStory, int silconValley,
                          int desperateHousewife) {
        this.agentsOfShield = agentsOfShield;
        this.charlie = charlie;
        this.madMen = madMen;
        this.houseOfCard = houseOfCard;
        this.americanHorrorStory = americanHorrorStory;
        this.silconValley = silconValley;
        this.desperateHousewife = desperateHousewife;
    }

    public int getAgentsOfShield() {
        return agentsOfShield;
    }

    public void setAgentsOfShield(int agentsOfShield) {
        this.agentsOfShield = agentsOfShield;
    }

    public int getCharlie() {
        return charlie;
    }

    public void setCharlie(int charlie) {
        this.charlie = charlie;
    }

    public int getMadMen() {
        return madMen;
    }

    public void setMadMen(int madMen) {
        this.madMen = madMen;
    }

    public int getHouseOfCard() {
        return houseOfCard;
    }

    public void setHouseOfCard(int houseOfCard) {
        this.houseOfCard = houseOfCard;
    }

    public int getAmericanHorrorStory() {
        return americanHorrorStory;
    }

    public void setAmericanHorrorStory(int americanHorrorStory) {
        this.americanHorrorStory = americanHorrorStory;
    }

    public int getSilconValley() {
        return silconValley;
    }

    public void setSilconValley(int silconValley) {
        this.silconValley = silconValley;
    }

    public int getDesperateHousewife() {
        return desperateHousewife;
    }

    public void setDesperateHousewife(int desperateHousewife) {
        this.desperateHousewife = desperateHousewife;
    }

    public int getTotal(){
        return agentsOfShield +
                charlie +
                madMen +
                houseOfCard +
                americanHorrorStory +
                silconValley +
                desperateHousewife;

    }
}
