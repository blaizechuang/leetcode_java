package com.leetcode.leetcodesolution.solution.google.medium;

import java.util.ArrayList;
import java.util.List;

class Combination_Sum_III_216 {

    /**
     * Similar question:
     * Subsets
     * Subsets II
     * Permutations
     * Permutations II
     * Combinations
     * Combination Sum II
     * Combination Sum III
     * Palindrome Partition
     *
     * 這題的重點就是題目要看清楚, 只會有 1-9 的數字
     * 然後不會重複
     * 所以我的做法是先把 1-9 的 int array 先做出來, 然後用 combination 的解法去解
     * 然後一個重要的條件是 subList.size() == maxCount
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList();
        if (k >= n || n < 6) return list;
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = i+1;
        }
        boolean[] used = new boolean[nums.length];
        dfs(nums, list, new ArrayList<Integer>(), used, n, k, 0);
        return list;
    }

    private void dfs(int[] nums, List<List<Integer>> list, List<Integer> subList, boolean[] used, int target, int maxCount, int start) {
        if (target < 0) return;
        if (subList.size() == maxCount && target == 0) {
            list.add(new ArrayList(subList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subList.add(nums[i]);
            dfs(nums, list, subList, used, target - nums[i], maxCount, i+1);
            subList.remove(subList.size()-1);
        }
    }
}
