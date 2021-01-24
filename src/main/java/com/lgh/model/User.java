package com.lgh.model;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_user")
public class User {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户名英文名
     */
    @Column(name = "user_en_name")
    private String userEnName;

    /**
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 电话号码
     */
    @Column(name = "user_phone")
    private Integer userPhone;

    /**
     * 性别，0-男 1-女
     */
    @Column(name = "user_sex")
    private Boolean userSex;

    /**
     * 年龄
     */
    @Column(name = "user_age")
    private Short userAge;

    /**
     * 家庭住址
     */
    @Column(name = "user_address")
    private String userAddress;

    /**
     * 是否已婚，0-未婚，1-已婚
     */
    @Column(name = "user_marry_state")
    private Boolean userMarryState;

    /**
     * 用户状态，0-信息不完整，1-正常状态，2-已注销
     */
    @Column(name = "user_state")
    private Boolean userState;

    /**
     * 用户职业，1-事业单位，2-程序员，具体参考职业表
     */
    @Column(name = "user_job_type")
    private Byte userJobType;

    /**
     * 证件号
     */
    @Column(name = "user_id_card")
    private String userIdCard;

    /**
     * 用户邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 用户生日
     */
    @Column(name = "user_birthday")
    private String userBirthday;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户名英文名
     *
     * @return user_en_name - 用户名英文名
     */
    public String getUserEnName() {
        return userEnName;
    }

    /**
     * 设置用户名英文名
     *
     * @param userEnName 用户名英文名
     */
    public void setUserEnName(String userEnName) {
        this.userEnName = userEnName;
    }

    /**
     * 获取用户密码
     *
     * @return user_password - 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置用户密码
     *
     * @param userPassword 用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取电话号码
     *
     * @return user_phone - 电话号码
     */
    public Integer getUserPhone() {
        return userPhone;
    }

    /**
     * 设置电话号码
     *
     * @param userPhone 电话号码
     */
    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取性别，0-男 1-女
     *
     * @return user_sex - 性别，0-男 1-女
     */
    public Boolean getUserSex() {
        return userSex;
    }

    /**
     * 设置性别，0-男 1-女
     *
     * @param userSex 性别，0-男 1-女
     */
    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取年龄
     *
     * @return user_age - 年龄
     */
    public Short getUserAge() {
        return userAge;
    }

    /**
     * 设置年龄
     *
     * @param userAge 年龄
     */
    public void setUserAge(Short userAge) {
        this.userAge = userAge;
    }

    /**
     * 获取家庭住址
     *
     * @return user_address - 家庭住址
     */
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * 设置家庭住址
     *
     * @param userAddress 家庭住址
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * 获取是否已婚，0-未婚，1-已婚
     *
     * @return user_marry_state - 是否已婚，0-未婚，1-已婚
     */
    public Boolean getUserMarryState() {
        return userMarryState;
    }

    /**
     * 设置是否已婚，0-未婚，1-已婚
     *
     * @param userMarryState 是否已婚，0-未婚，1-已婚
     */
    public void setUserMarryState(Boolean userMarryState) {
        this.userMarryState = userMarryState;
    }

    /**
     * 获取用户状态，0-信息不完整，1-正常状态，2-已注销
     *
     * @return user_state - 用户状态，0-信息不完整，1-正常状态，2-已注销
     */
    public Boolean getUserState() {
        return userState;
    }

    /**
     * 设置用户状态，0-信息不完整，1-正常状态，2-已注销
     *
     * @param userState 用户状态，0-信息不完整，1-正常状态，2-已注销
     */
    public void setUserState(Boolean userState) {
        this.userState = userState;
    }

    /**
     * 获取用户职业，1-事业单位，2-程序员，具体参考职业表
     *
     * @return user_job_type - 用户职业，1-事业单位，2-程序员，具体参考职业表
     */
    public Byte getUserJobType() {
        return userJobType;
    }

    /**
     * 设置用户职业，1-事业单位，2-程序员，具体参考职业表
     *
     * @param userJobType 用户职业，1-事业单位，2-程序员，具体参考职业表
     */
    public void setUserJobType(Byte userJobType) {
        this.userJobType = userJobType;
    }

    /**
     * 获取证件号
     *
     * @return user_id_card - 证件号
     */
    public String getUserIdCard() {
        return userIdCard;
    }

    /**
     * 设置证件号
     *
     * @param userIdCard 证件号
     */
    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    /**
     * 获取用户邮箱
     *
     * @return user_email - 用户邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置用户邮箱
     *
     * @param userEmail 用户邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取用户生日
     *
     * @return user_birthday - 用户生日
     */
    public String getUserBirthday() {
        return userBirthday;
    }

    /**
     * 设置用户生日
     *
     * @param userBirthday 用户生日
     */
    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
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