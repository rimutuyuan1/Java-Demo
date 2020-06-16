package com.forezp.thread.sort;

import java.util.Arrays;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/2 6:24 下午
 **/
public class BubbleSort {

    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {return;}
        int temp;
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                    count++;
                }
            }
            if (!flag) {break;}
        }
        System.out.println(Arrays.toString(a));
        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] i = {3, 6, -2, 9, -6, 11};
        int n = 6;
        bubbleSort(i, n);
    }
}
