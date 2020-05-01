package com.forezp.thread.condition;

import com.forezp.thread.innerClass.Inter;

import java.util.*;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/4/27 8:47 下午
 **/
public class ArrTest {

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,2,1,1,1,1,3,3,3,3,3,3,3,3,4};
        int count = 1;
        Map<Integer, Integer> maps = new TreeMap<>(Integer::compareTo);
        for (int i = 0; i < arr.length; i++) {
            if (maps.containsValue(arr[i])) {
                maps.replace(arr[i], count++);
            } else {
                maps.put(1, arr[i]);
                count = 1;
            }
        }

        System.out.println(maps.toString());

    }
}
