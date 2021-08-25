package com.leetcode.leetcodesolution.solution.google.medium.dp;

class Count_Sorted_Vowel_Strings_1641 {

    /**
     * 思路：遇到這種問題, 先是試著把 n = 1 ~ 3 的答案手寫出來會看到如下
     * 1 1 1 1  1
     * 1 2 3 4  5
     * 1 3 6 10 15
     *
     * 所以答案一定是在右下角, 因為每一個位置都要走一次
     * 另一個要注意的是在第一列的值都預設為 1
     * time complexity: O(N), N: n x 5
     * space complexity: O(1)
     */
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][6];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=5; j++) {
                dp[i][j] = dp[i][j-1] + ((i == 1) ? 1 : dp[i-1][j]);
            }
        }

        return dp[n][5];
    }
}
