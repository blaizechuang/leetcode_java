package com.leetcode.leetcodesolution.solution.medium.tree;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Unique_Binary_Search_Trees_96 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /***
     * 先試著畫出前三個 n
     * 會得出 f(0) = 1
     * f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-2)*f(1) + f(n-1)*f(0)
     * 這樣的公式
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j< i; j++) {
                dp[i] += dp[j]*dp[i-j-1];   // 這個 - 1 是因為 i 從 1 開始
            }
        }

        return dp[n];
    }
}
