package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Longest_String_Chain_1048 extends logger implements base_solution {
    @Override
    public void execute() {
        String[] words = {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        int result = longestStrChain(words);
        print("result: " + result);
    }

    /**
     * N: words array 的個數
     * K: word 最長的數值
     * time complexity: O(N x K^2)
     * space complexity: O(N)
     */
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<String, Integer> dp = new HashMap<>();
        int result = 0;
        for (String word : words) {
            int subMax = 0;
            for (int i = 0; i < word.length(); i++) {
                StringBuffer sb = new StringBuffer(word).deleteCharAt(i);
                subMax = Math.max(subMax, dp.getOrDefault(sb.toString(), 0) + 1);
            }
            dp.put(word, subMax);
            result = Math.max(result, dp.get(word));
        }
        return result;
    }
}
