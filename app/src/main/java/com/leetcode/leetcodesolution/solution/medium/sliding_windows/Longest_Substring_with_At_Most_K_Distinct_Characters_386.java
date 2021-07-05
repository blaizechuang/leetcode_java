package com.leetcode.leetcodesolution.solution.medium.sliding_windows;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Longest_Substring_with_At_Most_K_Distinct_Characters_386 extends logger implements base_solution {
    @Override
    public void execute() {
//        String input = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";
        String input = "nutdrgzdrkrvfdfcvzuunxwlzegjukhkjpvqruitobiahxhgdrpqttsebjsg";
        int k = 11;
        int result = maxDistString(input, k);
        Log.d("--", "result: " + result);
    }

    /**
     * 這一的重點在於重複的值要記得去更新 hashmap 裡的 value,
     * 不然 remove 後真正的個數就會跟 map 的個數對不起來
     * Sliding window 的基本動作就是先一個 while 迴圈看 end 是不是已經到最後
     */
    private int maxDistString(String input, int diff) {
        if (input == null || input.isEmpty() || diff == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int start = 0, end = 0;
        while (end < input.length()) {
            Log.d("", "now end: " + end + ", map size: " + map.size());
            if (map.size() < diff || map.containsKey(input.charAt(end))) {
                // new
                if (map.containsKey(input.charAt(end))) {
                    // 取得當前的值
                    int value = map.get(input.charAt(end));
                    // 更新到 hashmap
                    map.replace(input.charAt(end), value + 1);
                } else {
                    // map 裡面沒有這個值, 直接塞進去, 值預設 1
                    map.put(input.charAt(end), 1);
                }
                maxLength = Math.max(maxLength, end - start + 1);
                Log.d("", "now maxLength: " + maxLength);
                end++;
            } else {
                // 先確認 map 裡面的 key 他的值是多少
                int val2 = map.get(input.charAt(start));
                // 如果大於 1, 表示有多個, 更新數量, 如果只有一個就把它移除
                if (val2 > 1) {
                    map.replace(input.charAt(start), --val2);
                } else {
                    map.remove(input.charAt(start));
                }
                start++;
            }
        }
        return maxLength;
    }
}
