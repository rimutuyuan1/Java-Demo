package com.forezp.thread.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/7/22 下午5:35
 **/
public class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object newProxyInstance() {
        return Proxy.newProxyInstance(proxied.getClass().getClassLoader(), proxied.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) throws SecurityException, NoSuchMethodException {
        ProxyClassImpl c = new ProxyClassImpl();
        DynamicProxyHandler proxyHandler = new DynamicProxyHandler(c);
        IProxyClass proxyClass = (IProxyClass)proxyHandler.newProxyInstance();
        System.out.println(proxyClass.getClass().getName());
        System.out.println(proxyClass.doSomething(5));

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //addClassToDisk(proxy.getClass().getName(), ProxyClassImpl.class,"/Users/rimutuyuan/Desktop/$Proxy0.class");
        System.out.println("method:" + method.getName());
        System.out.println("args:" + args[0].getClass().getName());
        System.out.println("Before invoke method...");
        Object object=method.invoke(proxied, args);
        System.out.println("After invoke method...");
        return object;
    }

    private void addClassToDisk(String className, Class<?> cl, String path) {
        byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
