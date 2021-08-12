package com.leetcode.leetcodesolution.solution.easy;

import java.util.Stack;

public class Implement_Queue_using_Stacks_232 {
}

class MyQueue {
    Stack<Integer> rearStack;   // for push
    Stack<Integer> frontStack;   // for pop

    /** Initialize your data structure here. */
    public MyQueue() {
        rearStack = new Stack();
        frontStack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        rearStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return frontStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (frontStack.isEmpty()) {
            while (!rearStack.isEmpty()) {
                frontStack.push(rearStack.pop());
            }
        }
        return frontStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return rearStack.isEmpty() && frontStack.isEmpty();
    }
}

/**
 * 我想到的方式雖然很直覺, 但是 time complexity 都需要 O(N)
 */
//class MyQueue {
//    Stack<Integer> stack;
//    Stack<Integer> tmp;
//
//    /** Initialize your data structure here. */
//    public MyQueue() {
//        stack = new Stack();
//        tmp = new Stack();
//
//    }
//
//    /** Push element x to the back of queue. */
//    public void push(int x) {
//        stack.push(x);
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    public int pop() {
//        while(!stack.isEmpty()) {
//            tmp.push(stack.pop());
//        }
//        int last = tmp.pop();
//        while (!tmp.isEmpty()) {
//            stack.push(tmp.pop());
//        }
//        return last;
//    }
//
//    /** Get the front element. */
//    public int peek() {
//        while(!stack.isEmpty()) {
//            tmp.push(stack.pop());
//        }
//        int last = tmp.pop();
//        tmp.push(last);
//        while (!tmp.isEmpty()) {
//            stack.push(tmp.pop());
//        }
//        return last;
//    }
//
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        return stack.isEmpty();
//    }
//}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */