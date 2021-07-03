package com.leetcode.leetcodesolution.solution.medium.sliding_windows;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Minimum_Size_Subarray_Sum_209 extends logger implements base_solution {
    @Override
    public void execute() {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                min = Math.min(j-i+1, min);
                sum -= nums[i++];
            }
        }

        return min != Integer.MAX_VALUE ? min : 0;
    }
}
