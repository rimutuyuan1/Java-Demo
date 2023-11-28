package com.forezp.thread.suanfa.爬楼梯;

import java.util.Arrays;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-20  09:20
 **/
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 0 || n == 1) return n;
        //定义一个dp数组，存储爬到i层的N种方式
        int[] dp = new int[n + 1];
        //初始化dp数组，爬到一层只有一种方式（走一步），爬到二层有两种方式（走两个一步或者走一个两步）
        dp[1] = 1;
        dp[2] = 2;
        //开始递推
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        //返回第n的元素
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs c = new ClimbStairs();
        int i = c.climbStairs(6);
        System.out.println(i);
    }
}
