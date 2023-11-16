package com.forezp.thread.suanfa.删除链表中的重复元素2;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-16  10:46
 **/
public class DeleteDuplicates1 {

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        h.next = new ListNode(0);
        h.next.next = new ListNode(1);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(3);
        h.next.next.next.next.next = new ListNode(4);
        h.next.next.next.next.next.next = new ListNode(4);
        DeleteDuplicates1 deleteDuplicates = new DeleteDuplicates1();
        ListNode listNode = deleteDuplicates.deleteDuplicates(h);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            } else {
                //两值相等
                int val =  cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            }
        }

        return dummy.next;
    }






}
