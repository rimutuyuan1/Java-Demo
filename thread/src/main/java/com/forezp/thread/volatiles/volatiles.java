package com.forezp.thread.volatiles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class volatiles {

    private static int totalCount = 5000;
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(totalCount);

        for (int i = 0; i < totalCount; i++) {
            new Thread(() -> {
                count.incrementAndGet();
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(count);
    }
}
