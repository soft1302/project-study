package com.lgh.common.result;

import com.lgh.common.result.inter.IResult;

public class CommonResult<T> implements IResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static IResult success() {
        return new CommonResult(ResultEnum.SUCCESS.code, ResultEnum.SUCCESS.message);
    }

    public static <T> IResult successData(T data) {
        return new CommonResult(ResultEnum.SUCCESS.code, ResultEnum.SUCCESS.message, data);
    }

    public static IResult deny() {
        return new CommonResult(ResultEnum.DENY.code, ResultEnum.DENY.message);
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
