package com.springboot.shiro.mapper;

import com.springboot.shiro.entity.Permission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 查询角色对应的权限信息
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionByRoleId(Long roleId);
}