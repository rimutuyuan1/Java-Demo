package com.forezp.thread.suanfa.翻转链表;

import com.forezp.thread.suanfa.bean.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-16  10:19
 **/
public class ReverseListNode1 {

    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        h.next = new ListNode(1);
        h.next.next = new ListNode(2);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(4);

        ReverseListNode1 r = new ReverseListNode1();

        ListNode reverse = r.reverse(h);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
