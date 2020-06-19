package com.forezp.thread.codeWrite.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/19 10:06 上午
 **/
@Slf4j
public class PrintByAtomicIntegerTest {

    // 打印何时结束需要设置一个上限，打印到100结束；
    private static final int MAX_PRINT_NUM = 100;
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void printAB() {
        new Thread(() -> {
            while (atomicInteger.get() <= MAX_PRINT_NUM) {
                // 打印奇数.
                if (atomicInteger.get() % 2 == 0) {
                    log.info(" 偶数:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();

        new Thread(() -> {
            while (atomicInteger.get() <= MAX_PRINT_NUM) {
                // 打印偶数.
                if (atomicInteger.get() % 2 == 1) {
                    log.info("奇数:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        printAB();
        int i = 1;
    }
}
