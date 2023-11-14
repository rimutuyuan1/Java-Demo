package com.forezp.thread.parent;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-03  11:38
 **/
public class Child extends Parent{


    @Override
    public void printP() {
        System.out.println("i am son");
    }

    public void printC() {
        System.out.println(" i am son 2");
    }

}
