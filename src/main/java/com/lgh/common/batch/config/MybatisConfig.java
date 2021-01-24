package com.lgh.common.batch.config;

import com.lgh.common.batch.inteceptor.BatchExecutorInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
    @Bean
    public Interceptor myBatchInterceptor() {
        return new BatchExecutorInterceptor();
    }
}
