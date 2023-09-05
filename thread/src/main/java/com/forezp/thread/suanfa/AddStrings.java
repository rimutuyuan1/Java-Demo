package com.forezp.thread.suanfa;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-04  20:10
 **/
public class AddStrings {

    public static void main(String[] args) {
        String a = "123";
        String b = "11";
        System.out.println(addStrings(a, b));

        int aaa = a.charAt(0) - 't';
        System.out.println(aaa);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;
        int carry = 0;
        while (num1Len >= 0 || num2Len >= 0) {
            int x = num1Len >= 0 ? num1.charAt(num1Len) - '0' : 0;
            int y = num2Len >= 0 ? num2.charAt(num2Len) - '0' : 0;
            int temp = x + y + carry;
            carry = temp / 10;
            int val = temp % 10;
            sb.append(val);
            num1Len--;
            num2Len--;
        }
        if (carry != 0) {
            sb.append(1);
        }
        sb.reverse();
        return sb.toString();
    }
}
