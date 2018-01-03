package com.example.administrator.demo1.model.entity;

/**
 * Created by Administrator on 2017/12/21.
 */

public class Photo {
    private Integer id;

    private String description;

    private Integer photoId;

    private Boolean isRead;

    public Photo(Integer id, String description, Integer photoId, Boolean isRead) {
        this.id = id;
        this.description = description;
        this.photoId = photoId;
        this.isRead = isRead;
    }

    public Photo(String description, Integer photoId,Boolean isRead) {
        this.description = description;
        this.photoId = photoId;
        this.isRead = isRead;
    }

    public Photo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean read) {
        isRead = read;
    }
}
