package com.leetcode.leetcodesolution.solution.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_300 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = lengthOfLIS_III(nums);
        print("result: " + result);
    }

    /**
     * 思路：DP 問題, 最差的情況就是只有 1, 所以可以先把 dp 的內容值預設為 1
     * 然後兩個回權去一個一個比較, 所以 time complexity: O(n^2);
     * 掃完之後, array 裡面最大的值即為答案
     * 因為用了一個 dp array, 所以 space complexity: O(n)
     * run time: 120 ms, 有點慢，看了一下高手們用了 binary search, 不過先試著把這個解法加快如 II
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if (max < dp[i]) {
                        max = dp[i];
                    }
                }
            }
        }

        return max;
    }

    /**
     * 主要就是不要每次都做判斷, 先把一輪的結果記起來, 然後再去更新 dp, 再去判斷 max 值需不需要更新
     * 這樣跑出來的 runtime: 53 ms, 進步一倍的時間
     */
    public int lengthOfLIS_II(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    len = Math.max(dp[j] + 1, len);
                }
            }

            dp[i] = len;

            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    /**
     * Binary search 的解法, 就是把每個元素透過 binary search 去找到他應該被放在哪個位置
     * 蠻厲害的思路, run time 只要 2 ms
     * time complexity: O(nlogn), n: for loop, logn: binary search
     * space complexity: O(n)
     */
    public int lengthOfLIS_III(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            print("-- find value: " + num);
            int index = Arrays.binarySearch(dp, 0, len, num);
            print("-- origin index: " + index);

            if (index < 0) {
//                index = -(index + 1);
                index = Math.abs(index) - 1;
            }

            dp[index] = num;
            print("-- dp[" + index + "] = " + num);
            if (index == len) {
                len++;
            }
        }

        return len;
    }
}
