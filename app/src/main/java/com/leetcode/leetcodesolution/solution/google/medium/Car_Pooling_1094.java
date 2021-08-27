package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Map;
import java.util.TreeMap;

public class Car_Pooling_1094 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] trips = {{2,1,5},{3,5,7}};
        int capacity = 3;
        boolean result = carPooling(trips, capacity);
        print("result: " + result);
    }

    /**
     * 思路：起點有人上車, 終點有人下車, 因為只有同一個方向, 所以直覺要想到排序, 由小到大排序有兩種方式
     * 一種是 TreeMap, 一種是 array
     * TreeMap 的方式
     * time complexity: O(NlogN)
     * space complexity: O(N)
     * run time: 67ms
     */
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int[] t : trips) {
            m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);    // 起點增加乘客人數
            m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);    // 終點減少乘客人數
        }
        print("map: " + m);
        for (int v : m.values()) {
            print("v: " + v);
            capacity -= v;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 下面這個是 Array 的方法, 因為題目有限定最多 1001 個, 所以是 constant, 如果沒有限定的話就是 O(N)
     * time complexity: O(1)
     * space complexity: O(1)
     * run time: 1ms
     */
//    public boolean carPooling(int[][] trips, int capacity) {
//        int[] slot = new int[1001];
//        for (int[] trip : trips) {
//            // System.out.println("[0]: " + trip[0] + ", [1]: " + trip[1] + ", [2]: " + trip[2]);
//            slot[trip[1]] += trip[0];
//            slot[trip[2]] -= trip[0];
//        }
//
//        for (int i = 0; capacity >= 0 && i < 1001; i++) {
//            // System.out.println("slot[" + i + "]: " + slot[i]);
//            capacity -= slot[i];
//        }
//
//        return capacity > 0;
//    }
}
