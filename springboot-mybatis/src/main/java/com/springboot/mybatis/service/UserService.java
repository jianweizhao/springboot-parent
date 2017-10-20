package com.springboot.mybatis.service;

import com.springboot.mybatis.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 10:15
 *
 * @author: zhaojw
 */

public interface UserService {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

   // List<User> selectAllUser();
}
