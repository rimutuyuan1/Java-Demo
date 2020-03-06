package com.forezp.thread.exam;

import java.util.concurrent.locks.ReentrantLock;

public class IntLock implements Runnable {

    private ReentrantLock lock;
    Integer[]  lockList ;
    Integer[]  waitList ;

    private static int a = 1;

    public IntLock(ReentrantLock lock) {
        this.lock = lock;
    }


    @Override
    public void run() {

        lock.lock();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            System.out.println("thread 1");

        }
//        dddd
        lock.unlock();

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        new Thread(new IntLock(lock)).start();

        new Thread2(lock).start();
    }

    static class Thread2 extends Thread {
        private ReentrantLock lock;

        public Thread2(ReentrantLock lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock){
                System.out.println("thread 2");
            }
        }
    }
}

//1 线程中断， interrupt interrupted 和 isinterrupted区别作用

//2 可中断锁
