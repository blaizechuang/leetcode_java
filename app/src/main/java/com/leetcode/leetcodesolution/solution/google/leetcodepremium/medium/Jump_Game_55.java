package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

class Jump_Game_55 {
    /**
     *
     * Time complexity: O(n)
     * space complexity: O(1)
     * 一開始看沒啥頭緒, 本來想說用 backtracking, 不過好像蠻麻煩的, 而且 back tracking 的 time complexity: O(N^2)
     * 看了一下 leetcode solution Greedy 解法，直接從例子跑一輪覺得蠻直覺的
     *
     */
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        int index = nums.length-2;
        for (int i = index; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }

        return last == 0;
    }
}
