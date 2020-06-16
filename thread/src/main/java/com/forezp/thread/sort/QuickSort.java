package com.forezp.thread.sort;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/2 9:38 下午
 **/
public class QuickSort {

    public static void main(String[] args) {
        //quicksort();
    }

    static void quicksort(int[] n, int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(int[] n, int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
}
