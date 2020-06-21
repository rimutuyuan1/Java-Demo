package com.forezp.thread.codeWrite.feibonaqi;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/19 2:50 下午
 **/
public class FeiBoNaQiTest {

    //  0 1 1 2 3 5 8 13 21 34 55
    //

    private static int print(int num) {
        if (num == 0 || num == 1) return num;
        else {
            return print(num - 1) + print(num - 2);
        }
    }

    private static int printByRecursive(int num) {
        return 1;
    }

    public static void main(String[] args) {
        int prev = 0;
        int next = 0;
        int sum = 0;
        int[] arr = new int[sum];
        for (int i = 0; i < 10; i++) {
            sum = prev + next;
            if (i == 0 || i == 1) System.out.println(sum);
            else System.out.println(sum);

        }

        //  0  1  1  3
    }
}
