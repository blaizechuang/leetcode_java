package com.leetcode.leetcodesolution.solution.medium.sliding_windows;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters_3 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "dvdf";
        int result = lengthOfLongestSubstring(input);
        Log.d("", "result: " + result);
    }

    /**
     * runtime: 6ms, memory: 39.4 MB
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        HashMap<Character, Integer> map = new HashMap();
        int longestLen = Integer.MIN_VALUE;
        int start = 0, end = 0;
        while (end < s.length()) {
            if (map.get(s.charAt(end)) == null) {
                // new char
                map.put(s.charAt(end), 1);
                longestLen = Math.max(longestLen, end - start + 1);
                end++;
            } else {
                map.remove(s.charAt(start));
                start++;
            }
        }

        return longestLen;
    }
}
