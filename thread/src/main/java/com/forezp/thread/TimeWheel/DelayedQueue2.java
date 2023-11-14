package com.forezp.thread.TimeWheel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-27  11:49
 **/
public class DelayedQueue2 {

    private ScheduledThreadPoolExecutor executor;
    private int wheelSize;
    private int tickMs;

    public DelayedQueue2(int wheelSize, int tickMs) {
        this.wheelSize = wheelSize;
        this.tickMs = tickMs;

        // 创建时间轮
        executor = new ScheduledThreadPoolExecutor(1);
        executor.setRemoveOnCancelPolicy(true);
    }

    public void start() {
        // 启动时间轮
        executor.scheduleAtFixedRate(() -> {
            tick();
        }, 0, tickMs, TimeUnit.MILLISECONDS);
    }

    public void addDelayedMessage(String message, long delayMs) {
        // 计算消息应该被插入时间轮的哪个槽
        long wheelIndex = delayMs / tickMs;

        // 创建延迟任务并插入时间轮
        executor.schedule(() -> {
            processMessage(message);
        }, wheelIndex, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        // 停止时间轮
        executor.shutdown();
    }

    private void processMessage(String message) {
        System.out.println("Received message: " + message);
    }

    private void tick() {
        // 时间轮每次tick，处理当前槽中的任务
        long currentTime = System.currentTimeMillis();
        long currentWheelIndex = currentTime / tickMs % wheelSize;
        BlockingQueue<Runnable> tasks = executor.getQueue();

        for (Runnable task : tasks) {
            /*if (task instanceof ScheduledFutureTask<?>) {
                ScheduledFutureTask<?> scheduledTask = (ScheduledFutureTask<?>) task;
                long scheduledTime = scheduledTask.getDelay(TimeUnit.MILLISECONDS);
                long taskWheelIndex = scheduledTime / tickMs % wheelSize;

                if (taskWheelIndex == currentWheelIndex) {
                    executor.execute(task);
                }
            }*/
        }
    }

    public static void main(String[] args) {
       /* int wheelSize = 10; // 时间轮的槽数量
        int tickMs = 1000; // 每个槽的时间跨度（毫秒）

        DelayedQueue delayedQueue = new DelayedQueue(wheelSize, tickMs);
        delayedQueue.start();

        // 添加延迟消息，延迟5秒发送
        delayedQueue.addDelayedMessage("Delayed Message 1", 5000);

        // 添加延迟消息，延迟10秒发送
        delayedQueue.addDelayedMessage("Delayed Message 2", 10000);

        // 停止延迟队列
        delayedQueue.stop();*/
    }

}
