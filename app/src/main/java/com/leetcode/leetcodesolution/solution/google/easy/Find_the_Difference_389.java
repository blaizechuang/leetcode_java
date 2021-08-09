package com.leetcode.leetcodesolution.solution.google.easy;

import java.util.HashMap;

class Find_the_Difference_389 {

    /**
     * 兩種的 time complexity: O(N);
     * space complexity: O(1)
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference_array(String s, String t) {
        int[] list = new int[26];
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            list[c - 'a']++;
        }

        char result = ' ';
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            list[c - 'a']--;
            if (list[c - 'a'] < 0) {
                result = c;
                break;
            }
        }
        return result;
    }

    public char findTheDifference_map(String s, String t) {
        if (s.length() == 0) return t.charAt(0);
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char result = ' ';
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (!map.containsKey(c)) {
                result = c;
                break;
            }

            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }

        return result;
    }
}
