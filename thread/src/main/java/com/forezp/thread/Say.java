package com.forezp.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class Say {

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    private static void addCount() {
        Lock locker = Locker.INSTANCE.writeLock();
        locker.lock();
        count++;
        locker.unlock();
    }

    public static void main(String[] args) {
        ThreadPoolExecutor service = new ThreadPoolExecutor(10,1000,60L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

        for (int i = 0; i < 1000; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    Say.addCount();
                }
            };
            service.execute(r);
        }
        service.shutdown();
        System.out.println(Say.count);
    }

}
