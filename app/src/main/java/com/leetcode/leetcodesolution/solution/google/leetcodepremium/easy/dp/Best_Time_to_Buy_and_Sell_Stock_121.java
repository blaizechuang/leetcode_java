package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Best_Time_to_Buy_and_Sell_Stock_121 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     * 思路：一個一個去找, 把最小的值記下來, 然後每一個 prices 去 - 最小的值
     * 再去判斷是不是比現在的 max 還要大, 是的話就更新
     *
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            if (prices[i] - minSoFar > max) {
                max = prices[i] - minSoFar;
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    /**
     * brute force, 超時
     */
    public int maxProfit_bruteForce(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] < prices[i]) continue;
                max = Math.max(max, (prices[j] - prices[i]));
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
