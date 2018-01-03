package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class CardBadge {

    private int voice;
    private int nonAccpetMsg;
    private int pay;

    private NewMsgNotifyBadge newMsgNotifyBadge;
    private AccpetVoiceVideoBadge accpetVoiceVideoBadge;
    private VibrationBadge vibrationBadge;

    public CardBadge() {
        this.newMsgNotifyBadge = new NewMsgNotifyBadge();
        this.accpetVoiceVideoBadge = new AccpetVoiceVideoBadge();
        this.vibrationBadge = new VibrationBadge();
    }

    public CardBadge(int voice, int nonAccpetMsg, int pay,
                     NewMsgNotifyBadge newMsgNotifyBadge,
                     AccpetVoiceVideoBadge accpetVoiceVideoBadge,
                     VibrationBadge vibrationBadge) {
        this.voice = voice;
        this.nonAccpetMsg = nonAccpetMsg;
        this.pay = pay;
        if(newMsgNotifyBadge == null){
            this.newMsgNotifyBadge = new NewMsgNotifyBadge();
        }
        else {
            this.newMsgNotifyBadge = newMsgNotifyBadge;
        }
        if(accpetVoiceVideoBadge == null){
            this.accpetVoiceVideoBadge = new AccpetVoiceVideoBadge();
        }else {
            this.accpetVoiceVideoBadge = accpetVoiceVideoBadge;
        }
        if(vibrationBadge == null){
            this.vibrationBadge = new VibrationBadge();
        }else {
            this.vibrationBadge = vibrationBadge;
        }
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public int getNonAccpetMsg() {
        return nonAccpetMsg;
    }

    public void setNonAccpetMsg(int nonAccpetMsg) {
        this.nonAccpetMsg = nonAccpetMsg;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public NewMsgNotifyBadge getNewMsgNotifyBadge() {
        return newMsgNotifyBadge;
    }

    public void setNewMsgNotifyBadge(NewMsgNotifyBadge newMsgNotifyBadge) {
        this.newMsgNotifyBadge = newMsgNotifyBadge;
    }

    public AccpetVoiceVideoBadge getAccpetVoiceVideoBadge() {
        return accpetVoiceVideoBadge;
    }

    public void setAccpetVoiceVideoBadge(AccpetVoiceVideoBadge accpetVoiceVideoBadge) {
        this.accpetVoiceVideoBadge = accpetVoiceVideoBadge;
    }

    public VibrationBadge getVibrationBadge() {
        return vibrationBadge;
    }

    public void setVibrationBadge(VibrationBadge vibrationBadge) {
        this.vibrationBadge = vibrationBadge;
    }

    public int getTotal(){
        return voice
                + nonAccpetMsg
                + pay
                + accpetVoiceVideoBadge.getTotal()
                + newMsgNotifyBadge.getTotal()
                + vibrationBadge.getTotal();
    }
}
