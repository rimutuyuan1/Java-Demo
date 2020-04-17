package com.forezp.thread.atomicAndOther;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

public class atomicReference {

    private static final Logger log = LoggerFactory.getLogger(AtomicReference.class);

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        count.compareAndSet(4,7);
        log.info("count {}", count);
    }
}
