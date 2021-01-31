package com.lgh.client.logon;

import com.lgh.constrants.ServerConfig;
import com.lgh.domain.request.LogonReqDTO;
import com.lgh.domain.respose.LogonRepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ServerConfig.USER_CENTER, path = "/login")
public interface ILogonClient {

    @PostMapping("/sign")
    LogonRepDTO login(@RequestBody LogonReqDTO logonReqDTO);

    @GetMapping("/verify")
    LogonRepDTO verify(@RequestParam("token") String token);
}
