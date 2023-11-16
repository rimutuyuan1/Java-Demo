package com.forezp.thread.suanfa.链表香蕉;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description 链表香蕉
 * @Date 2023-11-14  15:37
 **/
public class GetIntersectionNode {

    //香蕉链表：这道题的思想在于，两个链表有长有短（当然也可能长度相等，这种情况比较好处理，一会再说）
    // 如果相交，说明两个链表自相交节点起以后的长度肯定相等，所以先求出两个链表的长度step，
    // 然后将长链表的指针向后跳step步，此时两个链表再同时向后跳，碰到节点相等即说明该节点是相交位置（注意是节点相等，而不是节点的val相等）
    // 如果跳到两个链表结束都不相等，说明无相交节点，返回null即可
    // 如果两个链表长度相等，不需要先跳step步，两个链表通过指针同时向后跳即可。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len_a = 0;
        int len_b = 0;
        ListNode index_a = headA;
        ListNode index_b = headB;
        while (index_a != null) {
            len_a++;
            index_a = index_a.next;
        }
        while (index_b != null) {
            len_b++;
            index_b = index_b.next;
        }
        index_a = headA;
        index_b = headB;

        //差值：即长链表需要跳的步数
        int step = len_a - len_b;

        if (step > 0) {
            //说明a比b长，需要将a链表的指针指向和b链表的头一样长的位置
            while (step != 0) {
                index_a = index_a.next;
                step--;
            }
        } else if (step < 0) {
            //说明b比a长，需要将b链表的指针指向和a链表的头一样长的位置
            while (step != 0) {
                index_b = index_b.next;
                step++;
            }
        }
        //a和b长度相等，直接同时向后跳即可
        while (index_b != null && index_a != null) {
            if (index_a == index_b) {
                return index_a;
            }
            index_a = index_a.next;
            index_b = index_b.next;
        }
        return index_a;
    }

    public ListNode get(ListNode index_a, ListNode index_b) {
        while (index_b != null && index_a != null) {
            //节点相等
            if (index_a == index_b) {
                return index_a;
            }
            index_a = index_a.next;
            index_b = index_b.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(6);

        GetIntersectionNode g = new GetIntersectionNode();
        ListNode listNode = g.getIntersectionNode(head, head1);
        while (listNode != null ) {
            System.out.println(listNode.val);
            listNode= listNode.next;
        }
    }
}
