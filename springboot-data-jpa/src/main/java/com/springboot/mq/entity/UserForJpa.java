package com.springboot.mq.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 18:27
 *
 * @author: zhaojw
 */
@Entity
@Table(name = "tb_user")
public class UserForJpa implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false, unique = true)
    private String userEmail;
    @Column(nullable = true, unique = true)
    private String nickName;
    @Column(nullable = false)
    private String regTime;

    public UserForJpa() {
    }

    public UserForJpa(String userName, String passWord, String userEmail, String nickName, String regTime) {
        this.userName = userName;
        this.passWord = passWord;
        this.userEmail = userEmail;
        this.nickName = nickName;
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
}
