package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy.dp;

class Maximum_Subarray_53 {

    /**
     * 我自己的方法
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public int maxSubArray_me(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] > 0 && nums[i] + nums[i-1] > 0) {
                nums[i] = nums[i] + nums[i-1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    /**
     *
     * time complexity: O(n)
     * space complexity: O(n), 正解可以縮到 O(1), 參考下面的改法
     * 思路：試著做一下累加, 如果前一個是負的, 就直接回傳現在這一個, 如果是正的, 就再加上現在這一個
     */
    public int maxSubArray(int[] nums) {
        // int[] result = new int[nums.length];
        // result[0] = nums[0];
        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // result[i] = (result[i-1] > 0) ? (nums[i] + result[i-1]) : nums[i];
            current = Math.max(nums[i], current + nums[i]);
            // max = Math.max(max, result[i]);
            max = Math.max(max, current);
        }

        return max;
    }
}
