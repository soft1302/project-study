package com.lgh.model;

import javax.persistence.*;

@Table(name = "tb_role")
public class Role {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Short roleId;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 状态，0-不启用，1-启用
     */
    @Column(name = "role_state")
    private Boolean roleState;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

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
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Short getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取状态，0-不启用，1-启用
     *
     * @return role_state - 状态，0-不启用，1-启用
     */
    public Boolean getRoleState() {
        return roleState;
    }

    /**
     * 设置状态，0-不启用，1-启用
     *
     * @param roleState 状态，0-不启用，1-启用
     */
    public void setRoleState(Boolean roleState) {
        this.roleState = roleState;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}