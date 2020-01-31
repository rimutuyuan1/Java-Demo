package com.forezp.thread.atomicAndOther;

import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class LongAdder {

    private static final Logger logger = LoggerFactory.getLogger(CountExampleAtomic.class);

    private static int threadTotal = 200;
    private static int clientTotal = 5000;
    static final CountDownLatch countDownLatch = new CountDownLatch(threadTotal);

    private static java.util.concurrent.atomic.LongAdder count = new java.util.concurrent.atomic.LongAdder();

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index++ ) {
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e) {
                    logger.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        exec.shutdown();
        logger.info("count = " + count);
    }

    private static void add() {
        count.increment();
    }
}
