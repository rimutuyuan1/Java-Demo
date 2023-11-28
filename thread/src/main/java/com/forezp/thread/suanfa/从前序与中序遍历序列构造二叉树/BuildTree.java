package com.forezp.thread.suanfa.从前序与中序遍历序列构造二叉树;

import com.forezp.thread.suanfa.bean.TreeNode;
import com.forezp.thread.suanfa.bean.TreeNode1;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-25  14:12
 **/
public class BuildTree {

    // 二叉树节点的定义
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class ConstructBinaryTree {
        public static void main(String[] args) {
            int[] preorder = {3, 9, 20, 15, 7};
            int[] inorder = {9, 3, 15, 20, 7};

            TreeNode root = buildTree(preorder, inorder);
            System.out.println("Binary tree constructed from preorder and inorder traversal:");
            inorderTraversal(root);
        }

        private static TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length != inorder.length) {
                return null;
            }

            // 使用一个辅助函数进行递归构建二叉树
            return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                                int[] inorder, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            int rootVal = preorder[preStart];  // 前序遍历序列的第一个节点为根节点的值
            TreeNode root = new TreeNode(rootVal);

            int rootIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    rootIndex = i;  // 在中序遍历序列中找到根节点的位置
                    break;
                }
            }

            int leftTreeSize = rootIndex - inStart;  // 左子树的节点个数
            // 递归构建左子树和右子树
            root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftTreeSize,
                    inorder, inStart, rootIndex - 1);
            root.right = buildTreeHelper(preorder, preStart + leftTreeSize + 1, preEnd,
                    inorder, rootIndex + 1, inEnd);

            return root;
        }

        private static void inorderTraversal(TreeNode root) {
            if (root == null) {
                return;
            }

            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
