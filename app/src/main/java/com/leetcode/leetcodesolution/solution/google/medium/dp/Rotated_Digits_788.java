package com.leetcode.leetcodesolution.solution.google.medium.dp;

class Rotated_Digits_788 {

    /**
     * 其實這一題我真的不懂是要幹嘛的, 重點應該就是三位數的情況, 不要用一個 while 去跑,
     * 譬如 123 就去找 12 跟 3 的 dp, 如果 12 是 [2,5,6,9] 其中一個, count 就 +1
     */
    public int rotatedDigits(int n) {
        int count = 0;
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                } else if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                }
            } else {
                int a = dp[i/10], b = dp[i%10];
                if (a == 1 && b == 1) {
                    dp[i] = 1;
                } else if (a >= 1 && b >= 1) {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}
