package com.forezp.thread.suanfa.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-01  14:01
 **/
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(t.threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return null;
        }
        //先排序，保证从左到右越来越大
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //如果当前下标的值大于0，因为已排序，所以和肯定大于0，该情况跳过
            //如果当前下标的值和下一个下标的位置相等，说明会出现重复的情况，该情况跳过
            if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            //固定一个数，然后左右两个指针left、right分别指向第i的下一个元素和最后一个元素
            //获取三个数的和，如果和大于0，将right--，再次比较；如果和小于0，将left++，再次比较；如果等于0，将left++，right--，再次比较，知道left>right
            int val = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = val + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //考虑重复的情况，如果left位置的值和left+1位置的值相同，说明肯定会重复，需要将left++
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    //考虑重复的情况，如果right位置的值和right-1位置的值相同，说明肯定会重复，需要将right++
                    while (left < right && nums[right] == nums[right - 1]) {
                        right++;
                    }

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return res;
    }
}
