package com.lgh.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lgh.service.IHystrixDemo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "熔断限流测试")
@RestController
@RequestMapping("/hystrixtest")
public class HystrixController {

    @Autowired
    private IHystrixDemo iHystrixDemo;

    @GetMapping("/test")
    public String test(String inputStr) {
        return iHystrixDemo.test(inputStr);
    }

    @GetMapping("/testSentinel")
    public String testSentinel(String inputStr) {
        return iHystrixDemo.testSentinel(inputStr);
    }
}
