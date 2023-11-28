package com.forezp.thread.suanfa.翻转字符串中的单词;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-25  10:25
 **/
public class ReverseWords {

    //给你一个字符串 s ，请你反转字符串中 单词 的顺序。
    //单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    //返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
    //注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

    //题解1：使用栈
    //首先将字符串的前后的空格都去掉
    //然后while循环不断更新left指针，直到当前字符为空，此时将sb append的值放入stack
    //然后再不断更新left指针，直到当前字符不为空，此时进入下一次循环即可
    private static String reverseWords(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c != ' ') {
                stack.push(c); // 将非空格字符压入栈中
            } else {
                while (!stack.isEmpty()) {
                    result.append(stack.pop()); // 弹出栈中的字符并添加到结果中
                }
                result.append(' '); // 添加空格到结果中
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()); // 处理最后一个单词前的字符
        }

        return result.toString();
    }

    //解法2，先翻转整体字符串，分别翻转空格单词
    private static String reverseWords02(String input) {
        char[] chars = input.toCharArray(); // 将字符串转换为字符数组

        reverseArray(chars, 0, chars.length - 1); // 反转整个字符数组

        int start = 0;
        for (int end = 0; end < chars.length; end++) {
            if (chars[end] == ' ') {
                reverseArray(chars, start, end - 1); // 反转一个单词
                start = end + 1;
            }
        }

        reverseArray(chars, start, chars.length - 1); // 反转最后一个单词

        return new String(chars); // 将字符数组转换回字符串
    }

    private static void reverseArray(char[] chars, int start, int end) {
        while (start < end) {
            // 交换字符
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            // 移动指针
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        String s = "the sky is blue ";
        System.out.println(ReverseWords.reverseWords02(s));
    }
}
