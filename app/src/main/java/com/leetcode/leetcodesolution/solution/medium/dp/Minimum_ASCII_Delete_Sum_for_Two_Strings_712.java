package com.leetcode.leetcodesolution.solution.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Minimum_ASCII_Delete_Sum_for_Two_Strings_712 extends logger implements base_solution {
    @Override
    public void execute() {
        String s1 = "sea", s2 = "eat";
        int result = minimumDeleteSum(s1, s2);
        print("-- result: " + result);
    }

    /**
     * 這題是 #72, #583, #1035 的變形, 原理一樣, 只是要把 dp 的內容值換成 ASCII value
     * time/space complexity: O(l1xl2)
     */
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1+1][l2+1];

        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i-1);
        }

        for (int j = 1; j <= l2; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1] + s1.charAt(i), dp[i+1][j] + s2.charAt(j));
                }
            }
        }

        return dp[l1][l2];
    }
}
