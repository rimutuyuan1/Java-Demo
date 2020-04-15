package com.forezp.thread.singleton;

import java.util.concurrent.atomic.AtomicReference;

public class SingletonByCAS {

    private static final AtomicReference<SingletonByCAS> singleton = new AtomicReference<>();

    private SingletonByCAS () {}

    static SingletonByCAS getInstance() {
        for (;;) {
            SingletonByCAS current = singleton.get();
            if (current != null) {
                return current;
            }
            current = new SingletonByCAS();
            if (singleton.compareAndSet(null, current)) {
                return current;
            }
        }
    }

}
