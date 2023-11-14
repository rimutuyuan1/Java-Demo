package com.forezp.thread.suanfa.maxProfit;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-01  19:07
 **/
public class MaxProfit {

    //暴力
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    //一次遍历
    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //维护一个最大利润
        int maxProfit = 0;
        //维护一个最小价格
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //不断去寻找最小价格，如果当前值小于最小价格，将最小价格更新为当前值
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            //判断当前值 - 最小价格 是否大于 最大利润，如果大于更新成 当前值 - 最小价格
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    //动归 TODO

    public static void main(String[] args) {
        MaxProfit m = new MaxProfit();
        System.out.println(m.maxProfit2(new int[]{7,1,5,3,6,4}));
    }
}
