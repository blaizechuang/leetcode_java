package com.leetcode.leetcodesolution.solution.easy;

import java.util.Stack;

public class Implement_Queue_using_Stacks_232 {
}

class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> tmp;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
        tmp = new Stack();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int last = tmp.pop();
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return last;
    }

    /** Get the front element. */
    public int peek() {
        while(!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        int last = tmp.pop();
        tmp.push(last);
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        return last;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */