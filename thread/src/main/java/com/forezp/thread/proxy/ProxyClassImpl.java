package com.forezp.thread.proxy;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/7/22 下午5:35
 **/
public class ProxyClassImpl implements IProxyClass {

    @Override
    public int doSomething(int i) {
        System.out.println("方法执行中.....");
        return i;
    }
}
