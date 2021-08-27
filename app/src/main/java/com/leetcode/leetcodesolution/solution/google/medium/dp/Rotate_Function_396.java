package com.leetcode.leetcodesolution.solution.google.medium.dp;

class Rotate_Function_396 {

    /**
     * 這題需要一點數學式的推導, 得出 F(1) 跟 F(0) 的關係, 才有辦法用 dp 去解
     * https://leetcode.com/problems/rotate-function/discuss/862726/Simple-Java-Code-with-Explanation-or-DP-or-O-(N)-runtime
     * 得出來的公式會是: F(1) = F(0) + SUM - N * LastItem's value
     *
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public int maxRotateFunction(int[] nums) {
        if (nums.length < 2) return 0;
        int sum = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[0] += i * nums[i];
        }
        // System.out.println("sum: " + sum + ", dp[0]: " + dp[0]);


        int n = nums.length;
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + sum - nums[n-i] * n;
            // System.out.println("dp[" + i + "]: " + dp[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
