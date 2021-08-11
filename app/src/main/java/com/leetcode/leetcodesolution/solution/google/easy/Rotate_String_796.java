package com.leetcode.leetcodesolution.solution.google.easy;

class Rotate_String_796 {

    /**
     * time complexity: O(N^2) => O(n x M), n: length of s, M: length of goal
     * space complexity: O(N) => A + A
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s+s).contains(goal);
    }
}
