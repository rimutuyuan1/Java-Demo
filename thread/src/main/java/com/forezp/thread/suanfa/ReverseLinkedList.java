package com.forezp.thread.suanfa;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-27  17:13
 **/
public class ReverseLinkedList {

    public static void main(String[] args) {
        String words = "i am a student";
        System.out.println(reverseWords1(words));

        System.out.println("------");
       // String reverse = reverse(words, 0, words.length() - 1);


    }

    public static String reverse(char[] charArray, int begin, int end) {

        while (begin <= end) {
            char temp = charArray[begin];
            charArray[begin] = charArray[end];
            charArray[end] = temp;
            begin++;
            end--;
        }

        return Arrays.toString(charArray);
    }

    //不使用额外空间
    public static String reverseWords2(String words) {
        char[] charArray = words.toCharArray();

        int start = 0;
        int end = 0;

        while (start < charArray.length) {


        }

        return new String(charArray);
    }

    //使用额外空间：栈
    public static String reverseWords1(String words) {
        String[] split = words.split(" ");
        if (split.length == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

}
