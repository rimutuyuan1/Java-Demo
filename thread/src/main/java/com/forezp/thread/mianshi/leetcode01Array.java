package com.forezp.thread.mianshi;

import java.util.Arrays;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 4:20 下午
 **/
public class leetcode01Array {

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int begin = 0;
        int end = 1;
        while(end < nums.length) {
            if (target - nums[begin] == nums[end]) {
                return new int[] {begin, end};
            }else {
                begin++;
                end++;
            }
        }
        return null;
    }
}
