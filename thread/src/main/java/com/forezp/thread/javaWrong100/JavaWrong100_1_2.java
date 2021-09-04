package com.forezp.thread.javaWrong100;


import com.forezp.thread.atomicAndOther.LongAdder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author 王鑫涛   JavaWrong100_1_1的改进版，用到了ConcurrentHashMap的优化方法
 * @Description 向一个concurrentHashMap中put1000000万次数据，统计一个key在1-10中分别出现的次数
 * @Date 2021/8/29 下午2:11
 **/
public class JavaWrong100_1_2 {

    private static final Integer COUNT = 1000000;

    public Map<String, Long> statistics() throws InterruptedException {
        ConcurrentHashMap<String, LongAdder> concurrentHashMap = new ConcurrentHashMap<>(0);
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, COUNT).parallel().forEach(val -> {
            synchronized (concurrentHashMap) {
                String key = "item" + ThreadLocalRandom.current().nextInt(10);
                concurrentHashMap.computeIfAbsent(key, k -> new LongAdder());
            }
        }));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return concurrentHashMap.entrySet().stream().collect(Collectors.toMap());
    }
}
