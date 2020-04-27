package com.forezp.thread.condition;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/4/27 10:15 上午
 **/
public class ThreadCommunicateTestUseLock {

    private final int queueSize = 10;
    private final Queue<Integer> queue = new ArrayDeque<>(queueSize);
    private final Lock lock = new ReentrantLock();
    //标记是否可以生产，如果队列满了，则不能生产元素
    private final Condition canProduce = lock.newCondition();
    //标记队列是否空了，如果队列空了，则不能消费元素
    private final Condition canConsume = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ThreadCommunicateTestUseLock test = new ThreadCommunicateTestUseLock();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        consumer.start();
        Thread.sleep(2000);
        producer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            //队列已空，不能消费了，等一等
                            canConsume.await();
                            System.out.println("Consumer after await");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sleep(100);
                    queue.poll();                //每次移走队首元素
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                    //通知生产者生产数据
                    canProduce.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            //队列已满，不能生产了，等一等
                            canProduce.await();
                            System.out.println("Producer after await");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sleep(100);
                    queue.offer(1);       //每次插入一个元素
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                    //已经有数据了，通知消费者消费数据
                    canConsume.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
