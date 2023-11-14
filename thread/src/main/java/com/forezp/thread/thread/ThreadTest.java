package com.forezp.thread.thread;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-25  20:41
 **/
public class ThreadTest extends Thread {

    public static synchronized short get() {
        return 0;
    }

    static {

    }

    @Override
    public void run() {
        System.out.println("current thread is running");
    }

    public static void main(String[] args) {
        ThreadTest ne = new ThreadTest();
        ne.run();
    }
}
