package com.leetcode.leetcodesolution.solution.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;

public class Meeting_Rooms_252 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] input = {{7,10},{2,4}};
        boolean result = canAttendMeetings(input);
        print("-- result: " + result);
    }

    /**
     * 思路：先做一次排序, 在 for loop 比全部, 因為有做 sorting, 所以 TimeComplexity: O(nlogn)
     * SpaceComplexity: O(1)
     */
    public boolean canAttendMeetings(int[][] intervals) {
        // Sort start time in ascending
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        boolean result = true;
        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                result = false;
            }
        }

        return result;
    }
}
