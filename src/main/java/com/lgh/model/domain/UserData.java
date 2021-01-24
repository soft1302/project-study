package com.lgh.model.domain;

import com.lgh.model.Menu;
import com.lgh.model.Resource;

import java.util.List;

public class UserData {

    private String token;
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户id
     */
    
    private String userId;

    /**
     * 用户名
     */
    
    private String userName;

    /**
     * 用户名英文名
     */
    
    private String userEnName;

    /**
     * 用户密码
     */
    
    private String userPassword;

    /**
     * 电话号码
     */
    
    private Integer userPhone;

    /**
     * 性别，0-男 1-女
     */
    
    private Boolean userSex;

    /**
     * 年龄
     */
    
    private Short userAge;

    /**
     * 家庭住址
     */
    
    private String userAddress;

    /**
     * 是否已婚，0-未婚，1-已婚
     */
    
    private Boolean userMarryState;

    /**
     * 用户状态，0-信息不完整，1-正常状态，2-已注销
     */
    
    private Boolean userState;

    /**
     * 用户职业，1-事业单位，2-程序员，具体参考职业表
     */
    
    private Byte userJobType;

    /**
     * 证件号
     */
    
    private String userIdCard;

    /**
     * 用户邮箱
     */
    
    private String userEmail;

    /**
     * 用户生日
     */
    
    private String userBirthday;

    private String roleName;

    /**
     * 用户访问的后台资源
     */
    private List<Resource> userResources;

    private List<Menu> userMenus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEnName() {
        return userEnName;
    }

    public void setUserEnName(String userEnName) {
        this.userEnName = userEnName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public Short getUserAge() {
        return userAge;
    }

    public void setUserAge(Short userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Boolean getUserMarryState() {
        return userMarryState;
    }

    public void setUserMarryState(Boolean userMarryState) {
        this.userMarryState = userMarryState;
    }

    public Boolean getUserState() {
        return userState;
    }

    public void setUserState(Boolean userState) {
        this.userState = userState;
    }

    public Byte getUserJobType() {
        return userJobType;
    }

    public void setUserJobType(Byte userJobType) {
        this.userJobType = userJobType;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Resource> getUserResources() {
        return userResources;
    }

    public void setUserResources(List<Resource> userResources) {
        this.userResources = userResources;
    }

    public List<Menu> getUserMenus() {
        return userMenus;
    }

    public void setUserMenus(List<Menu> userMenus) {
        this.userMenus = userMenus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
