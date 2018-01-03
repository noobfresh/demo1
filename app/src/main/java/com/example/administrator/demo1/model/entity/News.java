package com.example.administrator.demo1.model.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/21.
 */

public class News {

    private String id;

    private String title;

    private String content;

    private String author;

    private Date date;

    private Integer like;

    private Integer comment;

    public News() {
    }

    public News(String id, String title,
                String content, String author,
                Date date, Integer like, Integer comment) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.like = like;
        this.comment = comment;
    }

    public News(String title, String content,
                String author, Date date,
                Integer like, Integer comment) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.like = like;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }
}
