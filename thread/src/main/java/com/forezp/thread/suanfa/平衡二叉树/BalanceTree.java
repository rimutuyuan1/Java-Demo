package com.forezp.thread.suanfa.平衡二叉树;

import com.forezp.thread.suanfa.bean.TreeNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-28  11:37
 **/
public class BalanceTree {

    public static void main(String[] args) {
        // 构造一个平衡二叉树示例
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.setLeft(new TreeNode<Integer>(2));
        root.setRight(new TreeNode<Integer>(3));
        root.getLeft().setLeft(new TreeNode<Integer>(4));
        root.getLeft().setRight(new TreeNode<Integer>(5));
        root.getLeft().getRight().setRight(new TreeNode<Integer>(6));
        BalanceTree b = new BalanceTree();
        System.out.println(b.isBalanceTree(root));
    }

    public boolean isBalanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return height(root) != -1;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.getLeft());
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = height(node.getRight());
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
