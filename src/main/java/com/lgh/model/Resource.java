package com.lgh.model;

import javax.persistence.*;

@Table(name = "tb_resource")
public class Resource {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 资源code
     */
    @Column(name = "resource_code")
    private String resourceCode;

    /**
     * 资源路径
     */
    @Column(name = "resource_url")
    private String resourceUrl;

    /**
     * 资源描述
     */
    @Column(name = "resource_description")
    private String resourceDescription;

    /**
     * 状态，0-不启用，1-启用
     */
    @Column(name = "resource_state")
    private Boolean resourceState;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 最后更新时间
     */
    @Column(name = "update_time")
    private Long updateTime;

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
     * 获取资源code
     *
     * @return resource_code - 资源code
     */
    public String getResourceCode() {
        return resourceCode;
    }

    /**
     * 设置资源code
     *
     * @param resourceCode 资源code
     */
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    /**
     * 获取资源路径
     *
     * @return resource_url - 资源路径
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 设置资源路径
     *
     * @param resourceUrl 资源路径
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    /**
     * 获取资源描述
     *
     * @return resource_description - 资源描述
     */
    public String getResourceDescription() {
        return resourceDescription;
    }

    /**
     * 设置资源描述
     *
     * @param resourceDescription 资源描述
     */
    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    /**
     * 获取状态，0-不启用，1-启用
     *
     * @return resource_state - 状态，0-不启用，1-启用
     */
    public Boolean getResourceState() {
        return resourceState;
    }

    /**
     * 设置状态，0-不启用，1-启用
     *
     * @param resourceState 状态，0-不启用，1-启用
     */
    public void setResourceState(Boolean resourceState) {
        this.resourceState = resourceState;
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

    /**
     * 获取最后更新时间
     *
     * @return update_time - 最后更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最后更新时间
     *
     * @param updateTime 最后更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}