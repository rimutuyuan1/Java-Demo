package com.forezp.thread.springEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/2/7 上午10:12
 **/
public class UserRegisterEvent extends ApplicationEvent {

    private String userName;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
