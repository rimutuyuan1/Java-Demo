package com.forezp.thread.sort;

import java.util.Arrays;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/2 8:02 下午
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] i = {88,8,99,9,101,11,77,36};
        selectSort(i);
    }

    public static void selectSort(int[] items) {
        if (items.length == 0) {return;}
        for (int i = 0; i < items.length - 1; i++) {
            int minIndex = i;
            int min = items[i];
            for (int j = 1 + i; j < items.length; j++) {
                if (min > items[j]) {
                    minIndex = j;
                    min = items[j];
                }
            }
            //交换第一个和最小值的值
            if (minIndex != i) {
                items[minIndex] = items[i];
                items[i] = min;
            }
            System.out.println(Arrays.toString(items));
        }
    }
}
