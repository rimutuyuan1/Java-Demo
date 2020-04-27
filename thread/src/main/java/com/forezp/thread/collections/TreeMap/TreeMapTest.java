package com.forezp.thread.collections.TreeMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/4/20 10:37 上午
 **/
public class TreeMapTest {

    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>();

        treeMap.put("arry", "c");
        treeMap.put("dependency", "d");
        treeMap.put("all", "a");
        treeMap.put("element", "e");
        treeMap.put("add", "b");

        Set<Map.Entry<String, String>> set = treeMap.entrySet();
        for (Map.Entry<String, String> stringStringEntry : set) {
            System.out.println(stringStringEntry.getValue());
        }
    }
}
