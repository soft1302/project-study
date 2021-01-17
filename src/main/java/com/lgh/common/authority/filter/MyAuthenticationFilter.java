package com.lgh.common.authority.filter;

import com.lgh.common.authority.authentication.MyAuthentication;
import com.lgh.common.authority.entity.UserDetail;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MyAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取header头信息，发起用户验证
        UserDetail userDetail = new UserDetail();
        userDetail.setId(1);
        userDetail.setPhone("13823129999");
        userDetail.setName("test");
        List<SimpleGrantedAuthority> roles = Arrays.asList(new String[]{"ADMIN", "USER", "GUEST"})
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        MyAuthentication myAuthentication = new MyAuthentication(userDetail, roles);
        SecurityContextHolder.getContext().setAuthentication(myAuthentication);
        // 验证异常则抛出异常
      /*  boolean valid = false;
        if (valid) {
            response.getWriter().print("deny");
            return;
        }*/
        filterChain.doFilter(request, response);
    }
}
