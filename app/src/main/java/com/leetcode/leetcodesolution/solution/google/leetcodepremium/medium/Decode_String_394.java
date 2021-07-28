package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Stack;

public class Decode_String_394 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "abc3[cd]xyz";
        String result = decodeString(input);
        print("result: " + result);
    }

    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack();
        Stack<String> stringStack = new Stack();
        int start = 0;
        stringStack.push("");
        while (start < s.length()) {
            char c = s.charAt(start);
            if (c >= '0' && c <= '9') {
                int end = start;
                while (end < s.length()) {
                    if (s.charAt(end) < '0' || s.charAt(end) > '9') {
                        break;
                    }
                    end++;
                }
                numberStack.push(Integer.parseInt(s.substring(start, end)));
                start = end - 1;
            } else if (c == '[') {
                stringStack.push("");
            } else if (c == ']') {
                String str = stringStack.pop();
                int value = numberStack.pop();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < value; i++) {
                    sb.append(str);
                }
                stringStack.push(stringStack.pop() + sb.toString());
            } else {
                String tmp = stringStack.pop();
                stringStack.push(tmp + c);
            }
            start++;
        }
        return stringStack.pop();
    }
}
