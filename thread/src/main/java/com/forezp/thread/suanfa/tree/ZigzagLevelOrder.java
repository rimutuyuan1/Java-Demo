package com.forezp.thread.suanfa.tree;

import com.forezp.thread.suanfa.bean.TreeNode;

import java.util.*;

/**
 * @Author 王鑫涛
 * @Description 二叉树的层序遍历
 * @Date 2023-11-02  22:04
 **/
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        ZigzagLevelOrder z = new ZigzagLevelOrder();
        TreeNode<Integer> root = new TreeNode<>(3);
        root.setRight(new TreeNode<>(20));
        root.setLeft(new TreeNode<>(9));
        root.getRight().setLeft(new TreeNode<>(15));
        root.getRight().setRight(new TreeNode<>(7));

        System.out.println(z.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //题目要求先从左到右，下一层再从右到左遍历
        //维护一个层级，简单理解就是单数层正常输出，双数层逆序输出
        //所以level % 2 = 0时，将当前subRes中的元素反转即可
        //level从1开始，方便理解，因为第一层就是单数层
        int level = 1;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subRes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                if (node != null) {
                    subRes.add(node.getVal());
                    if (node.getLeft() != null) {
                        queue.offer(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        queue.offer(node.getRight());
                    }
                }
            }
            //维护一个栈，如果是偶数层，需要反转后再放入res
            if (level % 2  == 0) {
                Stack<Integer> stack = new Stack<>();
                for (Integer subRe : subRes) {
                    stack.push(subRe);
                }
                subRes.clear();
                while (!stack.isEmpty()) {
                    subRes.add(stack.pop());
                }
            }
            res.add(subRes);
            level++;
        }
        return res;
    }
}
