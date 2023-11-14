package com.forezp.thread.suanfa.bean;

import lombok.Data;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-23  14:18
 **/
@Data
public class LinkedNode<T> {
    T val;
    LinkedNode<T> next;
    LinkedNode() {}
    LinkedNode(T val) { this.val = val; }
    LinkedNode(T val, LinkedNode<T> next) {
        this.val = val;
        this.next = next;
    }
}
