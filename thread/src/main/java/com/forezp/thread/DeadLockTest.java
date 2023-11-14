package com.forezp.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-30  11:16
 **/
public class DeadLockTest {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void lock1() {
        try {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "进入lock1");
                TimeUnit.SECONDS.sleep(5);
                lock2();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void lock2() {
        try {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "进入lock2");
                TimeUnit.SECONDS.sleep(5);
                lock1();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable r1 = DeadLockTest::lock1;
        Runnable r2 = DeadLockTest::lock2;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
