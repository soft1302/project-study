package com.lgh.common.result.inter;

public interface IResult<T> {


    int getCode();

    String getMessage();

    T getData();
}
