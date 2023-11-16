package com.forezp.thread.suanfa.reorderList;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description 重排链表
 * @Date 2023-11-15  21:17
 **/
public class ReorderList {

    public void reorderList(ListNode head) {
        //先计算链表的中间节点
        //翻转从中间节点往后的链表，并返回链表第一个节点（翻转后）
        //两个链表连接即可

        ListNode middle = middleList(head);

        ListNode head2 = reverseList(middle);

        while (head != null && head2 != null) {
            ListNode next1 = head.next;
            ListNode next2 = head2.next;

            head.next = head2;
            head2.next = next1;

            head = next1;
            head2 = next2;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;

        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public ListNode middleList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        h.next = new ListNode(1);
        h.next.next = new ListNode(2);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(4);

        ReorderList r = new ReorderList();

        r.reorderList(h);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }



}
