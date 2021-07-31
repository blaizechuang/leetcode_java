package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Valid_Anagram_242 extends logger implements base_solution {
    @Override
    public void execute() {
//        String s = "anagram", t = "nagaram";
        String s = "nl", t = "cx";
        boolean result = isAnagram(s, t);
        print("result: " + result);
    }

    /**
     *
     * run time: 3ms
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sChars = new int[26];
        int[] tChars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
        }

        for (int j = 0; j < t.length(); j++) {
            tChars[t.charAt(j) - 'a']++;
        }

        for (int k = 0; k < 26; k++) {
            if (sChars[k] != tChars[k]) return false;
        }
        return true;
    }
}
