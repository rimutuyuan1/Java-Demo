package com.forezp.thread.suanfa.训练计划2;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-25  16:22
 **/
public class TrainingPlan2 {

    public ListNode trainingPlan2(ListNode head, int cur) {
        ListNode slow = head;
        ListNode fast = head;

        while (cur != 0) {
            fast = fast.next;
            cur--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        //此时slow指针指向的就是倒数第cur个元素
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(8);
        TrainingPlan2 t = new TrainingPlan2();
        ListNode listNode = t.trainingPlan2(head, 2);
        System.out.println(listNode.val);
    }
}
