package com.example.administrator.demo1.model.entity.badge;

/**
 * Created by Administrator on 2017/12/28.
 */

public class SettingBadge {

    private int collectBadge;
    private int albumBadge;

    private CardBadge cardBadge;
    private Setting1Badge setting1Badge;

    public SettingBadge() {
        this.cardBadge = new CardBadge();
        this.setting1Badge = new Setting1Badge();
    }

    public SettingBadge(int collectBadge, int albumBadge,
                        CardBadge cardBadge, Setting1Badge setting1Badge) {
        this.collectBadge = collectBadge;
        this.albumBadge = albumBadge;
        //如果为Null要不要默认初始化为0呢
        if(cardBadge == null){
            this.cardBadge = new CardBadge();
        }else {
            this.cardBadge = cardBadge;
        }
        if(setting1Badge == null){
            this.setting1Badge = new Setting1Badge();
        }else {
            this.setting1Badge = setting1Badge;
        }
    }

    public int getCollectBadge() {
        return collectBadge;
    }

    public void setCollectBadge(int collectBadge) {
        this.collectBadge = collectBadge;
    }

    public int getAlbumBadge() {
        return albumBadge;
    }

    public void setAlbumBadge(int albumBadge) {
        this.albumBadge = albumBadge;
    }

    public CardBadge getCardBadge() {
        return cardBadge;
    }

    public void setCardBadge(CardBadge cardBadge) {
        this.cardBadge = cardBadge;
    }

    public Setting1Badge getSetting1Badge() {
        return setting1Badge;
    }

    public void setSetting1Badge(Setting1Badge setting1Badge) {
        this.setting1Badge = setting1Badge;
    }

    public int getTotal(){
        return collectBadge
                + albumBadge
                + cardBadge.getTotal()
                + setting1Badge.getTotal();
    }
}
