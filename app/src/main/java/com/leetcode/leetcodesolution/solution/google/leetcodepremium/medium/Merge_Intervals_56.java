package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge_Intervals_56 {
    /**
     * 這一題我參考 56. insert interval 的思路
     * 不過這一題沒有提到他是排序過的, 所以我先做一次排序
     *
     * Time complexity: O(NlongN)
     * Space complexity: O(N)
     *
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new LinkedList();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        while (i < intervals.length - 1) {
            if (intervals[i][1] >= intervals[i+1][0]) {
                intervals[i+1][0] = Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
            } else {
                result.add(intervals[i]);
            }
            i++;
        }

        if (i < intervals.length) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
