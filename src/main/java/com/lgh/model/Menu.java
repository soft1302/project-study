package com.lgh.model;


import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "tb_menu")
public class Menu {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 菜单id
     */
    @Column(name = "menu_id")
    private Short menuId;

    /**
     * 父菜单id
     */
    @Column(name = "menu_parent_id")
    private Short menuParentId;

    /**
     * 角色名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 菜单路径
     */
    @Column(name = "menu_url")
    private String menuUrl;

    /**
     * 菜单状态，0-不启用，1-启用
     */
    @Column(name = "menu_state")
    private Boolean menuState;

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
     * 获取菜单id
     *
     * @return menu_id - 菜单id
     */
    public Short getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单id
     *
     * @param menuId 菜单id
     */
    public void setMenuId(Short menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取父菜单id
     *
     * @return menu_parent_id - 父菜单id
     */
    public Short getMenuParentId() {
        return menuParentId;
    }

    /**
     * 设置父菜单id
     *
     * @param menuParentId 父菜单id
     */
    public void setMenuParentId(Short menuParentId) {
        this.menuParentId = menuParentId;
    }

    /**
     * 获取角色名称
     *
     * @return menu_name - 角色名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置角色名称
     *
     * @param menuName 角色名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取菜单路径
     *
     * @return menu_url - 菜单路径
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 设置菜单路径
     *
     * @param menuUrl 菜单路径
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    /**
     * 获取菜单状态，0-不启用，1-启用
     *
     * @return menu_state - 菜单状态，0-不启用，1-启用
     */
    public Boolean getMenuState() {
        return menuState;
    }

    /**
     * 设置菜单状态，0-不启用，1-启用
     *
     * @param menuState 菜单状态，0-不启用，1-启用
     */
    public void setMenuState(Boolean menuState) {
        this.menuState = menuState;
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