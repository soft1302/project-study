package com.lgh.batch.inteceptor;

import org.apache.ibatis.executor.BatchExecutor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 批量操作
 *
 * @author guohu
 */
final class BatchExecutorAdaptor extends BatchExecutor {
    private Logger log = LoggerFactory.getLogger(BatchExecutorAdaptor.class);

    public BatchExecutorAdaptor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    public int update(MappedStatement ms, Object parameter) throws SQLException {
        if (parameter == null) {
            super.update(ms, parameter);
        }
        final Object params;
        if (parameter instanceof Map) {
            final Map<String, Object> paramMap = (Map<String, Object>) parameter;
            if (paramMap == null || paramMap.size() != 1) {
                if (paramMap.size() == 2 && paramMap.get("collection") != null) {
                    params = paramMap.get("collection");
                } else if (!paramMap.containsKey("param1")) {
                    return super.update(ms, parameter);
                } else {
                    params = paramMap.get("param1");
                }
            } else {
                params = paramMap.values().iterator().next();
            }
        } else if (parameter instanceof Iterable || parameter.getClass().isArray()) {
            params = parameter;
        } else {
            params = Collections.singletonList(parameter);
        }

        final Iterable<?> paramIterable = toIterable(params);
        try {
            for (Object obj : paramIterable) {
                super.update(ms, obj);
            }
            List<BatchResult> batchResults = doFlushStatements(false);
            if (batchResults == null || batchResults.size() == 0) {
                return 0;
            }
            return resolveUpdateResult(batchResults);
        } catch (Exception e) {
            log.error("batch execute", e);
            doFlushStatements(true);
            /**
             * 批量插入，则报异常
             */
            if ("INSERT".equalsIgnoreCase(ms.getSqlCommandType().name())) {
                throw e;
            }
            return 0;
        }
    }


    private Iterable<?> toIterable(final Object params) {
        if (params == null) {
            return Collections.emptyList();
        }
        Iterable<?> paramIterable;
        if (params instanceof Iterable) {
            paramIterable = (Iterable<?>) params;
        } else if (params.getClass().isArray()) {
            Object[] array = (Object[]) params;
            paramIterable = Arrays.asList(array);
        } else {
            paramIterable = Collections.singletonList(params);
        }
        return paramIterable;
    }

    private int resolveUpdateResult(final List<BatchResult> batchResults) {
        int result = 0;
        for (BatchResult batchResult : batchResults) {
            int[] updateCounts = batchResult.getUpdateCounts();
            if (updateCounts == null || updateCounts.length == 0) {
                continue;
            }
            for (int updateCount : updateCounts) {
                result += updateCount;
            }
        }
        return result;
    }

}
