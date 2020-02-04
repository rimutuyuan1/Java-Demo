package com.forezp.thread.publish;

import com.forezp.thread.annoations.NotRecommend;
import com.forezp.thread.annoations.NotThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;


/**
 * 发布对象: 使一个对象能够被当前范围之外的代码所看到
 * 对象逸出: 一种错误的发布，当一个对象还没有构造完成时，就使它能够被其他线程所看到
 *
 * 安全发布对象：
 * 1. 在静态初始化函数中初始化一个对象引用
 * 2. 在对象的引用保存到volatile类型域或者AtomicReference对象中
 * 3. 将对象的引用保存到某个正确构造的final类型域中
 * 4. 将对象的引用保存到一个由锁保护的域中
 * */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    private static Map<Integer,Integer> map = Maps.newHashMap();

    private final static ImmutableList list = ImmutableList.of(1, 1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> immutableMap = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2)
            .put(2, 4)
            .put(3, 6)
            .build();

    static {
        map.put(1, 2);
        map.put(2, 4);
        map.put(3, 5);
        map = Collections.unmodifiableMap(map);
    }

    public Escape () {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass () {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        log.info("{}", set);
    }
}
