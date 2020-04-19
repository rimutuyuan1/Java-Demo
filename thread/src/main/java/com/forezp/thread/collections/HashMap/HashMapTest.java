package com.forezp.thread.collections.HashMap;

import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author 王鑫涛
 * @Description 查看HashMap中capacity和size
 * @Date 2020/4/19 7:26 下午
 **/
public class HashMapTest {

    static Map<String,String> maps = Maps.newHashMap();

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        maps.put("chais", "wang");
        Class<?> mapType = maps.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(maps));
        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(maps));
    }
}
