package com.forezp.thread.eventListen;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/10/6 9:31 上午
 **/
@Component
public class UserBeanListener {

    @EventListener
    public void register(UserEvent event) {
        System.out.println("UserBeanListener: " + event.getBaseBean().getName());
    }

}
