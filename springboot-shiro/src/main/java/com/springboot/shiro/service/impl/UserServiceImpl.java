package com.springboot.shiro.service.impl;

import com.springboot.shiro.entity.Permission;
import com.springboot.shiro.entity.Role;
import com.springboot.shiro.entity.User;
import com.springboot.shiro.mapper.PermissionMapper;
import com.springboot.shiro.mapper.RoleMapper;
import com.springboot.shiro.mapper.UserMapper;
import com.springboot.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhaojw
 * Date: 2017/10/25
 * Time: 14:58
 *
 * @author: zhaojw
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 根据登陆账户查询user
     *
     * @param name
     * @return
     */
    @Override
    public User selectUserByName(String name) {
        User user=userMapper.selectUserByName(name);
        if (user!=null){
            Long userId=user.getId();
            //查询对应的用户-角色关系
            List<Role> roles=roleMapper.selectRoleByUserId(userId);
            if (roles!=null){
                for(Role role:roles){
                    List<Permission> permissions=permissionMapper.selectPermissionByRoleId(role.getId());
                    role.setRolePermissions(permissions);
                }
            }
            user.setUserRoles(roles);
        }
        return user;
    }
}
