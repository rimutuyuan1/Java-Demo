package com.forezp.thread.eventListen;

import org.springframework.context.ApplicationEvent;

/**
 * @Author 王鑫涛
 * @Description
 * @Date 2020/10/6 9:28 上午
 **/
public class UserEvent extends ApplicationEvent {

    private BaseBean baseBean;

    public UserEvent(Object source, BaseBean baseBean) {
        super(source);
        this.baseBean = baseBean;
    }

    public BaseBean getBaseBean() {
        return baseBean;
    }

    public void setBaseBean(BaseBean baseBean) {
        this.baseBean = baseBean;
    }
}
