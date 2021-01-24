package com.lgh.controller;

import com.lgh.common.authority.entity.UserDetail;
import com.lgh.common.result.CommonResult;
import com.lgh.common.result.inter.IResult;
import com.lgh.common.sensitive.EnableDesensitization;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/detail")
    @RolesAllowed("USER")
    @EnableDesensitization
    public IResult<UserDetail> getUser(@AuthenticationPrincipal UserDetail userDetail) {
        return CommonResult.successData(userDetail);
    }

    @GetMapping("/update")
    @RolesAllowed("USER")
    public String updateUser(@RequestHeader("token") String token) {
        return "RolesAllowed";
    }
}
