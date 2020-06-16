package com.forezp.thread.order;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/10 9:50 上午
 **/
public class swtichTest {

    public static void main(String[] args) {
        int result = 0;
        int a = 2;
        switch (a) {
            case 1:
                result += a;
            case 2:
                result += a * 2;
            case 3:
                result += a * 3;
            default:
                result += a * 4;
        }
        System.out.println(result);
    }
}
