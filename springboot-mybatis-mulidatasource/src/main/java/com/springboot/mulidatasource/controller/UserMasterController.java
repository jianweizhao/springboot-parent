package com.springboot.mulidatasource.controller;


import com.springboot.mulidatasource.entity.User;
import com.springboot.mulidatasource.service.master.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 15:13
 *
 * @author: zhaojw
 */
@RestController
public class UserMasterController {

    @Autowired
    private UserMasterService userMasterService;

    @PostMapping("/addUser")
    public String addUser(User user){
        int count=userMasterService.insertSelective(user);
        if (count>0){
            return "插入成功";
        }
        return "插入失败";
    }

    @GetMapping("/getAllUser")
    public List<User> getUserById(Long id){
        return userMasterService.selectUserList();
    }
}
