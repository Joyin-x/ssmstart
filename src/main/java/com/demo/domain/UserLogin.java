package com.demo.domain;

/**
 * @author wwx
 * @date 2019/2/21 18:16
 **/
public class UserLogin {
    private String userId;
    private String password;
    private String salt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
