package com.demo.domain.employee;

/**
 * @author wwx
 * @date 2019/2/21 18:16
 **/
public class UserLogin {
    private int userId;
    private String phone;
    private String password;
    private int flag;
    private String picture;

    public UserLogin() {
    }

    public UserLogin(int userId, String phone, String password, int flag, String picture) {
        this.userId = userId;
        this.phone = phone;
        this.password = password;
        this.flag = flag;
        this.picture = picture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userId=" + userId +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", flag=" + flag +
                ", picture='" + picture + '\'' +
                '}';
    }
}
