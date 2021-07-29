package com.leetcode.leetcodesolution.solution.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_40 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {10,2,2,7,4,1,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(input, target);
        print("result: " + result);
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
     * 這題訣竅在於 sublist 的項目不可以重複, 但是如果 source 本來就有重複的話就可以
     * 所以先對 source 做一次的 sort, 這樣才可以在 for 回圈裡面去判斷現在跟前一個是不是相同
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(candidates);
        printIntList(candidates);
        dfs(candidates, list, new ArrayList(), target, 0);
        return list;
    }

    private void dfs(int[] nums, List<List<Integer>> list, List<Integer> subList, int target, int start) {
        if (target < 0) {
            return ;
        } else if (target == 0){
            list.add(new ArrayList(subList));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > 0) {
                print("i = " + i + ", start = " + start + ", nums[" + i + "] = " + nums[i] + ", nums[" + (i-1) + "]= " + nums[i-1]);
            }
            if (i > start && nums[i] == nums[i-1]) {
                print("continue");
                continue;
            }
            subList.add(nums[i]);
            dfs(nums, list, subList, target - nums[i], i+1);
            subList.remove(subList.size()-1);
        }
    }
}
