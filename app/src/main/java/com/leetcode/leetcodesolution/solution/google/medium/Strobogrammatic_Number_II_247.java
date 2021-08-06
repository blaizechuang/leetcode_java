package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strobogrammatic_Number_II_247 extends logger implements base_solution {
    @Override
    public void execute() {
        int n = 5;
        List<String> result = findStrobogrammatic(n);
        print("rsult: " + result);
        print("count: " + result.size());
    }

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    /**
     * time complexity: 5 + 5^2 + 5^3 + ... + 5^n => O(5^n)
     */
    private List<String> helper(int newN, int originN) {
        if (newN == 0) return new ArrayList<>(Arrays.asList(""));
        if (newN == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(newN-2, originN);

        List<String> result = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            String string = list.get(i);
            if (newN < originN) {
                result.add("0" + string + "0");
            }
            result.add("1" + string + "1");
            result.add("6" + string + "9");
            result.add("8" + string + "8");
            result.add("9" + string + "6");
        }

        return result;
    }
}
