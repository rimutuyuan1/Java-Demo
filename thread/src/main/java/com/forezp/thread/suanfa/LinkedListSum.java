package com.forezp.thread.suanfa;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-22  19:26
 **/
public class LinkedListSum {

    public static void main(String[] args) {
        ListNode x = new ListNode(4);
        x.next = new ListNode(5);
        x.next.next = new ListNode(7);
        x.next.next.next = new ListNode(3);

        ListNode y = new ListNode(9);
        y.next = new ListNode(2);
        y.next.next = new ListNode(8);
        y.next.next.next = new ListNode(6);

        ListNode listNode = addTwoNumbers(x, y);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
    /**
     * 将两个链表表示的数相加
     *
     * @param l1 链表l1
     * @param l2 链表l2
     * @return 相加后的链表
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个哑节点作为辅助节点
        ListNode dummy = new ListNode();
        // 定义指针，初始指向哑节点
        ListNode cur = dummy; //定义指针
        // 进位标志，初始值为0
        int carry = 0;

        // 循环进行加法操作，直到其中一个链表为空
        while (l1 != null || l2 != null) {
            // 如果l1为空，则x赋值为0；否则l1的值赋给x
            int x = l1 ==null ? 0 : l1.val;
            // 如果l2为空，则y赋值为0；否则l2的值赋给y
            int y = l2 == null ? 0 : l2.val;
            // x、y和进位值carry相加得到和sum
            int sum = x + y + carry;

            // 对sum求余数得到个位数，赋给val
            int val = sum % 10;
            // 对sum除以10得到商carry（进位值）
            carry = sum / 10;

            // 在当前节点cur后创建一个新节点，节点的值为val
            cur.next = new ListNode(val);
            // 将指针cur指向新节点
            cur = cur.next;

            // 如果l1不为空，则将l1的下一个节点赋给l1；如果l1为空，则跳过此步骤
            if (l1 != null) {
                l1 = l1.next;
            }
            // 如果l2不为空，则将l2的下一个节点赋给l2；如果l2为空，则跳过此步骤
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果进位值为1，则在最后添加一个值为1的节点作为进位结果
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        // 返回从哑节点开始的链表（相加后的链表）
        return dummy.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
