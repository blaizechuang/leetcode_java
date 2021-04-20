package com.leetcode.leetcodesolution.datastructure;

import java.util.Stack;

public class stack_to_implement_array {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 新增元素
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 獲取元素
     *
     * @return
     */
    public int pop() {
        while (!stack1.empty()) {
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        int res = stack2.pop();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }
}
