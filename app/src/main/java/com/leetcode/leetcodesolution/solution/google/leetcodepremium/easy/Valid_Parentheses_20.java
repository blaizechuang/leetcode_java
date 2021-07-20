package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Stack;

public class Valid_Parentheses_20 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "()";
        boolean isValid = isValid(input);
        Log.d("--", "isValid: " + isValid );
    }

    /**
     * runtime: 1 ms, 思路, 因為只需要處理 (){}[], 所以不管什麼就是 push 進去, 然後只有在看到 )]} 時
     * 去判斷 stack 裡面的 top 是不是他們的對應字元, 是的話就 pop
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++)
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else
            if (s.charAt(i) == ')' && stack.peek() == '(' ||
                    s.charAt(i) == '}' && stack.peek() == '{' ||
                    s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }

        return stack.empty();
    }
}
