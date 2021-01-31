package com.lgh.model;

import javax.persistence.*;

@Table(name = "role_resource")
public class RoleResource {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 菜单id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 资源id
     */
    @Column(name = "resource_id")
    private Integer resourceId;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单id
     *
     * @return role_id - 菜单id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置菜单id
     *
     * @param roleId 菜单id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取资源id
     *
     * @return resource_id - 资源id
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源id
     *
     * @param resourceId 资源id
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}