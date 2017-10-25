package com.springboot.shiro.entity;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    private Long id;

    private String available;

    private String description;

    private String role;

    /**
     * 角色对应的权限
     */
    private List<Permission> rolePermissions;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public List<Permission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<Permission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", available='" + available + '\'' +
                ", description='" + description + '\'' +
                ", role='" + role + '\'' +
                ", rolePermissions=" + rolePermissions +
                '}';
    }
}