package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Expressive_Words_809 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        int result = expressiveWords(input, words);
        print("-- result: " + result);
    }

    /**
     * 遇到這種類型的, 就是 for 那個 array, 然後有比較兩個字串的長度這種關鍵字的
     * 就是雙指標去掃兩個字串
     * runtime: 1 ms
     */
    public int expressiveWords(String s, String[] words) {
        int validCount = 0;
        for (String string : words) {
            boolean valid = compare(s, string);
            if (valid) {
                validCount++;
            }
        }
        return validCount;
    }

    private boolean compare(String source, String target) {
        int i = 0, j = 0;
        print("-- current surce: " + source + ", target: " + target);
        while (i < source.length() && j < target.length()) {
            print("-- i: " + i + ", j: " + j);
            if (source.charAt(i) != target.charAt(j)) {
                return false;
            }

            int sourceLen = getGroupLen(source, i);
            int targetLen = getGroupLen(target, j);
            if (sourceLen < 3 && (sourceLen != targetLen)) {
                return false;
            }

            if (targetLen > sourceLen) {
                return false;
            }

            i += sourceLen;
            j += targetLen;
        }

        if (i == source.length() && j == target.length()) {
            return true;
        }
        return false;
    }

    private int getGroupLen(String words, int index) {
        int current = index;
        print("-- [getGroupLen] words: " + words + ", index: " + index);
        while (current < words.length() && words.charAt(current) == words.charAt(index)) {
            current++;
        }
        return current - index;
    }
}
