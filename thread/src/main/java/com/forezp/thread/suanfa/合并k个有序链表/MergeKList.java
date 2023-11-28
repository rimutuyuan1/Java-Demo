package com.forezp.thread.suanfa.合并k个有序链表;

import com.forezp.thread.suanfa.bean.ListNode;
import lombok.val;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-26  19:48
 **/
public class MergeKList {

    public static void main(String[] args) {

    }

    public ListNode mergeK(List<ListNode> lists) {
        //先将k个链表中的头部全部放入优先级队列（小根堆）
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }
        //拿出头结点（最小节点），该节点此时拿出来的原因是需要最终返回出去
        ListNode head = queue.poll();
        if (head == null) {
            return null;
        }
        //定义一个指针指向头结点，不断往后寻找
        ListNode cur = head;
        if (cur.next != null) {
            queue.offer(cur.next);
        }
        //如果队列不为空，先将队列中最小节点拿出来，挂到cur指针后边，然后将最小节点的next节点放入优先级队列
        //循环往复，直到队列为空，此时说明所有的链表元素都已经取到，直接返回head节点即可
        while (!queue.isEmpty()) {
            ListNode top = queue.poll();
            cur.next = top;
            cur = cur.next;
            if (top.next != null) {
                queue.offer(top.next);
            }
        }
        return head;
    }
}
