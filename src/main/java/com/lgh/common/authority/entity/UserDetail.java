package com.lgh.common.authority.entity;

import com.lgh.common.sensitive.DesensitizationEnum;
import com.lgh.common.sensitive.SensitiveValid;

public class UserDetail {
    private long id;
    private String name;
    @SensitiveValid(type = DesensitizationEnum.PHONE)
    private String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
