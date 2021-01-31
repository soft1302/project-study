package com.lgh.domain.respose;

public class ResourceDomain {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 资源code
     */
    
    private String resourceCode;

    /**
     * 资源路径
     */
    
    private String resourceUrl;

    /**
     * 资源描述
     */
    
    private String resourceDescription;

    /**
     * 状态，0-不启用，1-启用
     */
    
    private Boolean resourceState;

    /**
     * 创建时间
     */
    
    private Long createTime;

    /**
     * 最后更新时间
     */
    
    private Long updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public Boolean getResourceState() {
        return resourceState;
    }

    public void setResourceState(Boolean resourceState) {
        this.resourceState = resourceState;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ResourceDomain{" +
                "id=" + id +
                ", resourceCode='" + resourceCode + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", resourceDescription='" + resourceDescription + '\'' +
                ", resourceState=" + resourceState +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
