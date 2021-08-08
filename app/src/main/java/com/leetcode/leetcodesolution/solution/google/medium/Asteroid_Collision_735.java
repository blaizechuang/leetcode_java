package com.leetcode.leetcodesolution.solution.google.medium;

import java.util.Stack;

class Asteroid_Collision_735 {

    /**
     * time complexity: O(n);
     * space complexity: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return new int[]{};
        Stack<Integer> stack = new Stack();
        for (int value : asteroids) {
            if (value > 0) {
                stack.push(value);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(value)) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(value);
                } else if (stack.peek() + value == 0) {
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];
        int end = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[end] = stack.pop();
            end--;
        }
        return result;
        /** 比較簡潔的寫法
         * int[] res = new int[s.size()];
         *         for(int i = res.length - 1; i >= 0; i--){
         *             res[i] = s.pop();
         *         }
         *         return res;
         */
    }
}
