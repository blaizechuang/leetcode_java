package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium.dp;

public class Coin_Change_2_518 {

    /**
     * 與 #322 的不同處是反過來, 想著只有一元硬幣時, 可以有幾種方法, 有 1, 2 種硬幣時, 有幾種方法
     * https://www.youtube.com/watch?v=KzkQMXpWSuA&ab_channel=happygirlzt
     * 其實還是不那麼容易理解，直接在 doc 上面跑一次例子會比較有頭緒
     *
     * time complexity: O(N x amount), N: coins length
     * space complexity: O(amount)
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // if (i < coin) continue;
                dp[i] = dp[i-coin] + dp[i];
            }
        }

        return dp[amount];
    }
}
