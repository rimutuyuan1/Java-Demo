package com.forezp.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author 王鑫涛
 * @Description  实现一个线程安全的生产者消费者模型
 * @Date 2023-09-29  17:47
 **/
public class threadPoolThreadSafe {

    public static class Producer implements Runnable {

        public ArrayBlockingQueue<Integer> queue;

        public Producer(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.put(i);
                    System.out.println("已发送：" + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            try {
                queue.put(-1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static  class  Consumer implements Runnable {
        public ArrayBlockingQueue<Integer> queue;

        public Consumer(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    Integer data = queue.take();
                    if (data == -1) {
                        System.out.println("消费已结束");
                        break;
                    }
                    System.out.println("已消费：" + data);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(100);
        Thread consumer = new Thread(new Consumer(arrayBlockingQueue));
        Thread producer = new Thread(new Producer(arrayBlockingQueue));

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();

        System.out.println("流程已走完");
    }
}
