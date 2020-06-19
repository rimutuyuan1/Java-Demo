package com.forezp.thread.codeWrite.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 11:06 下午
 **/
public class PrintByAtomicSynchronizedTest {

    private static volatile AtomicInteger count = new AtomicInteger(0);
    private static Object lock = new Object();

    private static void print() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            while (count.get() < 100) {
                synchronized (lock) {
                    if (count.get() % 2 == 0) {
                        System.out.println("偶数：" + count);
                        count.incrementAndGet();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        executorService.execute(() -> {
            while (count.get() < 100) {
                synchronized (lock) {
                    if (count.get() % 2 == 1) {
                        System.out.println("奇数：" + count);
                        count.incrementAndGet();
                        lock.notifyAll();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        print();
    }
}
