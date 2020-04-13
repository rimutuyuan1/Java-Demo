package com.forezp.thread.singleton;

import java.util.concurrent.atomic.AtomicReference;

public class SingletonByCAS {

    private static final AtomicReference<SingletonByCAS> singleton = new AtomicReference<>();

    private SingletonByCAS () {}

    public static final SingletonByCAS getInstance() {
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

    public static void main(String[] args) {
        SingletonByCAS singletonByCAS = SingletonByCAS.getInstance();
        SingletonByCAS singletonByCAS1 = SingletonByCAS.getInstance();
        System.out.println(singletonByCAS.equals(singletonByCAS1));
    }

}
