package com.leetcode.leetcodesolution.solution.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;

public class Reverse_Only_Letters_917 extends logger implements base_solution {
    @Override
    public void execute() {
//        String s = "ab-cd";
//        String s = "Test1ng-Leet=code-Q!";
        String s = "z<*zj";
        String result = reverseOnlyLetters(s);
        print("-- result: " + result);
    }

    /**
     * 這題自己想出來，不過也是花了半小時, 哎
     * 思路: 先用 char array 保留不是字母的部分, 然後從後開始往前找, 把不符合的項目替換掉
     * 另一個重點是要先把 chars 的預設內容都設為字元, 這樣之後的判斷才不會出錯
     * time complexity: O(N)
     * space complexity: O(N)
     */
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        char[] chars = new char[len];
        Arrays.fill(chars, 'a');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isAlphabet(c)) {
                chars[i] = c;
            }
        }
        printCharList("chars", chars);

        int start = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            print("-- c: " + c);

            if (!isAlphabet(c)) {
                continue;
            }

            print("-- start: " + start);
            while (!isAlphabet(chars[start])) {
                start++;
            }
            chars[start++] = c;
        }
        printCharList("new char", chars);

        return new String(chars);
    }

    private boolean isAlphabet(char c) {
        print("-- c: " + c);
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
}
