package com.example.administrator.demo1.model.entity;

/**
 * Created by Administrator on 2017/12/21.
 */

public class User {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private Integer iconId;

    public User(Integer id, String username, String password, String email, Integer iconId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.iconId = iconId;
    }

    public User(String username, String password, String email, Integer iconId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.iconId = iconId;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
