package com.forezp.thread.mianshi;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 2:56 下午
 **/
public class leetcode26array {

    //给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

    //给定数组 nums = [1,1,2],
    //函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 你不需要考虑数组中超出新长度后面的元素。

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 1 || nums == null) return 0;
        int begin = 0;
        for (int end = 1; end < nums.length; end++) {
            if (nums[begin] != nums[end]) {
                begin++;
                nums[begin] = nums[end];
            }
        }
        return begin + 1;
    }
}
