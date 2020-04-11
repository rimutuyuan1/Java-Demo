package com.forezp.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    private static AtomicInteger count = new AtomicInteger(0);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static synchronized void incr() {  // 加上sync关键字 顺序打印  不加sync关键字  不会顺序打印
        int i = count.incrementAndGet();
        System.out.printf("count ++ : %s\n", i);
    }

    private static void thread() {
        for (int request = 0; request < 1000; request++) {
            executorService.execute(Atomic::incr);
        }
        System.out.println(count.get());
        executorService.shutdown();
    }

    public static void main(String[] args) {
        thread();
    }
}
