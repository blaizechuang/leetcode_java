package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_All_Anagrams_in_a_String_438 extends logger implements base_solution {
    @Override
    public void execute() {
//        String input = "baa";
//        String target = "aa";
        String input = "cbaebabacd";
        String target = "abc";
//        String input = "abab";
//        String target = "ab";
        List<Integer> list = findAnagrams(input, target);
        print("list " + list);
    }

    /**
     * 想到這個解法的人真的是天才, 而且代碼簡潔, 也很符合 slider window 的精神
     * time complexity: O(n), space complexity: O(1), 因為是用固定 size 的 map
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int start = 0;
        int end = 0;

        while(end < s.length()){
            if(map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) > 0){
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                end++;
                if(end - start == p.length())
                    list.add(start);
            }else if(end == start){
                end++;
                start++;
            }else{
                map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);
                start++;
            }
        }

        return list;
    }
}
