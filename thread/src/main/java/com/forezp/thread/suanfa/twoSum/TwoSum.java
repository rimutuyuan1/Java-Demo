package com.forezp.thread.suanfa.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-01  16:59
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return nums;
        }
        //key 数值   val 下标
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (mapping.containsKey(num)) {
                return new int[]{mapping.get(num), i};
            }
            mapping.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int[] arr = {1,3,5,7,9};
        System.out.println(Arrays.toString(s.twoSum(arr, 10)));
    }
}
