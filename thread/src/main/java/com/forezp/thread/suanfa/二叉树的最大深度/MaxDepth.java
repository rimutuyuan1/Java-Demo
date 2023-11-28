package com.forezp.thread.suanfa.二叉树的最大深度;

import com.forezp.thread.suanfa.bean.TreeNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-28  10:03
 **/
public class MaxDepth {

    public int maxDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return compute(root);
    }

    public int compute(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int left = compute(node.getLeft());
        int right = compute(node.getRight());

        return Math.max(left, right) + 1;
    }
}
