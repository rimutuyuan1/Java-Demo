package com.forezp.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    private static AtomicInteger count = new AtomicInteger(0);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static void thread() {
        for (int request = 0; request < 1000; request++) {
            executorService.execute(() -> count.incrementAndGet());
        }
        System.out.printf("count ++ : %s\n", count.get());
    }

    public static void main(String[] args) {
        thread();
    }
}
