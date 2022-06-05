package com.forezp.thread.zhuye;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/10/8 上午10:19
 **/
@Slf4j
public class ThreadPoolTest {

    private static void printStats(ThreadPoolExecutor threadPool){
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());

            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }

    private static void submitTasks(AtomicInteger atomicInteger, ThreadPoolExecutor threadPool) {
        IntStream.rangeClosed(1, 20).forEach(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int id = atomicInteger.incrementAndGet();
            threadPool.submit(() -> {
                log.info("{} started", id);
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("{} finished", id);
            });
        });
    }

    public static void main(String[] args) throws InterruptedException {
        //threadV1();
        threadV2();
    }

    private static void threadV1() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 5,
                5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadFactoryBuilder().setNameFormat("execute-task-pool").build());

        log.info("current core threads are : {}", threadPool.prestartAllCoreThreads());
        printStats(threadPool);
        submitTasks(atomicInteger,threadPool);
        threadPool.shutdown();
        threadPool.awaitTermination(3, TimeUnit.MINUTES);
    }

    private static void threadV2() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();

        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10) {
            @Override
            public boolean offer(@NotNull Runnable runnable) {
                return false;
            }
        };

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2, 5,
                5, TimeUnit.SECONDS,
                blockingQueue, new ThreadFactoryBuilder().setNameFormat("execute-task-pool").build(), (r, executor) -> {
                    try {
                        executor.getQueue().put(r);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
        });

        log.info("current core threads are : {}", threadPool.prestartAllCoreThreads());
        printStats(threadPool);
        submitTasks(atomicInteger, threadPool);
        threadPool.shutdown();
        threadPool.awaitTermination(2, TimeUnit.MINUTES);
        threadPool.shutdownNow();
    }

}
