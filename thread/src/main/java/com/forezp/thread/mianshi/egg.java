package com.forezp.thread.mianshi;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2020/6/18 12:00 上午
 **/
public class egg {

    // 有N个鸡蛋，要依次投放到如下盒子中（盒子数未知，直至全部放入为止），
    // 【1】，【2】，【4】，【8】，【16】。。。。【？】
    //请问，已知n个鸡蛋，最后一个盒子有多少个鸡蛋？

    private static int eggTest(int eggNums) {
        if (eggNums <= 0) return -1;
        int current = 1;
        while (eggNums >= current) {
            eggNums -= current;
            current *= 2;
        }
        return eggNums;

    }

    public static void main(String[] args) {
        System.out.println(eggTest(18));
    }
}
