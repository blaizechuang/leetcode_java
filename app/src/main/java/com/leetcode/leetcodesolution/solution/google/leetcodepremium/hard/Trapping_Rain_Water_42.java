package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Trapping_Rain_Water_42 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(input);
        print("-- result: " + result);
    }

    /**
     * 思路: DP solution, 就是把頻繁運算的結果都存在一個 array 裏
     * TimeComplexity: O(n)
     */
    public int trap_dp(int[] height) {
        if (height == null || height.length < 1) return 0;
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for (int j = height.length-2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return res;

    }

    /**
     * 思路: 最直覺就是暴力法, 找到左右邊界, 跟目前的自己高度相減
     * TimeComplexity: O(n^2)
     */
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++){
            print("now i: " + i);
            int leftMax = 0, rightMax = 0;
            for (int k = i; k >= 0; k--){
                leftMax = Math.max(leftMax, height[k]);
            }
            print("-- leftMax: " + leftMax);
            for (int j = i; j < height.length; j++){
                rightMax = Math.max(rightMax, height[j]);
            }
            print("-- rightMax: " + rightMax);
            res += Math.min(leftMax, rightMax) - height[i];
            print("== res: " + res);
            print("height[" + i + "] = " + height[i] + ", res: " + res);
        }
        return res;
    }
}
