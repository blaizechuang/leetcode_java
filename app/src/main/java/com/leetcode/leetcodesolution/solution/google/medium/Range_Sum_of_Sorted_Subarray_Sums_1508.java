package com.leetcode.leetcodesolution.solution.google.medium;

import java.util.Arrays;

class Range_Sum_of_Sorted_Subarray_Sums_1508 {

    /**
     * brute force
     * time complexity: O(n^2 x logn)
     * 對 n^2 的元素作 sort => n^2logn^2 = 2n^2logn = n^2logn
     * space complexity: O(n^2)
     */
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] list = new int[n*(n+1)/2];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                list[index] = count;
                index++;
            }
        }
        Arrays.sort(list);
        int result = 0;
        int mod = 1000000007;
        for (int i = left - 1; i < right; i++) {
            result = (result + list[i]) % mod;
        }

        return result;
    }
}
