package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard.dp;

public class Best_Time_to_Buy_and_Sell_Stock_III_123 {

    /**
     * Leetcode 神人提供的解法
     * 思路：因為最多只能有兩次買賣, 所以有四個狀態, 買, 賣, 買, 賣
     * 買完錢變少, 所以第一個狀態會是負的, 賣完錢會變多, 所以是正的
     * 接下來買, 用上一次剩下的錢去減這一次, 再來賣就是用上一次剩下的錢去加
     *
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int buyState1 = -prices[0];
        int sellState1 = Integer.MIN_VALUE;
        int buyState2 = Integer.MIN_VALUE;
        int sellState2 = Integer.MIN_VALUE;

        for (int price : prices) {
            buyState1 = Math.max(buyState1, -price);
            sellState1 = Math.max(sellState1, price + buyState1);
            buyState2 = Math.max(buyState2, sellState1 - price);
            sellState2 = Math.max(sellState2, price + buyState2);
        }

        return sellState2;
    }
}
