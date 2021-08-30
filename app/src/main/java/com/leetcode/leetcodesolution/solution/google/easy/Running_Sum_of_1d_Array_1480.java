package com.leetcode.leetcodesolution.solution.google.easy;

class Running_Sum_of_1d_Array_1480 {

    /**
     * Trivial 秒解
     * time complexity: O(N);
     * space complexity: O(1)
     */
    public int[] runningSum(int[] nums) {
        if (nums.length == 1) return nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
