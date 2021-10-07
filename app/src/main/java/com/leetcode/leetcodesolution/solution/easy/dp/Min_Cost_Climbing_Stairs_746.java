package com.leetcode.leetcodesolution.solution.easy.dp;

class Min_Cost_Climbing_Stairs_746 {

    /**
     * 這種題目就是先寫個 n = 3 看一下, 就會發現是 dp 問題
     * time complexity: O(N)
     * space complexity: O(N)
     * 優化的方式：可以把 space complexity 從 N -> 1, 也就是不用 array, 用兩個變數去處理
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length+1];
        result[0] = 0;
        result[1] = cost[0];
        return calc(result, cost);
    }

    private int calc(int[] result, int[] cost) {
        for (int i = 2; i < result.length; i++) {
            result[i] = Math.min(result[i-1], result[i-2]) + cost[i-1];
        }
        return Math.min(result[result.length-1], result[result.length-2]);
    }
}
