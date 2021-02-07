package com.forezp.thread.springEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/2/7 上午10:28
 **/
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("给用户" + event.getUserName() + "发送邮件");
    }
}
