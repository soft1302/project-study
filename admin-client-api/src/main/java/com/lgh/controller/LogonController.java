package com.lgh.controller;

import com.lgh.common.result.CommonResult;
import com.lgh.common.result.inter.IResult;
import com.lgh.domain.request.LogonReqDTO;
import com.lgh.domain.respose.LogonRepDTO;
import com.lgh.client.logon.ILogonClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "登录服务")
@RestController
@RequestMapping("/login")
@Validated
public class LogonController {

    @Autowired
    private ILogonClient iLogonClient;

    @ApiOperation("登录服务接口")
    @PostMapping("/sign")
    @Valid
    public IResult<LogonRepDTO> login(@RequestBody LogonReqDTO logonReqDTO) {
        LogonRepDTO logonRepDTO = iLogonClient.login(logonReqDTO);
        return CommonResult.successData(logonRepDTO);
    }

    @GetMapping("/testFilter")
    public String testFilter() {
        return "available!";
    }
}