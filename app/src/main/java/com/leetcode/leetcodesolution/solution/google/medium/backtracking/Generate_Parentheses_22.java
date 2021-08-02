package com.leetcode.leetcodesolution.solution.google.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

class Generate_Parentheses_22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        backTracking(list, new StringBuffer(), 0, 0, n);
        return list;
    }

    /**
     *
     * 這種題型要直覺想到 back tracking
     * time complexity & space complexity: O(2^(2^n)/sqrt(n));
     * 其實我看不懂這時間複雜度
     */
    private void backTracking(List<String> list, StringBuffer sb, int open, int close, int n) {
        if (sb.length() == n*2) {
            list.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backTracking(list, sb, open+1, close, n);
            sb.deleteCharAt(sb.length()-1);
            // 也可以這樣寫, 因為都是要把最後一個刪除
            //sb.setLength(sb.length()-1);
        }

        if (close < open) {
            sb.append(")");
            backTracking(list, sb, open, close+1, n);
            sb.deleteCharAt(sb.length()-1);
            // 也可以這樣寫, 因為都是要把最後一個刪除
            //sb.setLength(sb.length()-1);
        }
    }
}
