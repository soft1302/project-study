package com.lgh.controller;
import com.lgh.client.UserCenterClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
@Api(tags = "测试feignClient")
@RestController
@RequestMapping("/feign")
@Slf4j
public class TestController {
    @Autowired
    private UserCenterClient userCenterClient;

    @ApiOperation("测试springmvc和feignClient")
    @PostMapping("/{id}/client")
    public String client(@RequestHeader(value = "token", required = true) String token,
                         @PathVariable("id") int id,
                         @RequestBody UserCenterClient.User user) throws URISyntaxException {
        return userCenterClient
                .client(new URI("http://localhost:8080")
                        , token, id, user);
    }
}
