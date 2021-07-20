package com.leetcode.leetcodesolution.solution.google.leetcodepremium;

import java.util.ArrayList;
import java.util.List;

public class Missing_Ranges_163 {
    /**
     * 這題的重點一是把字串化寫成一個 function,
     * 然後就是 < = > 這三個狀態的細心
     *
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList();

        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) {
                continue;
            }

            if (nums[i] == next) {
                next++;
                continue;
            }

            list.add(getRange(next, nums[i]-1));
            next = nums[i] + 1;
        }

        if (next <= upper) {
            list.add(getRange(next, upper));
        }
        return list;
    }

    private String getRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : String.format("%d->%d", start, end);
    }
}
