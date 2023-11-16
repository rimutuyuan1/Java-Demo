package com.forezp.thread.suanfa.删除链表中的重复元素2;

import com.forezp.thread.suanfa.bean.ListNode;
import lombok.val;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-16  10:46
 **/
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode h = new ListNode(0);
        h.next = new ListNode(1);
        h.next.next = new ListNode(1);
        h.next.next.next = new ListNode(3);
        h.next.next.next.next = new ListNode(3);
        h.next.next.next.next.next = new ListNode(4);
        h.next.next.next.next.next.next = new ListNode(4);
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        ListNode listNode = deleteDuplicates.deleteDuplicates(h);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        // 初始化一个虚拟节点dummy，next指向head，因为head也有可能是重复的
        // 初始化一个cur节点指向dummy，使用cur指针去遍历
        // 如果cur的next节点值和cur的next的next节点值不相等，将cur指针前进到cur的next节点
        // 如果cur的next节点值和cur的next的next节点值相等，说明是重复节点，需要将节点删除，
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.next.val == cur.next.val) {
                int val = cur.next.val;
                // 删除重复节点
                while (cur.next != null && val == cur.next.val) {
                    cur.next = cur.next.next;
                }
            }
            else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
