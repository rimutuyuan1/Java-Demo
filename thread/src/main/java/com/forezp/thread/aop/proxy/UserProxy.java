package com.forezp.thread.aop.proxy;

import com.forezp.thread.aop.IUserInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/9/4 11:45 上午
 **/
public class UserProxy<T> implements InvocationHandler {

    private Class<T> proxyInstance;

    public UserProxy(Class<T> proxyInstance) {
        this.proxyInstance = proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("query")) {
            System.out.println("###################");
            return method.invoke(proxyInstance, args);
        }
        return null;
    }

    public T getProxy() {
        return (T) Proxy.newProxyInstance(proxyInstance.getClassLoader(), new Class[]{proxyInstance}, this);
    }

    public static void main(String[] args) {
        UserProxy<IUserInterface> userProxy = new UserProxy<>(IUserInterface.class);
        IUserInterface iUserInterface = userProxy.getProxy();
        String query = iUserInterface.query();
        System.out.println(query);
    }
}
