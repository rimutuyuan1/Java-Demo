package com.forezp.thread;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-28  17:32
 **/
public class Test1 {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                method1(20);
            }
        };

        t1.setName("t1");
        t1.start();
        method1(10);
    }

    public void yes() {
        System.out.println("this is a face mapping");
    }

    public static void method1(int x) {
        int y = x +1;
        Object m = method2();
        System.out.println(m.toString());
    }

    public static Object method2() {
        Object n = new Object();
        return n;
    }
}
