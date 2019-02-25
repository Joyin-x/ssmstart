package com.demo.domain;

/**
 * @author wwx
 * @date 2019/2/21 18:16
 **/
public class UserLogin {
    private int userId;
    private String phone;
    private String password;

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

}
