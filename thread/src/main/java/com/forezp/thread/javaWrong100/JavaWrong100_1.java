package com.forezp.thread.javaWrong100;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/8/29 下午1:35
 **/
public class JavaWrong100_1 {

    private static final int ITEM_COUNT = 1000;

    public static void main(String[] args) {
        System.out.println(getData(100));
    }

    private static ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(),
                        (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    public void calculate() throws InterruptedException {
        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM_COUNT - 100);
        //初始900个元素
        System.out.println("init size: " + concurrentHashMap.size());

        int THREAD_COUNT = 10;
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        //使用线程池并发处理逻辑
        forkJoinPool.execute(() -> IntStream.rangeClosed(1, 10).parallel().forEach(i -> {
        //查询还需要补充多少个元素
        int gap = ITEM_COUNT - concurrentHashMap.size();
        System.out.println("gap size:{}" + gap);
        //补充元素
        concurrentHashMap.putAll(getData(gap));
        }));
        //等待所有任务完成
        forkJoinPool.shutdown(); forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("finish size:{}" + concurrentHashMap.size());

    }
}
