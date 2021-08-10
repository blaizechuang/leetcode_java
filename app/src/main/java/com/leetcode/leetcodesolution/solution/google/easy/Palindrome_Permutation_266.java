package com.leetcode.leetcodesolution.solution.google.easy;

import java.util.HashMap;

class Palindrome_Permutation_266 {

    /**
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        int oddNum = 0;
        for (char c : dict.keySet()) {
            if (dict.get(c) % 2 != 0) {
                oddNum++;
            }
        }

        return oddNum <= 1;
    }
}
