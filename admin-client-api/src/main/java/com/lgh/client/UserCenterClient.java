package com.lgh.client;
import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import java.net.URI;
@FeignClient(name = "test", url = "EMPTY")
public interface UserCenterClient {
    @PostMapping("/feign/{id}/client")
    public String client(URI uri, @RequestHeader(value = "token", required = true) String token,
                         @PathVariable("id") int id,
                         @RequestBody User user);
    @Data
    class User {
        private String userId;
        private String passwd;
    }
}
