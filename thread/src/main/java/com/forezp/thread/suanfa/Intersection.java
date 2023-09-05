package com.forezp.thread.suanfa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-04  19:44
 **/
public class Intersection {

    public static void main(String[] args) {
        int[] n1 = new int[]{4,9,5};
        int[] n2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(n1, n2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums1) {
            set.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (Integer i : nums2) {
            if (set.contains(i)) {
                set2.add(i);
            }
        }
        int[] res = new int[set2.size()];
        int j = 0;
        for (Integer i : set2) {
            res[j++] = i;
        }

        return res;
    }
}
