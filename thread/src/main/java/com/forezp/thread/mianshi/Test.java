package com.forezp.thread.mianshi;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 12:35 下午
 **/
public class Test {

    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i < 5; i++) {
            a = a++;
        }
        //System.out.println(a);
        System.out.println(test());
    }

    private static int test() {
        int i= 0;
        i++;
        return i;
    }
}
