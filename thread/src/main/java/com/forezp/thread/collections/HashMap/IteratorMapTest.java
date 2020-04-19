package com.forezp.thread.collections.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/4/19 10:33 下午
 **/
public class IteratorMapTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(16);
        map.put("a", "王鑫涛");
        map.put("b", "马云");
        map.put("c", "张一鸣");
        map.put("d", "马化腾");

        Set<Map.Entry<String,String>> set = map.entrySet();
        Iterator<Map.Entry<String,String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,String> next = iterator.next();
            System.out.println("key:" + next.getKey() + "\n");
            System.out.println("val:" + next.getKey()+ "\n"); //正确执行迭代

            //System.out.println("key:" + iterator.next().getKey() + "\n");
            //System.out.println("val:" + iterator.next().getKey()+ "\n"); 不会正确执行迭代
        }
    }
}
