package com.leetcode.leetcodesolution.solution.google;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Trapping_Rain_Water_42 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(input);
        Log.d("--", "result: " + result);
    }

    /**
     * 從左邊第二個開始找, 找出左邊的最高邊界
     * 再從右邊第二個開始找, 找出右邊的最高邊界
     * 再掃整個 array, 分別從左右的邊界拿出最小的, 扣掉自己的高度
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int size = height.length;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = height[0];
        for (int i = 1; i < size; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[size-1] = height[size-1];
        for (int i = size-2; i >=0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < size; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }

        return water;
    }
}
