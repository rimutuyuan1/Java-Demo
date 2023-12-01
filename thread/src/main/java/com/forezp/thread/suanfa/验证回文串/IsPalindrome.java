package com.forezp.thread.suanfa.验证回文串;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-28  17:24
 **/
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(new IsPalindrome().isPalindrome(s));
    }

    //如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
    //字母和数字都属于字母数字字符。

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (Character a : chars) {
            if (Character.isLetterOrDigit(a)) {
                sb.append(Character.toLowerCase(a));
            }
        }
        //处理后的字符串sp
        String sp = sb.toString();

        int left = 0;
        char[] chars2 = sp.toCharArray();
        int right = sp.length() - 1;

        while (left < right) {
            char temp = chars2[left];
            chars2[left] = chars2[right];
            chars2[right] = temp;

            left++;
            right--;
        }
        return sp.equals(new String(chars2));
    }
}
