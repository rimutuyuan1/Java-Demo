package com.forezp.thread.codeWrite.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 王鑫涛
 * @Description 通过volatile+标志位实现奇偶数交替打印
 * @Date 2020/6/18 10:53 下午
 **/
public class JiaoTiDaYinJiOuShuTest {

    private static volatile boolean flag = true;
    private static volatile int count = 0;

    private static void printJiShuTest() {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            while (count <= 100) {
                if (!flag) {
                    System.out.println("奇数：" + count);
                    count++;
                    flag = true;
                }
            }
        });

        executorService.execute(() -> {
            while (count <= 100) {
                if (flag) {
                    System.out.println("偶数：" + count);
                    count++;
                    flag = false;
                }
            }
        });

        executorService.shutdown();
    }

    public static void main(String[] args) {
        printJiShuTest();
    }
}
