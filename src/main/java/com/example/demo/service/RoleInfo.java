package com.example.demo.service;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author GuoJingyuan
 * @date 2019/10/11
 */
public class RoleInfo implements GrantedAuthority {
    private String roleName;
    public RoleInfo(String roleName) {
        this.roleName = roleName;
    }
    @Override
    public String getAuthority() {
        return roleName;
    }
}
