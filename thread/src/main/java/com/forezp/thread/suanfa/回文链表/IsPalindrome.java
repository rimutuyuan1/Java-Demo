package com.forezp.thread.suanfa.回文链表;

import com.forezp.thread.suanfa.bean.ListNode;

import java.util.Stack;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-28  17:40
 **/
public class IsPalindrome {

    public static void main(String[] args) {
        // 构造一个回文链表示例
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        IsPalindrome i = new IsPalindrome();
        System.out.println(i.isPalindrome(head));
    }

    //给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

    //解法1 可以使用额外数据结构如栈或者数组实现，但空间复杂度为O(n)
    //解法2 将链表的后半段翻转，从中间断开，判断两个链表是否值相等，如果相等则为回文链表，最后将链表恢复
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //此时需要从slow节点处断开
        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode cur = secondHead;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //此时cur指针指向的位置即是第二个链表的头部
        ListNode firstIndex = head;
        ListNode secondIndex = pre;

        while (firstIndex != null && secondIndex != null) {
            if (firstIndex.val != secondIndex.val) {
                return false;
            }
            firstIndex = firstIndex.next;
            secondIndex = secondHead.next;
        }

        return true;
    }
}
