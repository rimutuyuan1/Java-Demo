package com.forezp.thread.ThreadAndRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallBackByThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future future = executorService.submit(new CallBack());
        Future future1 = executorService.submit(new CallBack());
        if (!future.isDone() && !future1.isDone()) {
            System.out.println("task is running,please wait");
        }
        try {
            System.out.println("task return is :" + future.get());
            System.out.println("task return is :" + future1.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("task is unexpected interrupt");
        } finally {
            executorService.shutdown();
        }
    }
}
