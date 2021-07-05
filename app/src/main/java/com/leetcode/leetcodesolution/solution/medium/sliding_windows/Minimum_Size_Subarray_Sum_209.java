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
        int result = minSubArrayLen_refine(nums, input);
        Log.d("--", "result: " + result);
    }

    /**
     *
     * This refinement is O(n) but is slower than previous method in leetcode
     * Needs 108 ms, scared me O.O
     */
    public int minSubArrayLen_refine(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length){
            if (start == end) {
                sum += nums[start];
            } else {
                sum += nums[end];
            }
            if (sum >= target) {
                min = Math.min(min, end - start + 1);
                start++;
                end = start;
                sum = 0;
            } else {
                end++;
            }
        }
        return min;
    }


    /***
     *
     * 這個看起來雖然有兩個回圈, 但是 i 可能會一次跳過多個,
     * 所以整個時間比上一個 O(n) 來的快很多, 只需要 1 ms
     */
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
