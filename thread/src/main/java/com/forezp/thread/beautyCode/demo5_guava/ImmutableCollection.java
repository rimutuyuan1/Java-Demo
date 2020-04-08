package com.forezp.thread.beautyCode.demo5_guava;


import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.List;

public class ImmutableCollection {

    // 三种创建不可变对象的方式
    // copyOf 从现有的集合中拷贝    of初始值创建    builder构造器创建

    private static void immutable() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        ImmutableSet set = ImmutableSet.of(1, 2, 3);
        ImmutableMap map = ImmutableMap.of(1, 3, 2, 4);
        ImmutableSet immutableSet = ImmutableSet.copyOf(list);
        ImmutableSet immutableSets = ImmutableSet.builder().add("4","5","6").build();
        System.out.println(set);
        System.out.println(map);
        System.out.println(immutableSet);
        System.out.println(immutableSets);
        Preconditions.checkArgument(list.get(0) == 2, "数值必须为2");
    }

    public static void main(String[] args) {
        immutable();
    }

}
