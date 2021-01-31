package com.lgh.common.util;

import org.springframework.util.StringUtils;

/**
 * @author lgh
 * @version 1.0
 * @date 2021/1/17
 */
public class MaskUtils {

    public static String maskPhone(String phone){
        if(StringUtils.isEmpty(phone) || phone.length() < 8){
            return phone;
        }
        return phone.replaceAll("(\\d{3})\\d*(\\d{4})", "$1****$2");
    }
}
