package com.forezp.thread.mianshi;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 11:56 上午
 **/
public class leetcode53array {
    //一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    //输入: [0,1,3]
    //输出: 2

    public static void main(String[] args) {
        int[] nums = {0,1,3,4,5,6,7};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber01(nums));
    }

    //普通的直接判断索引下标值是否和值相同
    public static int missingNumber01(int[] nums) {
        if (nums[0] == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    //二分查找
    public static int missingNumber(int[] nums) {
        int i = 0,j = nums.length - 1;
        int m;
        while(i <= j) {
            m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
