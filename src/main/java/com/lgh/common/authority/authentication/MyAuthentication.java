package com.lgh.common.authority.authentication;

import com.lgh.common.authority.entity.UserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class MyAuthentication implements Authentication {

    private UserDetail userDetail;
    private List<SimpleGrantedAuthority> authorities;

    public MyAuthentication(UserDetail userDetail, List<SimpleGrantedAuthority> authorities) {
        this.userDetail = userDetail;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return this.userDetail;
    }

    @Override
    public Object getPrincipal() {
        return this.userDetail;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
