package com.forezp.thread.completableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CompletableFutureTest {

    private static final Random random = new Random();

    private static ExecutorService executorService = Executors.newFixedThreadPool(2, r -> {
        Thread t = new Thread(r);
        t.setDaemon(false);
        return t;
    });


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        List<Double> res = list.stream()
                .map(o -> CompletableFuture.supplyAsync(() -> query(o), executorService))
                .map(i -> i.thenApply(CompletableFutureTest::multiply))
                .map(CompletableFuture::join)
                .collect(toList());
        System.out.println(res);
    }

    private static double query(int i) {
        return random.nextDouble();
    }

    private static double multiply(double i) {
        return i * 10d;
    }
}
