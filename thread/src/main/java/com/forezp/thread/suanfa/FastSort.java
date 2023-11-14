package com.forezp.thread.suanfa;

import java.util.Arrays;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-24  20:00
 **/
public class FastSort {

    public static void main(String[] args) {
        int[] nums = {5, 3, 11, 2, 9, 6, 8, 9};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 快排
     */
    private static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            //大放过，小交换
            if (nums[i] <= pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
