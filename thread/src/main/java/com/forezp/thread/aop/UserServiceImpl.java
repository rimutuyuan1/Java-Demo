package com.forezp.thread.aop;

import org.springframework.stereotype.Service;

/**
 * @Author 王鑫涛
 * @Description
 * @Date 2020/9/3 11:27 下午
 **/
@Service
public class UserServiceImpl implements IUserInterface{

    @Override
    public String query() {
        return "hello world";
    }
}
