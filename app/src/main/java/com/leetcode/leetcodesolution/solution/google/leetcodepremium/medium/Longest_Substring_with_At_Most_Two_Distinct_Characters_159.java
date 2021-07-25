package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_with_At_Most_Two_Distinct_Characters_159 extends logger implements base_solution {
    @Override
    public void execute() {
        String s = "abcabcabc";
        int result = lengthOfLongestSubstringTwoDistinct(s);
        print("result: " + result);
    }

    /**
     * 參考下面神人的答案, 邊講出自己的想法邊寫, 善用 map.getOrDefault 的方式，整個代碼精簡不少
     * 邏輯也相對簡單
     */
    public int lengthOfLongestSubstringTwoDistinct_myImprove(String s) {
        if (s == null || s.length() < 1) return 0;
        // 先用一個 HashMap 去記目前存在的 char
        // 然後用雙指標去取得開始跟結束的位置
        HashMap<Character, Integer> map = new HashMap();
        int start = 0, end = 0, count = 0, len = 0;;

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                count++;    // 新增的字
            }
            if (count > 2) {
                char firstChar = s.charAt(start);
                map.put(firstChar, map.get(firstChar)-1);
                if (map.get(firstChar) == 0) {
                    count--;
                }
                start++;
            }
            len = Math.max(len, end-start+1);
            end++;
        }
        return len;
    }

    /**
     * 別人的精簡代碼
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) counter++;//new char
            end++;
            while(counter > 2){
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if(map.get(cTemp) == 0){
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }

    /**
     * 我的第一個寫法, 邏輯有點混亂, 原因之一是不知道有 map.getOrDefault() 這個好用的 api
     * 而且在找最後長度的時候, 也因為 end++ 的時機錯了不少地方
     */
    public int lengthOfLongestSubstringTwoDistinct_me(String s) {
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap();

        while (end < s.length()) {
            print("now end: " + end + ", char: " + s.charAt(end));
            if (map.size() == 2) {
                // 檢查是否已經有在裡面
                print("=2 case, now map: " + map);
                if (!map.containsKey(s.charAt(end))) {
                    // 不在
                    int value = map.get(s.charAt(start));
                    if (value == 1) {
                        print("Remove " + s.charAt(start));
                        map.remove(s.charAt(start));
                        print("1. max: " + max);
                    } else {
                        print("Increase " + s.charAt(start));
                        map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    }
                    print("new map: " + map);
                    start++;
                } else {
                    map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
                    max = Math.max(max, end-start+1);
                    print("2. max: " + max + "now end: " + end);
                    end++;
                }
            } else {
                if (map.containsKey(s.charAt(end))) {
                    map.put(s.charAt(end), map.get(s.charAt(end)) +1);
                } else {
                    map.put(s.charAt(end), 1);
                }
                max = Math.max(max, end-start+1);
                end++;
            }
        }
        return max;
    }
}
