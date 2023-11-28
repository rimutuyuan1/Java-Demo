package com.forezp.thread.suanfa.对称二叉树;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-28  16:24
 **/
public class SymmetricTree {

    public static void main(String[] args) {
        // 构造一个对称二叉树示例
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetricTree(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetricTree(TreeNode root) {
        if (root == null) return false;

        //对称二叉树定义：(左节点的右孩子 == 右孩子的左节点 && 左节点的左孩子 == 右孩子的右节点) || (左节点 == null && 右节点 == null)
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        //如果left为空且right为空 ===> 平衡
        if (left == null && right == null) {
            return true;
        }
        //任意为空 或者 左右节点的值不相等 ===> 不平衡
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //递归：左节点的右孩子 是否等于 右孩子的左节点 && 左节点的左孩子 是否等于 右孩子的右节点
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
