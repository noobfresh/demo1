package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class Setting1Badge {

    private int chat;
    private int about;
    private int help;

    private AccountBadge accountBadge;
    private NewMsgInformBadge newMsgInformBadge;
    private PrivacyBadge privacyBadge;

    public Setting1Badge(int chat, int about, int help,
                         AccountBadge accountBadge,
                         NewMsgInformBadge newMsgInformBadge,
                         PrivacyBadge privacyBadge) {
        this.chat = chat;
        this.about = about;
        this.help = help;
        if(accountBadge == null){
            this.accountBadge = new AccountBadge();
        }else {
            this.accountBadge = accountBadge;
        }
        if(newMsgInformBadge == null){
            this.newMsgInformBadge = new NewMsgInformBadge();
        }else {
            this.newMsgInformBadge = newMsgInformBadge;
        }
        if(privacyBadge == null){
            this.privacyBadge = new PrivacyBadge();
        }else {
            this.privacyBadge = privacyBadge;
        }

    }

    public Setting1Badge() {
        this.accountBadge = new AccountBadge();
        this.newMsgInformBadge = new NewMsgInformBadge();
        this.privacyBadge = new PrivacyBadge();

    }

    public int getChat() {
        return chat;
    }

    public void setChat(int chat) {
        this.chat = chat;
    }

    public int getAbout() {
        return about;
    }

    public void setAbout(int about) {
        this.about = about;
    }

    public int getHelp() {
        return help;
    }

    public void setHelp(int help) {
        this.help = help;
    }

    public AccountBadge getAccountBadge() {
        return accountBadge;
    }

    public void setAccountBadge(AccountBadge accountBadge) {
        this.accountBadge = accountBadge;
    }

    public NewMsgInformBadge getNewMsgInformBadge() {
        return newMsgInformBadge;
    }

    public void setNewMsgInformBadge(NewMsgInformBadge newMsgInformBadge) {
        this.newMsgInformBadge = newMsgInformBadge;
    }

    public PrivacyBadge getPrivacyBadge() {
        return privacyBadge;
    }

    public void setPrivacyBadge(PrivacyBadge privacyBadge) {
        this.privacyBadge = privacyBadge;
    }

    public int getTotal(){
        return chat
                + about
                + help
                + accountBadge.getTotal()
                + newMsgInformBadge.getTotal()
                + privacyBadge.getTotal();
    }
}
