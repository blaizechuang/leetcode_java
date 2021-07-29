package com.leetcode.leetcodesolution.solution.google.medium;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        dfs(candidates, list, new ArrayList<Integer>(), target, 0);
        return list;
    }

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
     * 因為數字可以重複, 所以 time complexity 會更複雜, 這題主要是要多一個 remain 的暫存
     * target - num[i] => remain
     * 然後一直從 0 開始找
     */
    private void dfs(int[] candidates, List<List<Integer>> list, List<Integer> subList, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            list.add(new ArrayList(subList));
        }

        for (int i = start; i < candidates.length; i++) {
            subList.add(candidates[i]);
            dfs(candidates, list, subList, target - candidates[i], i);
            subList.remove(subList.size() - 1);
        }
    }
}
