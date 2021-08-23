package com.leetcode.leetcodesolution.solution.google.medium;

import java.util.HashSet;

class Valid_Square_593 {
    /**
     *
     * Leetcode 上面神人的解法, 很直觀, 也算暴力吧, 不過如果 type 是 double 的話就會有問題 (換成 HashSet<Double> 就好啦？)
     * time complexity: O(1)
     * space complexity: O(1)
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // if (isSame(p1, p2) || isSame(p1, p3) || isSame(p1, p4) || isSame(p2, p3) || isSame(p2, p4) || isSame(p3, p4)) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < p1.length; i++) {
            set.add(distance(p1, p2));
            set.add(distance(p1, p3));
            set.add(distance(p1, p4));
            set.add(distance(p2, p3));
            set.add(distance(p2, p4));
            set.add(distance(p3, p4));
        }

        return set.size() == 2 && !set.contains(0);
    }

    private int distance(int[] p, int[] q) {
        return (int)Math.pow((p[0] - q[0]), 2) + (int)Math.pow((p[1] - q[1]), 2);
    }

    private boolean isSame(int[] p, int[] q) {
        return (p[0] == q[0] && p[1] == q[1]);
    }
}
