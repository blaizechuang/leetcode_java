package com.leetcode.leetcodesolution.solution.medium.sliding_windows;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;
import java.util.Hashtable;

public class Minimum_Size_Subarray_Sum_209 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = new int[]{2,3,1,2,4,3};
        int nums = 7;
        int result = minSubArrayLen(nums, input);
        Log.d("--", "result: " + result);
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
