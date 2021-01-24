package com.lgh.common.authority.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

public class MySimpleGrantedAuthority implements GrantedAuthority {
    private static final long serialVersionUID = 510L;
    private final String rolePrefix = "ROLE_";
    private final String role;

    public MySimpleGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    public String getAuthority() {
        return rolePrefix + this.role;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            return obj instanceof MySimpleGrantedAuthority ? this.role.equals(((MySimpleGrantedAuthority) obj).role) : false;
        }
    }

    public int hashCode() {
        return this.role.hashCode();
    }

    public String toString() {
        return this.role;
    }
}
