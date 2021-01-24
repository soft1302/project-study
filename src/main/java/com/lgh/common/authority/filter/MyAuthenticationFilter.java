package com.lgh.common.authority.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgh.common.authority.authentication.MyAuthentication;
import com.lgh.common.authority.authentication.MySimpleGrantedAuthority;
import com.lgh.common.authority.entity.UserDetail;
import com.lgh.common.result.CommonResult;
import com.lgh.common.util.ApplicationUtil;
import com.lgh.model.Resource;
import com.lgh.model.domain.UserData;
import com.lgh.service.ILogonService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * spring security过滤器，不要交给spring 管理
 */
public class MyAuthenticationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            filterChain.doFilter(request, response);
        } else {
            ILogonService logonService = ApplicationUtil.getBean(ILogonService.class);
            UserData userData = logonService.verify(token);
            if (userData == null) {
                ObjectMapper objectMapper = ApplicationUtil.getBean(ObjectMapper.class);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().print(objectMapper.writeValueAsString(CommonResult.deny()));
                return;
            } else {
                UserDetail userDetail = new UserDetail();
                userDetail.setId(userData.getId());
                userDetail.setName(userData.getUserName());
                List<MySimpleGrantedAuthority> roles = new ArrayList<>();
                if (userData.getUserResources() != null) {
                    roles = userData.getUserResources().stream()
                            .map(Resource::getResourceCode)
                            .map(MySimpleGrantedAuthority::new)
                            .collect(Collectors.toList());
                }
                MyAuthentication myAuthentication = new MyAuthentication(userDetail, roles);
                SecurityContextHolder.getContext().setAuthentication(myAuthentication);
                filterChain.doFilter(request, response);
            }
        }
    }
}
