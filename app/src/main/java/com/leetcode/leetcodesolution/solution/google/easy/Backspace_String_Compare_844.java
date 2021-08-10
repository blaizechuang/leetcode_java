package com.leetcode.leetcodesolution.solution.google.easy;

import java.util.Stack;

class Backspace_String_Compare_844 {

    /**
     * 精簡後的版本, 把 build stack 拉出去
     * time complexity: O(S + T), S: length of s, T: length of t
     * space complexity: (S + T)
     */
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return String.valueOf(stack);
    }

    /**
     * 我一開始的版本
     */
    public boolean backspaceCompare_init(String s, String t) {
        Stack<Character> stackS = new Stack();
        Stack<Character> stackT = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stackS.push(s.charAt(i));
            } else {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            }
        }

        for (int j = 0; j < t.length(); j++) {
            if (t.charAt(j) != '#') {
                stackT.push(t.charAt(j));
            } else {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            }
        }
        return String.valueOf(stackS).equals(String.valueOf(stackT));
//         if (stackS.size() != stackT.size()) return false;
//         while (!stackS.isEmpty() && !stackT.isEmpty()) {
//             char charS = stackS.pop();
//             char charT = stackT.pop();
//             if (charS != charT) return false;
//         }

//         return stackS.size() == 0 && stackT.size() == 0;
    }
}
