package com.forezp.thread.suanfa.bean;

import lombok.Data;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-23  14:16
 **/
@Data
public class TreeNode<T> {

    T val;
    TreeNode<T> left;
    TreeNode<T> right;
    public TreeNode() {}
    public TreeNode(T val) { this.val = val; }
    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
