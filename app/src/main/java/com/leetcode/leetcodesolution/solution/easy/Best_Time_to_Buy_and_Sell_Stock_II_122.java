package com.leetcode.leetcodesolution.solution.easy;

class Best_Time_to_Buy_and_Sell_Stock_II_122 {
    /**
     * 跟 I 的思路一樣
     * time complexity: O(n)
     * space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            if (prices[i] - minSoFar > 0 && prices[i] - minSoFar > 0) {
                max += (prices[i] - minSoFar);
                minSoFar = prices[i];
            }
        }

        return max;
    }
}
