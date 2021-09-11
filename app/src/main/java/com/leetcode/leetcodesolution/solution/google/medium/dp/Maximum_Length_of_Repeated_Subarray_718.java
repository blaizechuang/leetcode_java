package com.leetcode.leetcodesolution.solution.google.medium.dp;

class Maximum_Length_of_Repeated_Subarray_718 {

    /**
     * 這題類似 1458, 1092, 1062, 516, 1312, 718
     * time/space complexity: O(m + n)
     * run time: 82 ms
     * https://leetcode.com/problems/longest-common-subsequence/discuss/351689/JavaPython-3-Two-DP-codes-of-O(mn)-and-O(min(m-n))-spaces-w-picture-and-analysis
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value1 = nums1[i];
                int value2 = nums2[j];
                if (value1 == value2) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i+1][j+1]);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
