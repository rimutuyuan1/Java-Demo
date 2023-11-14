package com.forezp.thread.suanfa.mergeTwoLists;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description 合并两个有序链表
 * @Date 2023-11-01  16:37
 **/
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;

        //p1和p2均不为空时，进入循环
        while (p1 != null && p2 != null) {
            //移动指针
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                //移动指针
                cur.next = p2;
                p2 = p2.next;
            }
            //移动指针
            cur = cur.next;
        }

        //退出循环后，有可能某一个链上还有未遍历到的数据，挂载到cur后边即可
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return  dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        MergeTwoLists mt = new MergeTwoLists();
        ListNode listNode = mt.mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
