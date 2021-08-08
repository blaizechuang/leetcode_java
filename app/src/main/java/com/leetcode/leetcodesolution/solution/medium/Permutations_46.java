package com.leetcode.leetcodesolution.solution.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {1,2,3};
        List<List<Integer>> list = permute(input);
        print("list: " + list);
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
     * 這個我面試可能還是會卡住, 因為跟遞迴有關
     * template: 原本的 array, global ArrayList, subList, used boolean array
     * 把上面的資料當作 input 丟到另一個 function
     * 然後去判斷 subList 決定 recursive 是不是該中斷, 把結果都塞到 global arrayList
     * 這邊另一個重點是 backtracking, 也就是檢查過的把 used[i] 設成 true,
     * 重新開始的話, 把 used[i] 設成 false
     *
     * 2021/08/07
     * 好像懂了 backtracking 的機制, 重點就是把檢查放到一個 function, 一開始先檢查條件是不是符合
     * 是的話就存起來, 記得要用 list copy
     * 然後就是一個一個找, 記得把現在的項目 flag 設成 true 再去 recursive call dfs
     * 然後把目前項目拿掉, flag 設成 false
     * time complexity: O(N x N!)
     * space complexity: O(N!)
     */
    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> finalResult = new ArrayList<>();
        permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
        return finalResult;
    }

    private void permuteRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {

        print("-- =================================");
        if (currResult.size() == nums.length) {
            print("-- Add " + currResult + " to finalResult");
            finalResult.add(new ArrayList<>(currResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            print("-- i: " + i);
            if (used[i]) {
                print("-- index " + i + " has been used, skip");
                continue;
            }
            currResult.add(nums[i]);
            print("-- add " + nums[i] + " to currResult");
            used[i] = true;
            permuteRecur(nums, finalResult, currResult, used);
            used[i] = false;
            print("-- remove " + currResult.get(currResult.size() - 1));
            currResult.remove(currResult.size() - 1);
        }
    }
}
