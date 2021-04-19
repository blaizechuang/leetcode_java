package com.leetcode.leetcodesolution.solution;

import android.util.Log;

import java.util.HashMap;

public class two_sum_1 implements base_solution{
    public void execute() {
        int[] source = {2,7,11,15};
        int target = 22;
        int[] result = function(source, target);
        for (int i = 0; i < result.length; i++) {
            Log.d("--", result[i] + " ");
        }
    }

    public int[] function(int[] numbers, int target) {
        int[] result = new int[2];  //initializing array
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[1] = i;
                result[0] = map.get(numbers[i]);
                return result;
            } else {
                map.put(target-numbers[i], i);
            }
        }

        return result;
    }
}
