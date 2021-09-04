package com.forezp.thread.javaWrong100;


import com.google.common.collect.Maps;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author 王鑫涛
 * @Description 向一个concurrentHashMap中put1000000万次数据，统计一个key在1-10中分别出现的次数
 * @Date 2021/8/29 下午2:11
 **/
public class JavaWrong100_1_1 {

    private static final Integer COUNT = 1000000;

    public ConcurrentHashMap<String, Integer> statistics() throws InterruptedException {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>(0);
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, COUNT).parallel().forEach(val -> {
            synchronized (concurrentHashMap) {
                String key = "item" + ThreadLocalRandom.current().nextInt(10);
                if (concurrentHashMap.contains(val)) {
                    concurrentHashMap.put(key, concurrentHashMap.get(String.valueOf(val)) + 1);
                }
                else {
                    concurrentHashMap.put(key, 1);
                }
            }
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return concurrentHashMap;
    }
}
