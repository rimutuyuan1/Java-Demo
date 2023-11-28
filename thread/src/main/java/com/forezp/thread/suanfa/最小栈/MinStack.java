package com.forezp.thread.suanfa.最小栈;

import lombok.Getter;

import java.util.*;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-27  15:19
 **/
public class MinStack {

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     * **/
        private Stack<Integer> stack;
        private Stack<Integer> min_stack;
        public MinStack() {
            stack = new Stack<>();
            min_stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(min_stack.isEmpty() || x <= min_stack.peek())
                min_stack.push(x);
        }

        public void pop() {
            if(stack.pop().equals(min_stack.peek()))
                min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(4);
        /*System.out.println("------");
        PriorityQueue<Integer> queue = minStack.getMinQueue();
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        System.out.println("------");*/
        System.out.println(minStack.getMin());

        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
