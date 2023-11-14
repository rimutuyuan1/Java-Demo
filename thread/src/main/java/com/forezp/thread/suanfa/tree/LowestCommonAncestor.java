package com.forezp.thread.suanfa.tree;

import com.forezp.thread.suanfa.bean.TreeNode;

/**
 * @Author 王鑫涛
 * @Description 二叉树的公共祖先
 * @Date 2023-11-03  14:33
 **/
public class LowestCommonAncestor {

    //回溯，使用后序遍历的方式（左右根），自下往上遍历并寻找返回
    //https://www.programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#%E6%80%9D%E8%B7%AF
    public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        //终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode<Integer> left = lowestCommonAncestor(root.getLeft(), p, q);
        TreeNode<Integer> right = lowestCommonAncestor(root.getRight(), p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
