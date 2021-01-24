package com.lgh.common.sensitive;


import com.lgh.common.util.MaskUtils;

import java.lang.reflect.Method;

/**
 * 若需要新定义一个扫描规则，这里添加即可
 *
 * @author lgh
 * @version 1.0
 * @date 2021/1/17
 */
public enum DesensitizationEnum {

    // 执行类和脱敏方法名
    PHONE(MaskUtils.class, "maskPhone", new Class[]{String.class});

     private Class<?> clazz;
     private Method method;

    DesensitizationEnum(Class<?> target, String method, Class[] paramTypes) {
        this.clazz = target;
        try {
            this.method = target.getDeclaredMethod(method, paramTypes);
        } catch (NoSuchMethodException e) {
             e.printStackTrace();
        }
    }
    public Method getMethod() {
        return method;
    }
}
