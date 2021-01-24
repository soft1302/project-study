package com.lgh.model;


import javax.persistence.Column;
import javax.persistence.Id;

public class Logon {
    /**
     * 主键id
     */
    @Id
    private String token;

    /**
     * 用户表的id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 登录时间
     */
    @Column(name = "logon_time")
    private Long logonTime;

    /**
     * 会话数据
     */
    @Column(name = "resource_data")
    private String resourceData;

    /**
     * 获取主键id
     *
     * @return token - 主键id
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置主键id
     *
     * @param token 主键id
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取用户表的id
     *
     * @return user_id - 用户表的id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户表的id
     *
     * @param userId 用户表的id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取登录时间
     *
     * @return logon_time - 登录时间
     */
    public Long getLogonTime() {
        return logonTime;
    }

    /**
     * 设置登录时间
     *
     * @param logonTime 登录时间
     */
    public void setLogonTime(Long logonTime) {
        this.logonTime = logonTime;
    }

    /**
     * 获取会话数据
     *
     * @return resource_data - 会话数据
     */
    public String getResourceData() {
        return resourceData;
    }

    /**
     * 设置会话数据
     *
     * @param resourceData 会话数据
     */
    public void setResourceData(String resourceData) {
        this.resourceData = resourceData;
    }
}