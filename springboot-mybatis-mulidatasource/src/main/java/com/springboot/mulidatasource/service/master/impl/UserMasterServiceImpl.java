package com.springboot.mulidatasource.service.master.impl;

import com.springboot.mulidatasource.entity.User;
import com.springboot.mulidatasource.mapper.master.UserMasterMapper;
import com.springboot.mulidatasource.service.master.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 15:00
 *
 * @author: zhaojw
 */
@Component
public class UserMasterServiceImpl implements UserMasterService {

    @Autowired
    private UserMasterMapper userMasterMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMasterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMasterMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMasterMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMasterMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMasterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMasterMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> selectUserList() {
        return userMasterMapper.selectUserList();
    }
}
