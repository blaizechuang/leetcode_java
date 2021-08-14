package com.leetcode.leetcodesolution.solution.google.medium.dp;

import java.util.HashMap;

class Number_of_Good_Ways_to_Split_a_String_1525 {

    /**
     * time complexity: O(N)
     * space complexity: O(N)
     *
     * runtime 11 ms, 用 array 解, runtime 就比 HashMap 快很多,
     */
    public int numSplits_array(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        int leftCount = 0;
        int rightCount = 0;

        int count = 0;
        for (char c : s.toCharArray()) {
            if (left[c - 'a'] == 0) {
                leftCount++;
            }
            left[c - 'a'] ++;
        }

        for (char c : s.toCharArray()) {
            left[c - 'a'] --;
            if (left[c - 'a'] == 0) {
                leftCount--;
            }

            if (right[c - 'a'] == 0) {
                rightCount++;
            }
            right[c - 'a'] ++;

            if (leftCount == rightCount) {
                count++;
            }
        }

        return count;
    }

    /**
     * time complexity: O(N)
     * space complexity: O(N)
     *
     * runtime 52 ms, 應該是 HashMap 的關係, 用 array 解看看
     */
    public int numSplits(String s) {
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();

        int count = 0;
        for (char c : s.toCharArray()) {
            left.put(c, left.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            left.put(c, left.get(c) - 1);
            if (left.get(c) == 0) {
                left.remove(c);
            }
            right.put(c, right.getOrDefault(c, 0) + 1);
            if (left.size() == right.size()) {
                count++;
            }
        }

        return count;
    }
}
