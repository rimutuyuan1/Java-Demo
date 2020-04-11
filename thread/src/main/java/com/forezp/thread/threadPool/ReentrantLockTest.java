package com.forezp.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockTest {

    private static int count = 0;
    private final static ReentrantLock lock = new ReentrantLock();
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static void incr() {
        lock.lock();
        count++;
        lock.unlock();
    }

    private static void thread() {
        for (int request = 0; request < 100; request++) {
            executorService.execute(ReentrantLockTest::incr);
        }
        System.out.printf("count ++ : %s\n", count);
    }

    public static void main(String[] args) {
        thread();
    }
}
