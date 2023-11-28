package com.forezp.thread.suanfa.对链表进行插入排序;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-19  10:57
 **/
public class InsertListNode {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            //先将cur.next保存下来
            ListNode next = cur.next;
            ListNode prev = dummy;
            //定义一个prev指针指向dummy，需要从哑结点开始遍历，直到大于cur.val为止
            while (prev.next != null && prev.next.val <= cur.val) {
                prev = prev.next;
            }
            //将cur.next指针指向prev.next
            cur.next = prev.next;
            //将prev.next指针指向cur
            prev.next = cur;
            cur = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(5);
        h.next = new ListNode(2);
        h.next.next = new ListNode(1);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(3);

        InsertListNode i = new InsertListNode();
        ListNode listNode = i.insertionSortList(h);
        while ( listNode != null ) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
