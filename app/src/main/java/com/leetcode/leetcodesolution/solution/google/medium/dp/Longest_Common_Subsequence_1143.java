package com.leetcode.leetcodesolution.solution.google.medium.dp;

class Longest_Common_Subsequence_1143 {

    /**
     * 思路:看到這種從兩個組合找出一個最大解的通常都是 dp,
     * 這題類似 1458, 1092, 1062, 516, 1312, 718
     * time complexity: O(m + n)
     * space complexity: O(m + n)
     * https://leetcode.com/problems/longest-common-subsequence/discuss/351689/JavaPython-3-Two-DP-codes-of-O(mn)-and-O(min(m-n))-spaces-w-picture-and-analysis
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char char1 = text1.charAt(i);
                char char2 = text2.charAt(j);
                if (char1 == char2) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
