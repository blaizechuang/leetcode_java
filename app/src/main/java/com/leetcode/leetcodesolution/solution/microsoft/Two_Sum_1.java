package com.leetcode.leetcodesolution.solution.microsoft;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;

public class Two_Sum_1 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {2,7,11,15};
        int target = 22;
        int[] result = twoSum(input, target);
        printIntList(result);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]);
                result[1] = i;
            } else {
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }
}
