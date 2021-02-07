package com.forezp.thread.springEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/2/7 上午10:23
 **/
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void register(String userName) {
        System.out.println("执行用户的注册逻辑：" + userName);
        publisher.publishEvent(new UserRegisterEvent(this, userName));
    }
}
