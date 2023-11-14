package com.forezp.thread.suanfa.fib;

import java.util.Arrays;

/**
 * @Author 王鑫涛
 * @Description 斐波那契数
 * @Date 2023-11-01  16:11
 **/
public class Fib {

    public int[] fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 18;
        dp[1] = 26;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp;
    }

    public static void main(String[] args) {
        Fib f = new Fib();
        //0 1 1 2 3 5
        System.out.println(Arrays.toString(f.fib(5)));
    }
}
