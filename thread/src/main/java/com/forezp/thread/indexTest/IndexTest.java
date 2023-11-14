package com.forezp.thread.indexTest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-23  15:25
 **/
public class IndexTest {

    public static int i;

    public static void main(String[] args) {
        int i = 5;
        int result1 = ++i; // 前缀递增，result1的值为6，i的值也为6
        System.out.println(result1);
        int j = 5;
        int result2 = j++; // 后缀递增，result2的值为5（先返回j的当前值），然后j的值增加为6
        System.out.println(result2);
    }

}
