package com.forezp.thread.suanfa.回文数;

import java.util.Stack;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-28  16:44
 **/
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome i = new IsPalindrome();
        int x = 1234567899;
        System.out.println(i.isPalindrome1(x));
        System.out.println(i.isPalindrome2(x));
    }

    //使用栈实现
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        Stack<Character> stack = new Stack<>();

        String str = String.valueOf(x);
        char[] arr = str.toCharArray();

        for (char c : arr) {
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString().equals(str);
    }

    //该方法实现如果int值超过Integer.MAX_VALUE,结果会溢出，需要直接用字符串比较，不能通过Integer.parseInt()方法转int后再比较
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        String str = String.valueOf(x);
        char[] arr = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr).equals(str);
    }

}
