package com.leetcode.leetcodesolution.solution.microsoft;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;

public class Roman_to_Integer_13 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "LVIII";
        int result = romanToInt_switch(input);
        Log.d("--", "Output: " + result);
    }

    public int romanToInt_switch(String s) {
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    array[i] = 1;
                    break;
                case 'V':
                    array[i] = 5;
                    break;
                case 'X':
                    array[i] = 10;
                    break;
                case 'L':
                    array[i] = 50;
                    break;
                case 'C':
                    array[i] = 100;
                    break;
                case 'D':
                    array[i] = 500;
                    break;
                case 'M':
                    array[i] = 1000;
                    break;
                default:
                    break;
            }
        }

        int sum = 0;
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] < array[j+1]) {
                sum -= array[j];
            } else {
                sum += array[j];
            }
        }
        return sum + array[array.length - 1];
    }

    // time: 5ms
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int value = 0;
        Character pre = null;
        for (int i = 0; i < s.length(); i++) {
            value += map.get(s.charAt(i));
            if (pre != null && map.get(s.charAt(i)) > map.get(pre)) {
                value -= 2* map.get(pre);
            }
            pre = s.charAt(i);
        }

        return value;
    }
}
