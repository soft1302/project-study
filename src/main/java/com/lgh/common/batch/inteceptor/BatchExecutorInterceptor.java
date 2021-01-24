package com.lgh.common.batch.inteceptor;

import com.lgh.common.batch.utils.ExecutorUtil;
import com.lgh.common.batch.utils.Reflection;
import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Properties;

/**
 * 批量操作拦截器，以Batch结束语句
 *
 * @author guohu
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
})
public class BatchExecutorInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchExecutorInterceptor.class);

    @Override
    public Object intercept(final Invocation invocation) throws Throwable {
        //check argument
        if (invocation.getArgs()[1] == null) {
            return invocation.proceed();
        }
        final MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // 是否需要批处理标识
        if (!mappedStatement.getId().endsWith("Batch")) {
            return invocation.proceed();
        }
        // 找到执行对象
        final Executor targetExecutor = ExecutorUtil.getTargetExecutor((Executor) invocation.getTarget());
        // 若是批处理，则不做操作
        if (targetExecutor instanceof BatchExecutor) {
            return invocation.proceed();
        }
        // 获取配置文件
        final Configuration configuration = (Configuration) Reflection.getField("configuration", targetExecutor);
        // 创建批处理对象
        final BatchExecutor batchExecutor = new BatchExecutorAdaptor(configuration, targetExecutor.getTransaction());
        try {
            return batchExecutor.update(mappedStatement, invocation.getArgs()[1]);
        } catch (SQLException e) {
            LOGGER.error("batch excute", e);
            batchExecutor.flushStatements(true);
            throw e;
        }
    }

    @Override
    public Object plugin(final Object target) {
        if (!(target instanceof Executor)) {
            return target;
        }
        if (target instanceof BatchExecutor) {
            return target;
        }

        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(final Properties properties) {
    }
}
