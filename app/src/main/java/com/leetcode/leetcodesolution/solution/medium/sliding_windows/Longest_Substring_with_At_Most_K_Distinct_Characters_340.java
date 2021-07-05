package com.leetcode.leetcodesolution.solution.medium.sliding_windows;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;

public class Longest_Substring_with_At_Most_K_Distinct_Characters_340 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "eceba";
        int k = 1;
        int result = maxDistString(input, k);
        Log.d("--", "result: " + result);
    }

    private int maxDistString(String input, int diff) {
        HashMap<Character, Integer> keep = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int currentLength = 0;
        int j;
        for (int i = 0; i < input.length(); i++) {
            j = i;
            while (keep.size() <= diff && j < input.length()) {
                if (keep.get(input.charAt(j)) == null) {
                    Log.d("", "" + input.charAt(j) + " not found, add to map");
                    keep.put(input.charAt(j), 1);
                }
                Log.d("", "map size: " + keep.size());
                if (keep.size() <= diff) {
                    currentLength++;
                }
                j++;
            }
            maxLength = Math.max(currentLength, maxLength);
            Log.d("", "maxLength: " + maxLength);
            currentLength = 0;
            keep.remove(input.charAt(i));
        }
        return maxLength;
    }
}
