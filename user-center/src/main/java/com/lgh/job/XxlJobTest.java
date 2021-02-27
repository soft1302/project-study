package com.lgh.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class XxlJobTest extends IJobHandler {

    @XxlJob("testJob")
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        try {
            log.info(String.format("XxlJobTest execute,params is %s", s));
        } catch (Exception e) {
            return FAIL;
        }
        return SUCCESS;
    }
}
