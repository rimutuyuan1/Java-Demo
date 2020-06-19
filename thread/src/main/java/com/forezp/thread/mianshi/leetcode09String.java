package com.forezp.thread.mianshi;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 5:01 下午
 **/
public class leetcode09String {

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int begin = 0;
        String str = String.valueOf(x);
        int end = str.length() - 1;
        while (begin != end) {
            if (str.charAt(end) == str.charAt(begin)) {
                begin++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
