package com.forezp.thread.suanfa;

import com.forezp.thread.suanfa.bean.LinkedNode;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-22  16:08
 **/
public class MergeKListNode {

    public static LinkedNode<Integer> mergeKLinkedNode(List<LinkedNode<Integer>> linkedNodeList) {
        if (CollectionUtils.isEmpty(linkedNodeList)) {
            return null;
        }
        PriorityQueue<LinkedNode<Integer>> heap = new PriorityQueue<>(linkedNodeList.size(), Comparator.comparingInt(LinkedNode::getVal));
        for (LinkedNode<Integer> node : linkedNodeList) {
            if (node.getVal() != null) {
                heap.add(node);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }

        LinkedNode<Integer> head = heap.poll();
        LinkedNode<Integer> cur = head;
        if (head.getNext() != null) {
            heap.add(head.getNext());
        }

        while (!heap.isEmpty()) {
            LinkedNode<Integer> node = heap.poll();
            cur.setNext(node);
            cur = node;
            if (node.getNext() != null) {
                heap.add(node.getNext());
            }
        }
        return  head;
    }

    public static void main(String[] args) {

    }
}
