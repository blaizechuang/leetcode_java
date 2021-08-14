package com.leetcode.leetcodesolution.solution.google.easy.dp;

class Climbing_Stairs_70 {

    /**
     * fabonacci with memory
     * time complexity: O(N);
     * space complexity: O(1);
     */
    public int climbStairs_fabonacci(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * dp method
     * time complexity: O(N)
     * space complexity: O(N)
     */
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return getStep(n);

    }

    private int getStep(int n) {
        if (dp[n] != 0) return dp[n];
        dp[n] = getStep(n-1) + getStep(n-2);
        return dp[n];
    }
}
