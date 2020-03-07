package com.forezp.thread.exam;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testController {

    public  static void main(String[] args) throws InterruptedException {

        testController ttt = new testController();

        synchronized (ttt){
            ttt.wait();
        }
    }

}
