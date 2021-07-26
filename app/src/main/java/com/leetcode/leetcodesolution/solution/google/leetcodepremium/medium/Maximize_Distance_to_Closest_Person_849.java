package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

public class Maximize_Distance_to_Closest_Person_849 {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, max = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    max = i;
                } else {
                    max = Math.max(max, (i - prev)/2);
                }
                prev = i;
            }
        }
        max = Math.max(max, seats.length-1-prev);
        return max;
    }
}
