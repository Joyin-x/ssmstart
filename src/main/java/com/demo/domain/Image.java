package com.demo.domain;


/**
 * @author wwx
 * @date 2019/1/27 16:02
 **/
public class Image {
    private String picture;
    private int userId;


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Image{" +
                "picture='" + picture + '\'' +
                ", userId=" + userId +
                '}';
    }
}
