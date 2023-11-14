package com.forezp.thread.suanfa;

/**
 * @Author 王鑫涛
 * @Description 二分查找
 * @Date 2023-10-25  15:00
 **/
public class BinarySearch {

    //nums    middle    left   right
    //     5         2       0      4
    //     6         2       0      5
    //     8         3       0      7

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {-1, 4, 6, 7, 9, 9, 13};
        int target = 9;
        int i = bs.binarySearch(nums, target);
        System.out.println(i);
    }

}
