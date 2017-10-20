package com.springboot.mulidatasource.service.slave.impl;

import com.springboot.mulidatasource.entity.User;
import com.springboot.mulidatasource.mapper.slave.UserSlaveMapper;
import com.springboot.mulidatasource.service.slave.UserSlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 14:58
 *
 * @author: zhaojw
 */
@Component
public class UserSlaveServiceImpl implements UserSlaveService {

    @Autowired
    private UserSlaveMapper userSlaveMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userSlaveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userSlaveMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userSlaveMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userSlaveMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userSlaveMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userSlaveMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> selectUserList() {
        return userSlaveMapper.selectUserList();
    }
}
