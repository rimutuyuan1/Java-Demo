package com.forezp.thread.suanfa;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-05  14:42
 **/
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("aaa", "pap"));
    }

    public static boolean isAnagram(String s, String t) {
        long l = System.currentTimeMillis();
        int[] record = new int[26];
        for (int i = 0; i < s.toCharArray().length; i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.toCharArray().length; i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        long p = System.currentTimeMillis();
        System.out.println((p - l) / 1000);
        return true;
    }
}
