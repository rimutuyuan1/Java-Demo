package com.forezp.thread.codeWrite.thread;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 7:18 下午
 **/
public class Notify {

    private static volatile int count = 0;

    private static void threadNotify() {
        final Object o = new Object();

        Thread thread1 = new Thread(() -> {
            while (count < 100) {

                synchronized (o) {
                    if (count % 2 == 0) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println(count++);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (count < 100) {
                synchronized (o) {
                    if (count % 2 == 1) {
                       o.notify();
                    }else {
                        System.out.println(count++);
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        threadNotify();
        //System.out.println(test());
    }

    private static int test() {
        return 0 % 2;
    }
}
