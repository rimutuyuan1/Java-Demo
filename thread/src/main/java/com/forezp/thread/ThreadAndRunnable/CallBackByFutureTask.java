package com.forezp.thread.ThreadAndRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallBackByFutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new CallBack());
        new Thread(futureTask).start();
        if (!futureTask.isDone()) {
            System.out.println("task is running,please wait");
        }
        System.out.println("task return is : " + futureTask.get());
    }
}
