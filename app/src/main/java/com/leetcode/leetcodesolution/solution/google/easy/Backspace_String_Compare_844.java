package com.leetcode.leetcodesolution.solution.google.easy;

import java.util.Stack;

class Backspace_String_Compare_844 {

    /**
     * 精簡後的版本, 把 build stack 拉出去
     * time complexity: O(S + T), S: length of s, T: length of t
     * space complexity: (S + T)
     *
     * follow up: 可以提升 space complexity？
     * Ans: space complexity 主要是因為用 stack, 所以不用 stack 可以提升到 O(1)
     * 做法可以參考 build_noStack
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

    private String build_noStack(String string) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = string.length()-1; i >= 0; i--) {
            char c = string.charAt(i);
            if (c == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
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
