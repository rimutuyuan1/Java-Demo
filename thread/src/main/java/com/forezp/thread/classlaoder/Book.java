package com.forezp.thread.classlaoder;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2021/8/23 下午19:54
 **/
public class Book {

    public static void main(String[] args) {
        System.out.println("Hello World.");
    }

    Book() {
        System.out.println("构造方法");
        System.out.println("price=" + price +",amount=" + amount);
    }

    {
        System.out.println("普通代码块");
    }

    int price = 110;

    static {
        System.out.println("静态代码块");
    }

    static int amount = 112;

}
