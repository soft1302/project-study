package com.lgh.common.batch.utils;

import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;

import java.lang.reflect.Proxy;

/**
 * 代理类的追踪
 *
 * @author guohu
 *
 */
public abstract class ExecutorUtil {
  private ExecutorUtil() {
  }

  public static Executor getTargetExecutor(final Executor executor) {
    Executor targetExecutor = executor;
    // 判断是否是代理类
    while (targetExecutor instanceof Proxy) {
      // org.apache.ibatis.plugin.Plugin的代理对象,直到找到最后一个
      targetExecutor = (Executor) Reflection.getField("target",
              Proxy.getInvocationHandler(targetExecutor));
    }
    // 取真正的executor
    if (targetExecutor instanceof CachingExecutor) {
      targetExecutor = (Executor) Reflection.getField("delegate", targetExecutor);
    }
    return targetExecutor;
  }
}
