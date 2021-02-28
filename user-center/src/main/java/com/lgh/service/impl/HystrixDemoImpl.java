package com.lgh.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lgh.exception.ExceptionUtil;
import com.lgh.service.IHystrixDemo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HystrixDemoImpl implements IHystrixDemo {

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @Override
    public String test(String inputStr) {
        try {
            System.out.println("test Hystrix");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    @SentinelResource(value = "testSentinel",
            blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    @Override
    public String testSentinel(String inputStr) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

    public String fallbackMethod(String inputStr) {
        System.out.println("fallbackMethod");
        return "Time out" + inputStr;
    }
}
