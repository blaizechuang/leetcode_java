package com.leetcode.leetcodesolution.solution.medium.sliding_windows;

public class Container_With_Most_Water_11 {

    /**
     * runtime: 3ms, memory: 52.7 MB
     */
    public int maxArea(int[] height) {
        if (height.length == 1) return 0;
        int start = 0, end = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (start < end) {
            max = Math.max(max, (end-start) * Math.min(height[start], height[end]));
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
