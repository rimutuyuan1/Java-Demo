package com.forezp.thread.ThreadLocal;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-28  15:50
 **/
public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    private static ThreadLocal<Map<String, String>> threadLocal1 = ThreadLocal.withInitial(() -> Maps.newHashMap());

    public static void main(String[] args) {


        Runnable task = () -> {
            threadLocal.set(42);
            int value = threadLocal.get();
            System.out.println("线程 " + Thread.currentThread().getId() + " 中的值：" + value);
        };
        Runnable task1 = () -> {
            threadLocal.set(421);
            int value = threadLocal.get();
            System.out.println("线程 " + Thread.currentThread().getId() + " 中的值：" + value);
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task1);

        thread1.start();
        thread2.start();
    }
}
