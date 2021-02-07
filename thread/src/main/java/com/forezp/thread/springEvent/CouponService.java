package com.forezp.thread.springEvent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/2/7 上午10:30
 **/
@Service
public class CouponService {

    @EventListener
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("给用户" + event.getUserName() + "发送优惠券");
    }
}
