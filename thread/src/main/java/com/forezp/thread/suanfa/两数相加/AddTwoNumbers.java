package com.forezp.thread.suanfa.两数相加;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-25  17:14
 **/
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            int val = sum % 10;

            cur.next = new ListNode(val);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(4);
        x.next = new ListNode(5);
        x.next.next = new ListNode(7);
        x.next.next.next = new ListNode(3);

        ListNode y = new ListNode(9);
        y.next = new ListNode(2);
        y.next.next = new ListNode(8);
        y.next.next.next = new ListNode(6);
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode listNode = a.addTwoNumbers(x, y);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
