package com.forezp.thread.suanfa.字符串相加;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-14  16:20
 **/
public class AddStrings {

    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        System.out.println(a.addStrings("456", "77"));
    }

    public String addStrings(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        //计算进位，最后需要判断进位是否大于0，如果大于需要进位1
        int carry = 0;
        while (len1 >= 0 || len2 >= 0) {
            //注意有坑：
            //num1.charAt(len1) - '0' 和  num1.charAt(len1)  不同:
            //num1.charAt(len1)仅取索引位置的char值而不是获取对应的数值
            //num1.charAt(len1) - '0'   这里分三步讲
            // 1. 获取len1下标位置的char值 A
            // 2. 获取0的unicode编码
            // 3. A - 0的unicode编码意味着 A的编码（5的编码53） - 0的编码（48） 得到 5
            //******需要通过一个减0的操作将char值转换为具体的数值******
            int x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;

            int sum = x + y + carry;
            int val  = sum % 10;
            carry = sum / 10;
            sb.append(val);

            len1--;
            len2--;
        }

        if (carry > 0) {
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }
}
