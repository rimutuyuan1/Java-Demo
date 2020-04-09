package com.forezp.thread.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ReentrantLock {

    private static int count = 0;
    private final static java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static void incr() {
        lock.lock();
        count++;
        lock.unlock();
    }

    private static void thread() {
        for (int request = 0; request < 100; request++) {
            executorService.execute(ReentrantLock::incr);
        }
        System.out.printf("count ++ : %s\n", count);
    }

    public static void main(String[] args) {
        thread();
    }
}
