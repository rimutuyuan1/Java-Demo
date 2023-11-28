package com.forezp.thread.suanfa.排序链表;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-19  15:17
 **/
public class SortList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(1);
        SortList s = new SortList();
        //ListNode listNode = s.middle(head);
        ListNode listNode = s.sortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow  = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时，slow指针就是链表的中间节点
        //断开链表
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode listNode = sortList(head);
        ListNode listNode1 = sortList(head2);
        return merge(listNode, listNode1);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        return dummy.next;
    }

}
