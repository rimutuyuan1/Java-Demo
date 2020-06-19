package com.forezp.thread.codeWrite.thread;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 7:59 下午
 **/
public class interreptTest extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        while (!Thread.currentThread().isInterrupted()) {
            // ... 单次循环代码
            System.out.println("qqqqqqqqqq");
        }
        System.out.println("------------- done --------------");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new interreptTest();
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread().getName());
    }
}
