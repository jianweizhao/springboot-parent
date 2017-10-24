package com.springboot.mq.rabbit.model;

import java.io.Serializable;

/**
 * Created by zhaojw
 * Date: 2017/10/24
 * Time: 9:33
 *
 * @author: zhaojw
 */
public class User implements Serializable{

    private String userName;

    private String age;

    public User(String userName, String age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
