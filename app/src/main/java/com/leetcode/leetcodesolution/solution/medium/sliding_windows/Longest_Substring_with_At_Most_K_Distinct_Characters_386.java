package com.leetcode.leetcodesolution.solution.medium.sliding_windows;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;

public class Longest_Substring_with_At_Most_K_Distinct_Characters_340 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "eceba";
        int k = 2;
        int result = maxDistString(input, k);
        Log.d("--", "result: " + result);
    }

    private int maxDistString(String input, int diff) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int start = 0, end = 0;
        while (end < input.length()) {
            if (map.size() < diff || map.containsKey(input.charAt(end))) {
                // new
                Log.d("", "Add " + input.charAt(end) + " to map");
                map.put(input.charAt(end), 1);
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            } else {
                Log.d("","" + input.charAt(start) + " existed, remove it");
                map.remove(input.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}
