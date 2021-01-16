package com.lgh.common.result;

import com.lgh.common.result.inter.IResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class ExceptionHandlerAspect {

    @ExceptionHandler(Exception.class)
    public <T> IResult<T> exe(Exception ex) {
        if (AccessDeniedException.class.isAssignableFrom(ex.getClass())) {
            return CommonResult.deny();
        }
        if (NoHandlerFoundException.class.isAssignableFrom(ex.getClass())) {
            new CommonResult(404, ex.getMessage());
        }
        return new CommonResult(ResultEnum.UNKNOW.code, ResultEnum.UNKNOW.message);
    }
}
