package com.forezp.thread.suanfa;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-20  17:29
 **/
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Random;

public class RandomIndex {

    public static int getRandomIndex(String str, char target) {
        if (StringUtils.isBlank(str)) {
            return -1;
        }
        int res = 0;
        int cnt = 0;
        Random random = new Random();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                cnt++;

                if (random.nextInt(cnt) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "asuacya";
        Map<Integer, Integer> cont = Maps.newHashMap();
        for (int a = 0; a < 100000; a++) {
            int a1 = getRandomIndex(str, 'a');
            Integer orDefault = cont.getOrDefault(a1, 0);
            orDefault++;
            cont.put(a1, orDefault);
        }
        System.out.println(cont);
    }
}