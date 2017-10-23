package com.springboot.mq.controller;


import com.springboot.mq.dao.UserRepository;
import com.springboot.mq.entity.UserForJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 18:39
 *
 * @author: zhaojw
 */

@RestController
public class JpaController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public UserForJpa addUser(UserForJpa userForJpa){
        userRepository.save(userForJpa);
        return userForJpa;
    }

    @GetMapping("/getUsers")
    public Map<String,Object> getUserList(){
        Map<String,Object> dataMap=new HashMap<>();
        int page=1,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<UserForJpa> userForJpas = userRepository.findAll(pageable);
        dataMap.put("users",userForJpas);
        Long count=userRepository.count();
        dataMap.put("count",count);
        return dataMap;
    }

    @GetMapping("/getUserById")
    public UserForJpa getUserById(Long id){
        return userRepository.findOne(id);
    }

    @GetMapping("/getUserByName")
    public UserForJpa getUserByName(String name){
        return userRepository.findByUserName(name);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(Long id){
        userRepository.delete(id);
    }

    @GetMapping("/getUsersByNickNameOrEmail")
    public Map<String,Object> findByNickNameOrUserEmail(String nickName,String userEmail){
        Map<String,Object> dataMap=new HashMap<>();
        List<UserForJpa> userForJpas = userRepository.findByNickNameAndUserEmail(nickName,userEmail);
        dataMap.put("users",userForJpas);
        Long count=userRepository.count();
        dataMap.put("count",count);
        return dataMap;
    }

    @GetMapping("/findByUserNameLike")
    public Map<String,Object> findByUserNameLike(String userName){
        Map<String,Object> dataMap=new HashMap<>();
        //List<UserForJpa> userForJpas = userRepository.findByUserNameLike(userName);
        int page=1,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<UserForJpa> userForJpas=userRepository.findByUserNameLike(userName,pageable);
        dataMap.put("users",userForJpas);
        Long count=userRepository.countByUserNameLike(userName);
        dataMap.put("count",count);
        return dataMap;
    }

    @PostMapping("/modifyUser")
    public String modifyUser(String userName,Long id){
        int result=userRepository.modifyByIdAndUserId(userName,id);
        if (result>0){
            return "更新成功";
        }
        return "更新失败";
    }

    @DeleteMapping("/deleteByUserId")
    public void deleteByUserId(Long id){
        userRepository.deleteByUserId(id);
    }

    @GetMapping("/modifyFindUser")
    public Map<String,Object>  modifyFindUser(String userName){
        Map<String,Object> dataMap=new HashMap<>();
        int page=1,size=10;
        Pageable pageable = new PageRequest(page, size);
        Page<UserForJpa> userForJpas=userRepository.findByUserNameLikeAndPage(userName,pageable);
        dataMap.put("users",userForJpas);
        return dataMap;
    }
}
