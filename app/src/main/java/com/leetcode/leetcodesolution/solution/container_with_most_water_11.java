package com.leetcode.leetcodesolution.solution;

public class container_with_most_water_11 implements base_solution {

    @Override
    public void execute() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println("-- result: " + result);
    }

    public int maxArea(int[] height) {
        int size = height.length - 1;
        int area = -1;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right])*size);
            if (height[left] < height[right]) {
                left ++;
            } else {
                right--;
            }
            size--;
        }
        return area;
    }
}
