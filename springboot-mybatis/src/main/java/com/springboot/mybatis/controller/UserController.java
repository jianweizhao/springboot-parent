package com.springboot.mybatis.controller;

import com.springboot.mybatis.entity.User;
import com.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 10:17
 *
 * @author: zhaojw
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String insertUser(User user){
       int count = userService.insertSelective(user);
        if (count>0){
            return "插入成功，id为"+user.getId();
        }
        return "插入失败";
    }

    @GetMapping("/init")
    public String init(){
        return "hello spring boot!";
    }
}
