package com.leetcode.leetcodesolution.solution.medium.backtracking;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;
import java.util.logging.Logger;

public class Partition_to_K_Equal_Sum_Subsets_689 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        boolean result = canPartitionKSubsets(nums, k);
        print("-- result: " + result);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = sum(nums);
        if (sum % k != 0) {
            return false;
        }
        int subSum = sum / k;
        print("-- subSum: " + subSum);
        Arrays.sort(nums);
        int start = nums.length - 1;
        if (nums[start] > subSum) {
            return false;
        }
        printIntList("-- sort array: ", nums);
        while (start >= 0 && nums[start] == subSum) {
            start--;
            k--;
        }
        return partition(new int[k], nums, start, subSum);
    }

    public boolean partition(int[] subsets, int[] nums, int index, int subSum) {
        print("----------- partition, index: " + index + ", subSum: " + subSum);
        if (index < 0) {
            print("-- return true");
            return true;
        }
        int selected = nums[index];
        for (int i = 0; i < subsets.length; i++) {
            print("-- now selected: " + selected + ", subsets[" + i + "]: " + subsets[i]);
            if (subsets[i] + selected <= subSum) {
                subsets[i] += selected;
                print("-- ADD subsets[" + i + "]: " + subsets[i]);
                if (partition(subsets, nums, index - 1, subSum)) {
                    print("-- return true 2");
                    return true;
                }
                subsets[i] -= selected;
                print("-- Delete subsets[" + i + "]: " + subsets[i]);
            }
        }
        print("-- return false");
        return false;
    }

    public int sum(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res += n;
        }
        return res;
    }

    ///// leetcode 最佳解法
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        int sum = 0;
//
//        for (int num : nums) {
//            sum += num;
//        }
//
//        if (sum % k != 0) {
//            return false;
//        }
//
//        return dfs(nums, k, 0, sum / k, sum / k, new boolean[nums.length]);
//    }
//
//    private boolean dfs(int[] nums, int k, int start, int target, int sum, boolean[] visited) {
//        if (k == 1) {
//            return true;
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            if (!visited[i] && nums[i] <= target) {
//                visited[i] = true;
//
//                if (nums[i] == target) {
//                    if (dfs(nums, k - 1, 0, sum, sum, visited)) {
//                        return true;
//                    }
//                } else {
//                    if (dfs(nums, k, i + 1, target - nums[i], sum, visited)) {
//                        return true;
//                    }
//                }
//
//                visited[i] = false;
//            }
//        }
//
//        return false;
//    }

}
