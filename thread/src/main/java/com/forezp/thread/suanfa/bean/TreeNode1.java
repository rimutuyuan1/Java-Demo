package com.forezp.thread.suanfa.bean;

import lombok.Data;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-23  14:16
 **/
public class TreeNode1 {

    public int val;
    public TreeNode1 left;
    public TreeNode1 right;

    public TreeNode1() {}
    public TreeNode1(int val) { this.val = val; }
    public TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
