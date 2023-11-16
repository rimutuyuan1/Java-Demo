package com.forezp.thread.suanfa.二叉树的右视图;

import com.forezp.thread.suanfa.bean.TreeNode;
import com.forezp.thread.suanfa.bean.TreeNode1;
import com.forezp.thread.suanfa.遍历树所花费的时间.ForTreeSpendTime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-16  16:27
 **/
public class RightSideView {

    //层序遍历：取每一层的最后一个元素即可
    public List<Integer> rightSideView(TreeNode1 root) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        //使用队列存放数据
        Queue<TreeNode1> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size - 1; i >= 0; i-- ) {
                TreeNode1 poll = queue.poll();
                //每次遍历到最后一个元素后才将该元素放入res
                if (i == 0) {
                    res.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 7; i >= 0; i-- ) {
            System.out.println(i);
        }
    }
}
