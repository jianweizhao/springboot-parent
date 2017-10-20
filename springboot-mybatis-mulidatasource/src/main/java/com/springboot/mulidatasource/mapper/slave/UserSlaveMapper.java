package com.springboot.mulidatasource.mapper.slave;

import com.springboot.mulidatasource.entity.User;

import java.util.List;

public interface UserSlaveMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserList();
}