package com.forezp.thread.suanfa.遍历树所花费的时间;

import java.util.List;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-14  17:53
 **/
public class ForTreeSpendTime {

    private static int a;
    private int b;

    public static class TreeNode {
        int propagationTime;
        TreeNode left;
        TreeNode right;

        // 构造函数
        public TreeNode(int propagationTime, TreeNode left, TreeNode right) {
            this.propagationTime = propagationTime;
            this.left = left;
            this.right = right;
        }
    }

    public static int computeTreeTime(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxTime   =  0;
        if (root.left != null) {
            int i = computeTreeTime(root.left);
            maxTime = Math.max(maxTime, i);
        }
        if (root.right != null) {
            int i = computeTreeTime(root.right);
            maxTime = Math.max(maxTime, i);
        }
        return maxTime + root.propagationTime;
    }
}
