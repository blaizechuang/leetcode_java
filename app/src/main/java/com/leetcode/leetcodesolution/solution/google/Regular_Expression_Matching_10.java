package com.leetcode.leetcodesolution.solution.google;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Regular_Expression_Matching_10 extends logger implements base_solution {
    @Override
    public void execute() {
        String a = "aab";
        String b = "c*a*b";
        boolean result = isMatch(a, b);
        Log.d("--", "result: " + result);

    }

    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; // Both are empty string
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i+1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
