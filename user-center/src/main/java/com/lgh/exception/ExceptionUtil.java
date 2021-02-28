package com.lgh.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class ExceptionUtil {
    public static String handleException(String inputStr, BlockException ex) {
        System.out.println("Oops: " + ex.getClass().getCanonicalName());
        return "Fail";
    }
}
