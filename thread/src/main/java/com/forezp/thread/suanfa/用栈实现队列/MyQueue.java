package com.forezp.thread.suanfa.用栈实现队列;

import java.util.Stack;

/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-11-16  14:33
 **/
public class MyQueue {

    // 使用两个栈，一个输入，一个输出
    // push方法压入input，peek/pop方法先判断output有无值
    // 有值直接调用对应方法，无值先通过trans方法将input栈中的数据倒腾过来
    private final Stack<Integer> input;
    private final Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    //放入队列中
    public void push(int x) {
        input.push(x);
    }

    //从队列中取出第一个元素
    public int pop() {
        if (output.empty()) {
            trans();
        }
        return output.pop();
    }

    //查看队列第一个元素
    public int peek() {
        if (output.empty()) {
            trans();
        }
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

    public void trans() {
        while (!input.empty()) {
            output.push(input.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue m = new MyQueue();
        m.push(1);
        m.push(2);m.push(3);m.push(4);m.push(5);

        System.out.println(m.peek());

        while (!m.empty()) {
            System.out.println(m.pop());
        }

    }


}
