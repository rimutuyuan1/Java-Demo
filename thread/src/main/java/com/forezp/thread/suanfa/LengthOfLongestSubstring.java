package com.forezp.thread.suanfa;

import com.forezp.thread.suanfa.bean.ListNode;

import java.util.PriorityQueue;


/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-31  19:08
 **/
public class LengthOfLongestSubstring {

    public Integer findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.add(num);
        }

        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public ListNode revertNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            next = cur;

        }
        return cur;
    }

    public static void print() {
        int k = 10; // 给定的k值
        int i = 0;
        while (i < k - 1) {
            // 在此处执行迭代操作
            // 例如，打印迭代次数
            System.out.println("迭代次数：" + (i + 1));
            i++;
        }
    }


    public static void main(String[] args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
        System.out.println(s.findKthLargest(new int[]{1, 2,3,5,6,7,8}, 3));
        print();
    }
}
