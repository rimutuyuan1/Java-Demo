package com.forezp.thread.order;

import lombok.Data;

import java.util.Stack;

/**
 * @Author 王鑫涛
 * @Description 遍历二叉树
 * @Date 2020/6/3 6:57 下午
 **/
public class Order {

    //先序遍历（递归）
    private static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //先序遍历（非递归）
    private static void preOrderNotRecursive(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    //中序遍历（递归）
    private static void minOrder(Node root) {
        if (root == null) return;
        minOrder(root.left);
        System.out.print(root.val + " ");
        minOrder(root.right);
    }

    //先序遍历（非递归）
    private static void minOrderNotRecursive(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.right != null) stack.push(node.right);
            System.out.print(node.val + " ");
            if (node.left != null) stack.push(node.left);
        }
    }

    //后序遍历（递归）
    private static void afterOrder(Node root) {
        if (root == null) return;
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val + " ");
    }

    //先序遍历（非递归）
    private static void afterOrderNotRecursive(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            System.out.print(node.val + " ");
        }
    }

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeE.left = nodeG;
        nodeC.right = nodeF;

        preOrder(nodeA);
        System.out.println();

        minOrder(nodeA);
        System.out.println();

        afterOrder(nodeA);
        System.out.println();

        preOrderNotRecursive(nodeA);
        System.out.println();

        minOrderNotRecursive(nodeA);
        System.out.println();

        afterOrderNotRecursive(nodeA);
    }

    @Data
    static class Node {
        private Object val;
        private Node left;
        private Node right;

        public Node(Object val) {
            this.val = val;
        }

    }
}
