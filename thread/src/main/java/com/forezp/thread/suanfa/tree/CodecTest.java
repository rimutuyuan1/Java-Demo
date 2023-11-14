package com.forezp.thread.suanfa.tree;

import com.forezp.thread.suanfa.bean.TreeNode;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-09-23  15:06
 **/
public class CodecTest {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getRight().setLeft(new TreeNode<>(4));
        root.getRight().setRight(new TreeNode<>(5));
        String serialize = serialize(root);
        System.out.println(serialize);
        System.out.println(deserialize(serialize));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode<Integer> root) {
        StringBuilder sb = new StringBuilder();
        s(root, sb);
        return sb.toString();
    }

    /**
     * 最终会形成一个[1,#,2,#,3,4,#]类似的字符串
     */
    public static void s(TreeNode<Integer> node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
        } else {
            sb.append(node.getVal()).append(",");
            s(node.getLeft(), sb);
            s(node.getRight(), sb);
        }
    }

    private static int index;

    // Decodes your encoded data to tree.
    public static TreeNode<Integer> deserialize(String data) {
        String[] arr = data.split(",");

        //如果是一棵树结构，字符串的第一个char一定不是#，因为#代表空
        if (arr[0].equals("#")) {
            return null;
        }
        return d(arr);
    }

    public static TreeNode<Integer> d(String[] arr) {
        String str = arr[index++];
        if (str.equals("#")) {
            //说明树节点为空，返回null即可
            return null;
        } else {
            TreeNode<Integer> node = new TreeNode<>(Integer.parseInt(str));
            node.setLeft(d(arr));
            node.setRight(d(arr));
            return node;
        }
    }
}
