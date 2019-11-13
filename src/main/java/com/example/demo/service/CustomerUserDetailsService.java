package com.example.demo.service;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GuoJingyuan
 * @date 2019/10/11
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.getByUsername(s);
        if (userInfoDao == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<RoleInfo> roles = new ArrayList<>(3);
        roles.add(new RoleInfo("ROLE_USER"));
//        User user = new User(userInfo.getUsername(), userInfo.getPassword(),roles);
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username(userInfo.getUsername())
                        .password(userInfo.getPassword())
                        .roles("USER")
                        .build();
        return user;
    }
}
