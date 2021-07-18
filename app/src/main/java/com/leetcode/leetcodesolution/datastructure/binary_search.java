package com.leetcode.leetcodesolution.datastructure;

class binary_search {

    /**
     *
     * while method
     */
    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }

    /**
     * Recursive
     */
    public int search_recur(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        return searchItem(nums, target, 0, nums.length-1);
    }

    private int searchItem(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int middle = start + (end-start)/2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return searchItem(nums, target, middle+1, end);
        } else {
            return searchItem(nums, target, start, middle-1);
        }
    }
}
