package com.forezp.thread.suanfa;

import com.forezp.thread.suanfa.bean.ListNode;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-25  17:40
 **/
public class DeleteDuplicates {
    
    public ListNode deleteDuplicates(ListNode listNode) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        return null;
    }

    public static void main(String[] args) {
        /*DeleteDuplicates d  = new DeleteDuplicates();
        ListNode x = new ListNode(4);
        x.next = new ListNode(5);
        x.next.next = new ListNode(7);
        x.next.next.next = new ListNode(3);
        x.next.next.next.next = new ListNode(3);
        ListNode listNode = d.deleteDuplicates(x);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }*/
        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }

}
