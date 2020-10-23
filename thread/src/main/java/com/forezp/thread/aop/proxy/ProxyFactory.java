package com.forezp.thread.aop.proxy;

import com.forezp.thread.aop.IUserInterface;
import com.forezp.thread.aop.UserServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/9/3 23:18 下午
 **/
public class ProxyFactory {

    private final Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
            (proxy, method, args) -> method.invoke(target, args)
        );
    }

    public static void main(String[] args) {
        IUserInterface target = new UserServiceImpl();
        IUserInterface proxy = (IUserInterface) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.query());
    }
}
