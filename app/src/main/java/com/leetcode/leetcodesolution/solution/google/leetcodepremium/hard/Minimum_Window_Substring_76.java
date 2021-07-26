package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Minimum_Window_Substring_76 extends logger implements base_solution {
    @Override
    public void execute() {
//        String input = "ADOBECODEBANC";
//        String target = "ABC";
        String input = "aa";
        String target = "aa";
        String result = myFun(input, target);
        print("result: " + result);
    }

    /**
     * 這次把 count 改成 t.length() 去實作好像更直覺一點
     */
    public String myFun(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0, end = 0, len = Integer.MAX_VALUE, count = t.length(), begin = 0;

        while(end < s.length()) {
            char c = s.charAt(end);
            print("now char: " + c);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if (map.get(c) >= 0) {
                    count--;
                }
            }
            end++;

            while (count == 0) {
                System.out.println("-- end: " + end + ", start: " + start + ", len: " + len);
                if (end-start < len) {
                    len = end-start;
                    begin = start;
                }
                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    print("Handle char: " + s.charAt(start));
                    if (map.get(s.charAt(start)) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }
        if (len == Integer.MAX_VALUE) return "";
        return s.substring(begin, begin+len);
    }

    /**
     * 這題思路是參考 這個高手的 slider window template
     * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
     * 主要當 count == 0 時候, 就要去計算目前的 len 是否符合
     * 要注意的是檢查 len 的時候，不要再去減 1, 因為我們要去取得 substring, 是 0-based
     */
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while(end < s.length()){
            print("end: " + end);
            char c = s.charAt(end);
            print("c: " + c);
            if( map.containsKey(c) ){
                print("map has " + c + ", descrease 1");
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) {print("" + c + "'s value is 0, count -- "); counter--;}
            }
            end++;

            while(counter == 0){
                print("count == 0");
                char tempc = s.charAt(begin);
                print("tempc = " + tempc);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    print("map has " + tempc + " increase 1");
                    if(map.get(tempc) > 0){
                        print("" + tempc + "'s value " + map.get(tempc) + " > 0, count ++");
                        counter++;
                    }
                }
                if(end-begin < len){
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }

        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }
}
