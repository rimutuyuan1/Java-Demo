package com.forezp.thread.atomicAndOther;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class atomicReference {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        count.compareAndSet(4,7);
        log.info("count {}", count);
    }
}
