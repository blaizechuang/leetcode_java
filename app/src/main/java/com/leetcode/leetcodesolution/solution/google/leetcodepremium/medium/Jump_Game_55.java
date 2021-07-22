package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

class Jump_Game_55 {
    /**
     *
     * Time complexity: O(n)
     * 還算簡單
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
