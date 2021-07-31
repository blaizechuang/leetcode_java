package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Insert_Interval_57 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] input = {{1,3},{6,9}};
        int[] interval = {2, 5};
        int[][] result = insert(input, interval);
    }

    /**
     *
     * Time complexity: O(N)
     * Space complexity: O(N)
     * 這題不用想太複雜, 就切成三段
     * 1. subitem 的 end < newInterval 的 start, add to result
     * 2. subitem 的 start < newInterval 的 end, 就更新 newInterval 的 start, end
     * 3. 最後, 如果 i 還沒有走到最後, 就把 subitem 加到 result
     * 再來就是 List to int[][]
     * result.toArray(new int[result.size()][]);
     * 這個要記一下
     * 另外的重點, List<int> 是不合法的, 但是 List<int[]> 是可以的
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            print("Add " + intervals[i] + " to result");
            result.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // we could mutate newInterval here also
            print("compare " + newInterval[0] + " and " + intervals[i][0]);
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            print("Add " + newInterval[0] + " to newInterval[0]");
            print("compare " + newInterval[1] + " and " + intervals[i][1]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            print("Add " + newInterval[1] + " to newInterval[1]");
            i++;
        }

        // add the union of intervals we got
        result.add(newInterval);

        // add all the rest
        print("now i: " + i + ", interval length: " + intervals.length);
        while (i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        print("result: " + result);
        return result.toArray(new int[result.size()][]);
    }
}
