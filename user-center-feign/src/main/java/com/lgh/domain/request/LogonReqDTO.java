package com.lgh.domain.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;;

public class LogonReqDTO {

    @NotNull
    private String phone;

    @NotNull
    @Min(6)
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
