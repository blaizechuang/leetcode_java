package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy.design;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;

public class Logger_Rate_Limiter_359 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     * time complexity: O(1)
     * space complexity: O(M), M: unique message count
     *
     * map 可以改成 msgDict 比較好懂
     */
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
//    public Logger() {
//        map = new HashMap();
//    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int end = map.get(message);
            if (timestamp < end) return false;
        }
        map.put(message, timestamp + 10);
        return true;

    }
}
