package com.example.demo.dao;

import com.example.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author GuoJingyuan
 * @date 2019/10/11
 */
@Mapper
public interface UserInfoDao {
    UserInfo getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    UserInfo getByUsername(@Param("username") String username);

}
