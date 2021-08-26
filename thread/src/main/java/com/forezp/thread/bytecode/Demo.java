package com.forezp.thread.bytecode;

/**
 * @Author 王鑫涛
 * @Description 字节码
 * @Date 2021/8/14 下午10:48
 **/
public class Demo {

    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args){
        System.out.println("Hello World!");
    }

}


