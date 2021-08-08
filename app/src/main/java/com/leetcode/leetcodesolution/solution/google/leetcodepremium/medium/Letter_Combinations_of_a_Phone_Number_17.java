package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import java.util.ArrayList;
import java.util.List;

class Letter_Combinations_of_a_Phone_Number_17 {
    String[] keyboard = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * time complexity: O(4^N x N), 按鍵最多有 4 個字母, digits 的長度為 N, 所以 4 ^ N, 要找 N 次
     * Space complexity: O(N), 如果用 HashMap 去存鍵盤, 只需要 O(1), 不過我覺得長度是固定的所以
     * 即使用 array, space complexity 應該也是 O(1)
     *
     * 思路
     * 1.	Dfs() 的一開始要去判斷條件是不是符合, 是的話就把 sb 加到 result 裏面
     * 2.	然後就是 forloop 去查找，把找到的第一個值加到 sb, 然後 recursive dfs, 再把 sb 的最後一個值拿掉 sb.deleteCharAt(sb.length()-1)
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();
        if (digits.length() == 0) return result;
        StringBuffer sb = new StringBuffer();
        dfs(digits, sb, 0, result);
        return result;
    }

    private void dfs(String digits, StringBuffer sb, int length, List<String> result) {
        if (length == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String letter = keyboard[digits.charAt(length)  - '0'];
        for (int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            sb.append(c);
            dfs(digits, sb, length+1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
