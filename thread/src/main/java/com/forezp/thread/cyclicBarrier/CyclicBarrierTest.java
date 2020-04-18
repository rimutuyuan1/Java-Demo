package com.forezp.thread.cyclicBarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author rimutuyuan
 */
public class CyclicBarrierTest {

    private final static Logger log = LoggerFactory.getLogger(CyclicBarrierTest.class);

    private static final CyclicBarrier BARRIER = new CyclicBarrier(5, () -> {
        log.info(" Priority execution this code!");
    });

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        try {
            BARRIER.await(10000, TimeUnit.MILLISECONDS);
        }catch (BrokenBarrierException | TimeoutException ex) {
            log.warn("BrokenBarrierException is happened : ",ex);
        }
        log.info("{} continue", threadNum);
    }

}
