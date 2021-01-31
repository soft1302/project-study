package com.lgh.controller;

import com.lgh.domain.request.LogonReqDTO;
import com.lgh.domain.respose.LogonRepDTO;
import com.lgh.client.logon.ILogonClient;
import com.lgh.model.domain.UserData;
import com.lgh.service.ILogonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录服务")
@RestController
@RequestMapping("/login")
public class LogonController implements ILogonClient {

    @Autowired
    private ILogonService logonService;

    @ApiOperation("登录服务接口")
    @Override
    public LogonRepDTO login(LogonReqDTO logonReqDTO) {
        UserData userData = logonService.login(logonReqDTO.getPhone(), logonReqDTO.getPassword());
        if (userData == null) {
            return null;
        }
        LogonRepDTO logonRepDTO = new LogonRepDTO();
        BeanUtils.copyProperties(userData, logonRepDTO);
        return logonRepDTO;
    }

    @Override
    public LogonRepDTO verify(String token) {
        UserData userData = logonService.verify(token);
        if (userData == null) {
            return null;
        }
        LogonRepDTO logonRepDTO = new LogonRepDTO();
        BeanUtils.copyProperties(userData, logonRepDTO);
        return logonRepDTO;
    }
}
