package com.forezp.thread.suanfa.对链表进行插入排序;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-19  12:34
 **/
public class InsertListNode2 {

    public ListNode InsertListNode(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            //开始更新指针操作
            ListNode next = cur.next;

            ListNode prev = dummy;
            while (prev.next != null && prev.next.val <= cur.val) {
                prev = prev.next;
            }
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(5);
        h.next = new ListNode(4);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(2);

        InsertListNode2 i = new InsertListNode2();
        ListNode listNode = i.InsertListNode(h);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
