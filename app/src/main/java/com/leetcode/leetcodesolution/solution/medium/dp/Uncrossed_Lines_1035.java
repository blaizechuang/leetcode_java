package com.leetcode.leetcodesolution.solution.medium.dp;

public class Uncrossed_Lines_1035 {
    /**
     * Same with 72, 583
     * 不過 dp 的邏輯我還是不懂怎麼在一開始就想到
     * time/space complexity: O(l1xl2)
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[][] dp = new int [l1+1][l2+1];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[l1][l2];
    }
}
