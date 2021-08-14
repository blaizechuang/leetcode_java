package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;

public class Coin_Change_322 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {1, 2, 5};
        int amount = 5;
        int result = coinChange(input, amount);
        print("result: " + result);
    }

    /**
     * 這篇很好懂：https://www.youtube.com/watch?v=KzkQMXpWSuA&ab_channel=happygirlzt
     * time complexity: O(s x n), s: amount's length, n: coins length
     * space complexity: O(s)
     * <p>
     * 思路：coins: [1,2,5], amount: 5, 把 5 扣掉 1, 2, 5 各為 4, 3, 0, 所以只要求得, 4, 3, 0, 的方法
     * 就可以算出 5, 所以就是前一個 + 1 就等於 5 的答案
     * 另一個重點是我們要求得 min, 所以要先把 array 初始化大一點的數字, 直覺會想到用 Integer.MAX_VALUE
     * 不過可以用 amount + 1 也是一招
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) continue;
                print("now i: " + i + ", dp[" + i + "]: " + dp[i] + ", dp[" + (i - coin) + "]: " + dp[i - coin]);
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                print("dp[" + i + "]: " + dp[i]);
            }
        }

        if (dp[amount] == amount + 1) return -1;
        return dp[amount];
    }
}
