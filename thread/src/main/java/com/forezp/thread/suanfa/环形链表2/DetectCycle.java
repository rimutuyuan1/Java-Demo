package com.forezp.thread.suanfa.环形链表2;

import com.forezp.thread.suanfa.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-14  17:19
 **/
public class DetectCycle {

    //通过一个hashset判断当前节点是否存在于set中，如果存在说明之前遍历过，该节点就是环的入口，否则返回空
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode index = head;
        Set<ListNode> set = new HashSet<>();

        while (index != null) {
            if (set.contains(index)) {
                return index;
            }
            set.add(index);
            index = index.next;
        }
        return null;
    }
}
