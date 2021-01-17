package com.lgh.common.sensitive;

import com.lgh.common.utils.DesensitizationUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.annotation.Aspect;
import java.lang.reflect.Method;

/**
 * @author lgh
 * @version 1.0
 * @date 2021/1/17
 */
@Aspect
@Configuration
public class SensitiveAspect {
    public static final String ACCESS_EXECUTION = "execution(* com.lgh.controller..*.*(..))";
    /**
     * 注解脱敏处理
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(ACCESS_EXECUTION)
    public Object sensitiveClass(ProceedingJoinPoint joinPoint) throws Throwable {
        return sensitiveFormat(joinPoint);
    }

    /**
     * 插拔式注解统一拦截器。@{link EnableDesensitization } 和 @SensitiveValid
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object sensitiveFormat(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = joinPoint.proceed();
        if (obj == null || DesensitizationUtils.isPrimitive(obj.getClass())) {
            return obj;
        }
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        EnableDesensitization desensitization = joinPoint.getTarget().getClass().getAnnotation(EnableDesensitization.class);
        if (desensitization != null || method.getAnnotation(EnableDesensitization.class) != null) {
            DesensitizationUtils.format(obj);
        }
        return obj;
    }
}
