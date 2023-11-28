package com.forezp.thread.suanfa.排序链表;

import com.forezp.thread.suanfa.bean.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-19  15:38
 **/
public class SortList2 {

    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        while (head != null) {
            queue.offer(head);
            head = head.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(1);
        SortList2 s = new SortList2();
        ListNode listNode = s.sortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
