package com.forezp.thread.suanfa;

/**
 * @Author 王鑫涛
 * @Description 搜索插入位置
 * @Date 2023-10-25  16:03
 **/
public class SearchInsertPosition_35 {

    //解法2：二分查找
    //寻找中间值，如果中间值小于target，说明一定不在左区间中，如果中间值等于target，直接返回该位置下标，如果中间值大于target，说明目标值在左区间，需要将right设置为mid
    //时间复杂度  O(logN) 空间复杂度 O(1)
    public int searchInsertPosition2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left  + right ) /2;
            if (nums[mid]  == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    //解法1：直接根据下标遍历数组，寻找第一个大于等于target的值，当前值即是待插入的位置
    //时间复杂度  O(N) 空间复杂度 O(1)
    public int searchInsertPosition1(int[] nums, int target) {
        //寻找目标值大于等于target
        for (int i  = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        SearchInsertPosition_35 s = new SearchInsertPosition_35();
        int[] nums = {1, 3, 4, 6, 9, 12};
        int target = 5;
        System.out.println(s.searchInsertPosition2(nums, target));
    }
}
