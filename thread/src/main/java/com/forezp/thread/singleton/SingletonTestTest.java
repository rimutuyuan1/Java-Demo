package com.forezp.thread.singleton;

public class SingletonTestTest {

    // 验证SingletonTest的单例模式
    // 创建两个对象  两个对象的内存地址相同

    public static void main(String[] args) {
        SingletonTest singletonTest = SingletonTest.getInstance();
        SingletonTest singletonTest1 = SingletonTest.getInstance();
        System.out.println("singletonTest res : " + singletonTest.equals(singletonTest1));

        SingletonByCAS singletonByCAS = SingletonByCAS.getInstance();
        SingletonByCAS singletonByCAS1 = SingletonByCAS.getInstance();
        System.out.println("SingletonByCAS res : " + singletonByCAS.equals(singletonByCAS1));

        SingletonByThreadLocal s1 = SingletonByThreadLocal.getInstance();
        SingletonByThreadLocal s2 = SingletonByThreadLocal.getInstance();
        System.out.println("SingletonByThreadLocal res : " + s1.equals(s2));

        // 结果：
        //singletonTest res : true
        //SingletonByCAS res : true
        //SingletonByThreadLocal res : true
    }
}
