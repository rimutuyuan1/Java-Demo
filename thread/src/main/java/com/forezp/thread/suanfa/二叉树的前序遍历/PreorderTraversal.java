package com.forezp.thread.suanfa.二叉树的前序遍历;

import com.forezp.thread.suanfa.bean.TreeNode;

import java.util.Stack;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-27  19:04
 **/
public class PreorderTraversal {

    /**
     * 递归
     */
    public void preorderTraversal1(TreeNode<Integer> root) {
        if (root == null) return;
        System.out.println(root.getVal());
        preorderTraversal1(root.getLeft());
        preorderTraversal1(root.getRight());
    }

    /**
     * 迭代
     */
    private static void preorderTraversal2(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode<Integer>> stack = new Stack<>();  // 用于存储节点的栈
        stack.push(root);  // 将根节点入栈

        while (!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();  // 弹出栈顶节点

            System.out.print(node.getVal() + " ");  // 访问当前节点的值

            // 先将右子节点入栈，再将左子节点入栈，保证左子节点会先被访问
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    public static void main(String[] args) {
        // 构造一个示例二叉树
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.setLeft(new TreeNode<Integer>(2));
        root.setRight(new TreeNode<Integer>(3));
        root.getLeft().setLeft(new TreeNode<Integer>(4));
        root.getLeft().setRight(new TreeNode<Integer>(5));
        PreorderTraversal p = new PreorderTraversal();
        p.preorderTraversal1(root);
    }


}
