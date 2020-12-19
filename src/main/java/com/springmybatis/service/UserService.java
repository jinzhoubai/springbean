package com.springmybatis.service;

import com.springmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserService {


    //Mybatis产生的userMapper代理对象---》Bean
    @Autowired
    private UserMapper userMapper;

    public void test(){
        System.out.println(userMapper.selectById());
    }

}
