package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Maximum_Product_Subarray_152 extends logger implements base_solution {
    @Override
    public void execute() {
//        int[] nums = {-2,3,-4};
        int[] nums = {3, -1, 4};
        int result = maxProduct(nums);
        print("result: " + result);
    }

    /**
     * 2021/08/14, 這時候看覺得其實也沒那麼複雜
     *
     * 另一種思路, 前面 x 後面, 取最大最小值, 繼續往後乘
     * 這個是 leetcode 的解法, 我覺得沒有前一個直覺
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], tmpMax;
        int min = nums[0], tmpMin;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmpMax = max*nums[i];
            tmpMin = min*nums[i];
            max = Math.max(Math.max(tmpMax, tmpMin), nums[i]);
            min = Math.min(Math.min(tmpMax, tmpMin), nums[i]);
            if (max > result) {
                result = max;
            }
        }

        return result;
    }

    /**
     *
     * 雖然這題很多人用 dp 去解, 但我覺得這方法最簡單又直覺
     * 而且 time complexity: O(N), space complexity: O(1)
     */
    public int maxProduct_1(int[] nums) {
        int val = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            val *= nums[i];
            result = Math.max(result, val);
            if (val == 0) {
                val = 1;
            }
        }

        val = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            val *= nums[i];
            result = Math.max(result, val);
            if (val == 0) {
                val = 1;
            }
        }

        return result;
    }
}
