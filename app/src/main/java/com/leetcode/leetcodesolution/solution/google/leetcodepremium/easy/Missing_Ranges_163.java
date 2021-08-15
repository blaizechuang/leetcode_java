package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.List;

public class Missing_Ranges_163 extends logger implements base_solution {
    /**
     * 這題的重點一是把字串化寫成一個 function,
     * 然後就是 < = > 這三個狀態的細心
     *
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList();

        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            print("" + nums[i] + " < " + next);
            if (nums[i] < next) {
                continue;
            }

            if (nums[i] == next) {
                next++;
                print("-- next++: " + next);
                continue;
            }

            print("-- add next: " + next + " nums[i]-1: " + (nums[i]-1) + " => " + getRange(next, nums[i]-1));
            list.add(getRange(next, nums[i]-1));
            next = nums[i] + 1;
        }

        print("-- next: " + next + ", upper: " + upper);
        if (next <= upper) {
            print("-- add " + getRange(next, upper));
            list.add(getRange(next, upper));
        }
        return list;
    }

    private String getRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : String.format("%d->%d", start, end);
    }

    @Override
    public void execute() {
        int[] nums = {0,1,3,50,75};
        int lower = 0, upper = 99;
        List<String> list = findMissingRanges(nums, lower, upper);
        print("list: " + list);
    }
}
