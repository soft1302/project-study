package com.lgh.controller;

import com.lgh.common.result.CommonResult;
import com.lgh.common.result.inter.IResult;
import com.lgh.model.domain.UserData;
import com.lgh.service.ILogonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "登录服务")
@RestController
@RequestMapping("/login")
@Validated
public class LogonController {

    @Autowired
    private ILogonService logonService;

    @ApiOperation("登录服务接口")
    @PostMapping("/sign")
    @Valid
    public IResult<UserData> login(@NotNull @RequestParam("phone") String phone, @NotNull @RequestParam("password") String password) {
        UserData userData = logonService.login(phone, password);
        return CommonResult.successData(userData);
    }
}
