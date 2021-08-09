package com.leetcode.leetcodesolution.solution.easy;

class Factorial_Trailing_Zeroes_172 {

    /**
     * 思路：只有 5 才有可能產生 0
     * time complexity: O(log5[下標]N);
     * space complexity: O(1)
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            n = n/5;
            result += n;
        }

        return result;
    }
}
