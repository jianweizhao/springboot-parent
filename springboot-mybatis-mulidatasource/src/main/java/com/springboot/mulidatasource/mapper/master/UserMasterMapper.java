package com.springboot.mulidatasource.mapper.master;

import com.springboot.mulidatasource.entity.User;

import java.util.List;

public interface UserMasterMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserList();
}