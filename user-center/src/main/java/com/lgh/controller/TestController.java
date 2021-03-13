package com.lgh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Api(tags = "测试feignClient")
@RestController
@RequestMapping("/feign")
@Slf4j
public class TestController {

    @ApiOperation("测试springmvc和feignClient")
    @PostMapping("/{id}/client")
    public String client(@RequestHeader(value = "token", required = true) String token,
                         @PathVariable("id") int id, @RequestBody User user) {
        log.info("token={},id={},user={}", token, id, user.toString());
        return "OK";
    }

    @Data
    class User {
        private String userId;
        private String passwd;

        @Override
        public String toString() {
            return "User{" +
                    "userId='" + userId + '\'' +
                    ", passwd='" + passwd + '\'' +
                    '}';
        }
    }
}
