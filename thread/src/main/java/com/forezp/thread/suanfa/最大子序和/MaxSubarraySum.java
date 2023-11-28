package com.forezp.thread.suanfa.最大子序和;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-27  11:49
 **/
public class MaxSubarraySum {

    public int maxSubarraySum(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return nums.length;
        }
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            //比较当前元素与当前子数组和加上当前元素的和，取较大值作为新的当前子数组和
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            //比较当前子数组和和maxSum，取较大值作为新的最大子数组和
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubarraySum m = new MaxSubarraySum();
        System.out.println(m.maxSubarraySum(nums));
    }
}
