package com.forezp.thread.suanfa.tree;

import com.forezp.thread.suanfa.bean.TreeNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-23  14:18
 **/
public class TreeDepthTest {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setRight(new TreeNode<>(2));
        root.getRight().setRight(new TreeNode<>(3));
        root.getRight().getRight().setRight(new TreeNode<>(4));
        root.getRight().getRight().getRight().setRight(new TreeNode<>(5));
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.getLeft() != null) {
            leftDepth = minDepth(root.getLeft());
        }
        if (root.getRight() != null) {
            rightDepth = minDepth(root.getRight());
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }
}
