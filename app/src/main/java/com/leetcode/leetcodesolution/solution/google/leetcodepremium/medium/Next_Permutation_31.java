package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Next_Permutation_31 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {1,5,1};
        nextPermutation(input);
        printIntList("result", input);
    }

    /**
     * runtime: 0 ms
     * 從右邊開始找, 找到第一個左邊 < 右邊的, 把該位置記為 left
     * 再一次從右邊開始找, 找到第一個 大於 left 值 (所以 while 裡面要寫 '<=' 找了好久)
     * 找到之後, swap(left, last)
     * 然後再對 left + 1 後面的陣列做一次 反轉 <-- 這個其實我還沒有很懂為什麼
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || (nums.length <= 1)) return;
        int last = nums.length-1;
        int left = nums.length-2;
        while(left >= 0 && nums[left] >= nums[left+1]) {
            left --;    // 找到第一個 左邊 < 右邊
        }
        print("-- left: " + left);

        if (left >= 0) {
            while (nums[last] <= nums[left]) {
                last--;
            }
            print("-- last: " + last);
            swap(nums, left, last);
        }
        printIntList("nums: ", nums);
        reverse(nums, left+1);
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private void reverse(int[] nums, int start) {
        print("-- do reverse");
        int end = nums.length-1;
        print("-- start: " + start + ", end: " + end);
        while (start < end) {
            swap(nums, start, end);
            end--;
            start++;
        }
    }
}
