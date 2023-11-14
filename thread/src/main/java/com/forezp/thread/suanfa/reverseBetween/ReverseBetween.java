package com.forezp.thread.suanfa.reverseBetween;

import com.forezp.thread.suanfa.bean.ListNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-03  17:43
 **/
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        ReverseBetween r = new ReverseBetween();
        ListNode reverse = r.reverseBetween(head, 2, 5);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    //本题的思路为：通过一个哨兵节点，使用该节点的指针进行移动，先找到left的前一个位置p0，这样前一个位置和left对应的位置（p0.next）就都找到了
    //然后再循环right - left次，找到right的节点，当然也是通过pre和cur指针去移动查找，循环结束后，pre指向的是right节点的位置，cur指向的是right + 1节点的位置
    //这样四个位置就都找到了
    //然后连接节点即可：p0的next指针先保存一下，然后将p0的next.next指针指向right节点的位置；将p0的next指针指向right + 1节点的位置
    //             1  ---->  2  ---->  3  ---->  4  --->  5  ---->  6        left  2   right 5
    //  dummy -->  1  ---->  2  ---->  3  ---->  4  --->  5  ---->  6
    //             p0       p0.next                      pre       cur
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        //使用一个哨兵节点dummy，next指针直接指向head，结束后直接返回dummy的next指针即可
        ListNode dummy = new ListNode(-1, head);
        //用p0 = dummy做指针，进行移动，找到left的前一个位置，这样前一个位置和left对应的位置就一致了
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        //此时p0就指向了待翻转链表的起始位置的前一个位置
        //在此区间内做翻转
        //
        ListNode pre = p0;
        ListNode cur = p0.next;
        for (int j = 0; j < right - left + 1; j++) {
            //翻转链表
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //此时pre就指向了翻转链表待排序区间的最后一个位置
        //这里注意顺序，先将p0的next.next指向cur，不然p0的next指针就无法指向pre了
        ListNode next = p0.next;
        p0.next = pre;
        next.next = cur;

        return dummy.next;
    }

    //普通的翻转链表
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
