package com.leetcode.leetcodesolution.solution.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Strobogrammatic_Number_III_248 {

    /**
     *
     * 這題我直接拿 II 的方式來這邊用，所以 run time 偏高, 要 29 ms
     * 很多人是用 dfs 去做, 不過暫時看不懂, 這一題有一個比較重要的, 就是字串長度會大於 integer, 甚至 long
     * 所以在比較的時候要用 string.compareTo(), retult < 表示比框框裡面小
     */
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        for (int i = low.length(); i <= high.length(); i++) {
            List<String> list = helper(i, i);
            for (String string : list) {
                if ((string.length() == low.length() && string.compareTo(low) < 0) || (string.length() == high.length() && string.compareTo(high) > 0)) {
                    continue;
                }
                count++;
            }
        }

        return count;
    }

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
