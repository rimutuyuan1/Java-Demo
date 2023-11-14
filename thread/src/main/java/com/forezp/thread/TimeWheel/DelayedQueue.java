package com.forezp.thread.TimeWheel;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-27  11:42
 **/
public class DelayedQueue {

    private ScheduledExecutorService executorService;

    public DelayedQueue() {
        // 创建ScheduledExecutorService，线程池大小根据需要调整
        executorService = Executors.newScheduledThreadPool(1);
    }

    public void addDelayedMessage(String message, long delaySeconds) {
        // 使用ScheduledExecutorService来延迟执行消息
        executorService.schedule(() -> processMessage(message), delaySeconds, TimeUnit.SECONDS);

        // 可以在需要的情况下取消延迟消息
        // future.cancel(false);
    }

    public void shutdown() {
        // 关闭ScheduledExecutorService
        executorService.shutdown();
    }

    private void processMessage(String message) {
        System.out.println("Received message: " + message);
    }

    public static void main(String[] args) {
        DelayedQueue delayedQueue = new DelayedQueue();

        // 添加延迟消息，延迟5秒发送
        delayedQueue.addDelayedMessage("Delayed Message 1", 5);

        // 添加延迟消息，延迟10秒发送
        delayedQueue.addDelayedMessage("Delayed Message 2", 10);

        // 关闭延迟队列
        delayedQueue.shutdown();
    }

}
