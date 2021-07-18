package com.leetcode.leetcodesolution.solution.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Search_in_Rotated_Sorted_Array_33 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {7,8,1,2,3,4,5,6};
        int target = 2;
        int result = search(input, target);
        print("-- result: " + result);
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int middle = start + (end-start)/2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[start] <= nums[middle]) {
                if (nums[start] <= target && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }

            if (nums[middle] <= nums[end]) {
                if (nums[middle] < target && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }
}
