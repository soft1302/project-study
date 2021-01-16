package com.lgh.common.result;

public enum ResultEnum {
    SUCCESS(200, "成功"),
    DENY(403, "无权访问"),
    UNKNOW(401, "无权访问");

    public int code;
    public String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
