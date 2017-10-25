package com.springboot.shiro.mapper;

import com.springboot.shiro.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据userid查询对应的角色
     * @param userId
     * @return
     */
    List<Role> selectRoleByUserId(Long userId);
}