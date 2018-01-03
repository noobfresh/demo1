package com.example.administrator.demo1.model.entity.json;

/**
 * Created by Administrator on 2017/12/25.
 */

public class HomeNewsBeanImage {
    private String height;
    private String width;
    private String url;

    public HomeNewsBeanImage(String height, String width, String url) {
        this.height = height;
        this.width = width;
        this.url = url;
    }

    public HomeNewsBeanImage() {
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
