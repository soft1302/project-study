package com.lgh.controller;

import com.lgh.common.authority.entity.UserDetail;
import com.lgh.common.result.CommonResult;
import com.lgh.common.result.inter.IResult;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/detail")
    public IResult<UserDetail> getUser(@AuthenticationPrincipal UserDetail userDetail) {
        return CommonResult.successData(userDetail);
    }

    @PatchMapping("/update")
    @RolesAllowed("user:update")
    public void updateUser() {
        // do something
    }
}
