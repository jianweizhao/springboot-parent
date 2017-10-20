package com.springboot.redis.entity;

import java.io.Serializable;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 19:17
 *
 * @author: zhaojw
 */
public class UserForRedis implements Serializable {

    private String userName;

    private String userEmail;

    private String userPassword;

    public UserForRedis(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
