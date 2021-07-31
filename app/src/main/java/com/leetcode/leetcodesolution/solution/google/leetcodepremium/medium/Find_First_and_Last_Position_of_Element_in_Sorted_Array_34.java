package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

class Find_First_and_Last_Position_of_Element_in_Sorted_Array_34 {

    /**
     * 做兩次的 binary search, 主要就是在找到 middle 的時候, 再繼續往下找
     * time complexity: O(logN);
     * Space complexity: O(1);
     */
    public int[] searchRange_blaize(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = bs(nums, 0, nums.length - 1,target, true);
        if (start == -1) {
            return new int[] {-1, -1};
        }
        int end = bs(nums, 0, nums.length - 1, target, false);
        return new int[] {start, end};
    }

    private int bs(int[] nums, int start, int end, int target, boolean findFirst) {
        if (start > end) return -1;
        int middle = start + (end-start)/2;
        if (nums[middle] == target) {
            if (findFirst) {
                if (middle == 0 || nums[middle] != nums[middle-1]) {
                    return middle;
                } else {
                    end = middle-1;
                }
            } else {
                if (middle == nums.length-1 || nums[middle] != nums[middle+1]) {
                    return middle;
                } else {
                    start = middle+1;
                }
            }
            return bs(nums, start, end, target, findFirst);
        } else if (nums[middle] < target) {
            return bs(nums, middle+1, end, target, findFirst);
        } else {
            return bs(nums, start, middle-1, target, findFirst);
        }
    }

    /**
     * 直覺的解法
     * time complexity: O(n)
     * Space complexity: O(1)
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }

        if (end == -1 && start != -1) {
            end = start;
        }

        return new int[]{start, end};
    }
}
