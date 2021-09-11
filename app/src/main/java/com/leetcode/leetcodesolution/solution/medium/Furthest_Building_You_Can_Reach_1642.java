package com.leetcode.leetcodesolution.solution.medium;

import java.util.PriorityQueue;

class Furthest_Building_You_Can_Reach_1642 {

    /**
     * time complexity: O(NLogL), L: 梯子的數量, PriorityQueue 最多只會有 L 個元素
     * space complexity: O(L), 就是 Priority queue 的 size
     * run time: 28 ms
     *
     * By HuaHua, 這題如果用 BFS/DFS 去做會超時, 因為 time complexity: O(2^n)
     * 花花有用到 binary search 的方法, 但是我看不懂
     * 至於時間/空間複雜度如下
     * time complexity: O(NlogN);
     * space complexity: O(N)
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int offset = heights[i+1] - heights[i];
            if (offset > 0) {
                // System.out.println("Add " + offset + " to q");
                q.offer(offset);
                if (q.size() > ladders) {
                    int min = q.poll();
                    // System.out.println("bricks: " + bricks + ", min: " + min);
                    bricks -= min;
                    if (bricks < 0) return i;
                }
            } else {
                continue;
            }
        }

        return heights.length - 1;
    }
}
