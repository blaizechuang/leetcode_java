package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Minimum_Window_Substring_76 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "ADOBECODEBANC";
        String target = "ABC";
        String result = minWindow(input, target);
        print("result: " + result);
    }

    public String minWindow(String s, String t) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int[] map = new int[256];
        int end = 0;
        int start = 0;
        int min_length = Integer.MAX_VALUE;
        for(int i = 0; i < t_array.length; i++)
            map[t_array[i]] ++;
        int count = t_array.length;
        print("-- count: " + count);
        int min_start = 0;
        while(end < s_array.length)
        {
            print("-- now end: " + end + ", now char: " + s_array[end] + ", map[s_array[end]]: " + map[s_array[end]]);
            if(map[s_array[end]] > 0)
            {
                count--;
                print("-- count - 1, now count = " + count);
            }
            map[s_array[end]] --;
            print("-- map["+s_array[end]+"] = " + map[s_array[end]] + ", current count: " + count);
            while(count == 0)
            {
                if((end - start + 1) < min_length)
                {
                    min_length = end - start + 1;
                    min_start = start;
                    print("min_length: " + min_length + ", min_start: " + min_start);
                }
                map[s_array[start]] ++;
                print("-- map[" + s_array[start] + "]++ -> " + map[s_array[start]]);
                if(map[s_array[start]] > 0){
                    count ++;
                    print("count++ ->" + count);
                }
                start++;
                print("start++ -> " + start);
            }
            end ++;
            print("end++ -> " + end);

        }
        if( min_start+min_length > s_array.length)
            return "";

        return s.substring(min_start, min_start+min_length);
    }
}
