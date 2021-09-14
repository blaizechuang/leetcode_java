package com.leetcode.leetcodesolution.solution.easy.design_pattern;

import java.util.LinkedList;
import java.util.Queue;

class Implement_Stack_using_Queues_225 {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public Implement_Stack_using_Queues_225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack.
     * push 的 time complexity: O(N), 其他 api 都是 O(1)
     * */
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
