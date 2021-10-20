package com.leetcode.leetcodesolution.solution.hard.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Edit_Distance_72 extends logger implements base_solution {

    /**
     * 思路：DP 問題, 不過怎麼在一開始去拆分三個位置的最小值, 這個思路我還不知道, 不過看完解答後感覺可以理解
     * time complexity: O(mxn)
     * space complexity: O(mxn)
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i][j])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    @Override
    public void execute() {
        String word1 = "horse", word2 = "ros";
        int result = minDistance(word1, word2);
        print("-- result: " + result);
    }
}
