package com.lgh.common.utils;

import com.lgh.common.sensitive.DesensitizationEnum;
import com.lgh.common.sensitive.SensitiveValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * 对象脱敏工具
 *
 * @author lgh
 * @version 1.0
 * @date 2021/1/17
 */
public class DesensitizationUtils {
    private static final Logger log = LoggerFactory.getLogger(DesensitizationUtils.class);

    private DesensitizationUtils() {
    }

    /**
     * 扫描对象注解，脱敏，最高层次8层
     *
     * @param obj
     */
    public static void format(Object obj) {
        DesensitizationUtils.formatMethod(obj, 10);
    }

    /**
     * 递归遍历数据，因为可能有对象地址应用导致循环问题，同时设置莫名奇妙的异常，所以设置递归层次，一般不要超过10层
     *
     * @param obj   需要反射对象
     * @param level 递归层次，必须输入
     */
    private static void formatMethod(Object obj, int level) {
        if (obj == null || isPrimitive(obj.getClass()) || level <= 0) {
            return;
        }
        if (obj.getClass().isArray()) {
            for (Object object : (Object[]) obj) {
                formatMethod(object, level--);
            }
        } else if (Collection.class.isAssignableFrom(obj.getClass())) {
            for (Object o : ((Collection) obj)) {
                formatMethod(o, level--);
            }
        } else if (Map.class.isAssignableFrom(obj.getClass())) {
            for (Object o : ((Map) obj).values()) {
                formatMethod(o, level--);
            }
        } else {
            objFormat(obj, level);
        }
    }

    /**
     * 只有对象才格式化数据
     *
     * @param obj
     * @param level
     */
    private static void objFormat(Object obj, int level) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                if (isPrimitive(field.getType())) {
                    SensitiveValid sensitiveValid = field.getAnnotation(SensitiveValid.class);
                    if (sensitiveValid != null) {
                        ReflectionUtils.makeAccessible(field);
                        DesensitizationEnum desensitizationEnum = sensitiveValid.type();
                        Object fieldV = desensitizationEnum.getMethod().invoke(null, field.get(obj));
                        ReflectionUtils.setField(field, obj, fieldV);
                    }
                } else {
                    ReflectionUtils.makeAccessible(field);
                    Object fieldValue = ReflectionUtils.getField(field, obj);
                    if (fieldValue == null) {
                        continue;
                    }
                    formatMethod(fieldValue, level - 1);
                }
            } catch (Exception e) {
                log.error("脱敏数据处理异常", e);
            }
        }
    }

    /**
     * 基本数据类型和String类型判断
     *
     * @param clz
     * @return
     */
    public static boolean isPrimitive(Class<?> clz) {
        try {
            if (String.class.isAssignableFrom(clz) || clz.isPrimitive()) {
                return true;
            } else {
                return ((Class) clz.getField("TYPE").get(null)).isPrimitive();
            }
        } catch (Exception e) {
            return false;
        }
    }
}