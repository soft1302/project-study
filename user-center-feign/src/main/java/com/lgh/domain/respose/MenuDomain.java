package com.lgh.domain.respose;

public class MenuDomain {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 菜单id
     */
    
    private Short menuId;

    /**
     * 父菜单id
     */
    
    private Short menuParentId;

    /**
     * 角色名称
     */
    
    private String menuName;

    /**
     * 菜单路径
     */
    
    private String menuUrl;

    /**
     * 菜单状态，0-不启用，1-启用
     */
    
    private Boolean menuState;

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

    public Short getMenuId() {
        return menuId;
    }

    public void setMenuId(Short menuId) {
        this.menuId = menuId;
    }

    public Short getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Short menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Boolean getMenuState() {
        return menuState;
    }

    public void setMenuState(Boolean menuState) {
        this.menuState = menuState;
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
        return "MenuDomain{" +
                "id=" + id +
                ", menuId=" + menuId +
                ", menuParentId=" + menuParentId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuState=" + menuState +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
