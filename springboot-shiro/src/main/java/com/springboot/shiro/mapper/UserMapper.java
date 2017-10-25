package com.springboot.shiro.mapper;

import com.springboot.shiro.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据登陆账户查询user
     * @param name
     * @return
     */
    User selectUserByName(String name);
}