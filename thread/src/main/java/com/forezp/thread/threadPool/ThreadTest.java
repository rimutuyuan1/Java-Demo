package com.forezp.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ThreadTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(0);
    private static AtomicInteger count = new AtomicInteger(0);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static void thread() throws InterruptedException {
        for (int request = 0; request < 100; request++) {
            executorService.execute(() -> {
                count.incrementAndGet();
                countDownLatch.countDown();
                System.out.printf("count ++ : %s\n", count.get());
            });
        }
        countDownLatch.await();
    }

    public static void main(String[] args) throws InterruptedException {
        thread();
    }
}
