package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 extends logger implements base_solution {
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
     * Time complexity: O(n x n^2), 2^n 是因為有 n 個數字, 每個數字可 include/exclude
     * 至於前面的 n 是因為我們需要做 copy, 每個都要 copy 一次, 總共有 n 個
     *
     * Space complexity: O(n), 主要是 subList
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        dfs(nums, list, new ArrayList(), 0);
        return list;
    }

    private void dfs(int[] nums, List<List<Integer>> list, List<Integer> subList, int start) {
        list.add(new ArrayList(subList));
        for (int i = start; i < nums.length; i++) {
            subList.add(nums[i]);
            dfs(nums, list, subList, i+1);
            subList.remove(subList.size()-1);
        }
    }

    @Override
    public void execute() {
        int[] input = {1,2,2};
        List<List<Integer>> result = subsets(input);
        print("result: " + result);
    }
}
