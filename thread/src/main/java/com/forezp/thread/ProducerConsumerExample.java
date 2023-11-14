package com.forezp.thread;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-20  18:12
 **/
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        // 创建生产者线程
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    // 向队列添加元素
                    queue.put(1);
                    System.out.println("Producer: Element added to queue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 创建消费者线程
        Thread consumerThread = new Thread(() -> {
            while (!queue.isEmpty()) {
                try {
                    // 从队列获取元素
                    int element = queue.take();
                    System.out.println("Consumer: Element retrieved from queue: " + element);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 先启动生产者线程，再启动消费者线程
        producerThread.start();
        consumerThread.start();

        // 等待生产者线程和消费者线程执行完毕
        producerThread.join();
        consumerThread.join();

        System.out.println("Main thread finished");
    }
}
