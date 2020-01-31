package com.forezp.thread.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample {

    // 修饰代码块
    public void test1() {
        synchronized (this) {
            for (int i = 1; i < 10; i++) {
                log.info("test1 - {}", i);
            }
        }
    }

    // 修饰一个方法
    public synchronized void test2() {
        for (int i = 1; i < 10; i++) {
            log.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
        SynchronizedExample example1 = new SynchronizedExample();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(example::test1);
        service.execute(example1::test1);
    }

}
