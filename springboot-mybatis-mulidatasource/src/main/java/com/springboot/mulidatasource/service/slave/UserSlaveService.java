package com.springboot.mulidatasource.service.slave;

import com.springboot.mulidatasource.entity.User;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/20
 * Time: 14:58
 *
 * @author: zhaojw
 */
public interface UserSlaveService {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserList();
}
