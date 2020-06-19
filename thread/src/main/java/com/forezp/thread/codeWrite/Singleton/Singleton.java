package com.forezp.thread.codeWrite.Singleton;

/**
 * @Author 王鑫涛
 * @Description 单例模式饿汉式
 * @Date 2020/6/18 6:27 下午
 **/
public class Singleton {

    //饿汉式  静态常量方式  类加载的时候就在方法区中存在了，线程安全
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public Singleton getInstance() {
        return instance;
    }

    //懒汉式 普通
    private static Singleton instances;
    //private SingletonEHan () {}
    public Singleton getInstances() {
        if (instances == null) instances = new Singleton();
        return instances;
    }

    //静态内部类实现单例
    private static class SingletonForJingTai {
        private static Singleton singletonEHan = new Singleton();
    }
    public Singleton getInstancesForJingTai() {
        return SingletonForJingTai.singletonEHan;
    }
}
