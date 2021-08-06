package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

class Range_Sum_Query_Mutable_307 {
}

class NumArray {

    int[] source;
    public NumArray(int[] nums) {
        source = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            source[i] = nums[i];
        }
    }

    public void update(int index, int val) {
        source[index] = val;
    }

    public int sumRange(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            count += source[i];
        }
        return count;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */