package com.springboot.shiro.service;

import com.springboot.shiro.entity.User;

/**
 * Created by zhaojw
 * Date: 2017/10/25
 * Time: 14:57
 *
 * @author: zhaojw
 */
public interface UserService {

    /**
     * 根据登陆账户查询user
     * @param name
     * @return
     */
    User selectUserByName(String name);
}
