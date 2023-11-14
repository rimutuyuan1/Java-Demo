package com.forezp.thread.suanfa.tree;

import com.forezp.thread.suanfa.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 王鑫涛
 * @Description 二叉树的层序遍历
 * @Date 2023-11-01  17:08
 **/
public class LevelOrderTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setRight(new TreeNode<>(2));
        root.setLeft(new TreeNode<>(3));
        root.getRight().setLeft(new TreeNode<>(6));
        root.getRight().setRight(new TreeNode<>(3));
        root.getLeft().setLeft(new TreeNode<>(9));
        root.getLeft().setRight(new TreeNode<>(11));
        LevelOrderTree l = new LevelOrderTree();
        System.out.println(l.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode<Integer> root) {
        //使用队列完成
        if (root == null) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();
        LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> pop = queue.pop();
                list.add(pop.getVal());

                if (pop.getLeft() != null) {
                    queue.offer(pop.getLeft());
                }
                if (pop.getRight() != null) {
                    queue.offer(pop.getRight());
                }
            }
            ret.add(list);
        }
        return ret;
    }
}
