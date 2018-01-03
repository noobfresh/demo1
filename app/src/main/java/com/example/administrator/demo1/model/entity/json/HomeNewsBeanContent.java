package com.example.administrator.demo1.model.entity.json;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25.
 */

public class HomeNewsBeanContent {
    private String id;
    private String havePic;
    private String pubDate;
    private String title;
    private String channelName;
    private String desc;
    private String source;
    private String channelId;
    private String link;
    private String hasAll;
    private List<HomeNewsBeanImage> imageurls;

    public HomeNewsBeanContent(String id, String havePic,
                               String pubDate, String title,
                               String channelName, String desc,
                               String source, String channelId,
                               String link, String hasAll,
                               List<HomeNewsBeanImage> imageurls) {
        this.id = id;
        this.havePic = havePic;
        this.pubDate = pubDate;
        this.title = title;
        this.channelName = channelName;
        this.desc = desc;
        this.source = source;
        this.channelId = channelId;
        this.link = link;
        this.hasAll = hasAll;
        this.imageurls = imageurls;
    }

    public HomeNewsBeanContent() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHavePic() {
        return havePic;
    }

    public void setHavePic(String havePic) {
        this.havePic = havePic;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHasAll() {
        return hasAll;
    }

    public void setHasAll(String hasAll) {
        this.hasAll = hasAll;
    }

    public List<HomeNewsBeanImage> getImageurls() {
        return imageurls;
    }

    public void setImageurls(List<HomeNewsBeanImage> imageurls) {
        this.imageurls = imageurls;
    }
}
