package com.forezp.thread.ThreadAndRunnable;


import java.util.concurrent.Callable;

public class CallBack implements Callable {

    @Override
    public Object call() throws Exception {
        String val = "王鑫涛";
        System.out.println("task is run");
        Thread.sleep(5000);
        System.out.println("task is done");
        return val;
    }
}
