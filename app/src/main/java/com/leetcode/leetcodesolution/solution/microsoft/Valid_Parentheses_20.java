package com.leetcode.leetcodesolution.solution.microsoft;

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
