package com.leetcode.leetcodesolution.solution.medium.dp;

public class Delete_Operation_for_Two_Strings_583 {

    /**
     * 這題跟 72 一樣, 少了 replace 的條件
     * time complexity: O(l1xl2)
     * space complexity: O(l1xl2)
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];

        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j]) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
