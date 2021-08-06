package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

public class Isomorphic_Strings_205 {

    /**
     * 這題我覺得至少 Medium
     * 思路很直覺就是要去做一個字典, 只是要怎麼去檢查
     * 從字串第一個往後找, 然後把目前的 index + 1 放到 char[] 裡, 我覺淂這個蠻 tricky 的
     * 不可以直接 assign i, 因為 i 的初始值是 0, 這樣會造成第二個字元的誤判
     *
     * time complexity: O(n)
     * space complexity: o(1)
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0 && t.length() == 0) return true;
        int[] sChars = new int[256];
        int[] tChars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sChars[s.charAt(i)] != tChars[t.charAt(i)]) return false;
            sChars[s.charAt(i)] = i+1;
            tChars[t.charAt(i)] = i+1;
        }

        return true;
    }
}
