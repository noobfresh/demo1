package com.example.administrator.demo1.model.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/21.
 */

public class Comment {

    private Integer id;

    private Date date;

    private Integer newsId;

    private String content;

    private Integer userId;

    public Comment(Integer id, Date date, Integer newsId, String content, Integer userId) {
        this.id = id;
        this.date = date;
        this.newsId = newsId;
        this.content = content;
        this.userId = userId;
    }

    public Comment(Date date, Integer newsId, String content, Integer userId) {
        this.date = date;
        this.newsId = newsId;
        this.content = content;
        this.userId = userId;
    }

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
