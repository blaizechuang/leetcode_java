package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Split_Array_Largest_Sum_410 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        int result = splitArray(nums, m);
        print("result: " + result);
    }

    /***
     * time complexity: O(n x log(sum of array -> sum)) => O(n)
     * 簡單說, 我們還是要跑一次 array, 所以很合理的是 O(n)
     * space complexity: O(1)
     */
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        // 如果 m = n, 表示有 n 個碎片, 所以最大的值就是找最大的那個
        // 如果 m = 1, 表示只有一個碎片, 所以最大的值就是加總
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // 找到最大跟最小值, 開始做 binary search
        int low = max;
        int high = sum;

        while (low < high) {
            int mid = low + (high-low)/2;
            // 找到中間值, 開始左右找
            // 思路：碎片越多, 值越小, 所以要往大的找, 所以要更新 low
            // 碎片越少, 值越大, 所以要往小的找, 更新 high
            int pieces = split(nums, mid);
            if (pieces > m) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int split(int[] nums, int largest) {
        int pieces = 1;
        int sum = 0;

        for (int num : nums) {
            if (sum + num > largest) {
                sum = num;
                pieces++;
            } else {
                sum += num;
            }
        }

        return pieces;
    }
}
