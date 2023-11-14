package com.forezp.thread.suanfa.maxSubArray;

/**
 * @Author 王鑫涛
 * @Description 最大子序和 <a href="https://leetcode.cn/problems/maximum-subarray/description/">...</a>
 * @Date 2023-11-01  14:43
 **/
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray m = new MaxSubArray();
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.maxSubArray(a));
    }

    // Kadane算法扫描一次整个数列的所有数值，
    // 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
    // 该子数列由两部分组成：以前一个位置为结束点的最大子数列、该位置的数值。
    // 因为该算法用到了“最佳子结构”（以每个位置为终点的最大子数列都是基于其前一位置的最大子数列计算得出,
    // 该算法可看成动态规划的一个例子。
    // 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
    // 其中(sum[i]记录以a[i]为子序列末端的最大序子列连续和)
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        // 在每一个扫描点计算以该点数值为结束点的子数列的最大和（正数和）。
        int max_ending_here = nums[0];
        int max_so_far = nums[0];

        for (int i = 1; i < nums.length; i ++ ) {
            // 以每个位置为终点的最大子数列 都是基于其前一位置的最大子数列计算得出,
            max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}
