package com.forezp.thread.suanfa;

import java.util.Arrays;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-01  21:26
 **/
public class mergeSortedArray {

    //1. 两个数组先合并再整体排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {

    }

    public static void main(String[] args) {
        mergeSortedArray m = new mergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        m.merge1(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
