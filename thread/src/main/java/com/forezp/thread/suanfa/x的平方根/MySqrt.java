package com.forezp.thread.suanfa.x的平方根;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-18  14:36
 **/
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            //注意求两个数的mid值，需要如下写法
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                //题意为得到一个整数平方根，小数部分舍去，所以碰到mid * mid <= x时，需要先将ans设置为该值
                ans = mid;
                //然后再l = mid + 1
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MySqrt m = new MySqrt();
        System.out.println(m.mySqrt(8));
    }
}
