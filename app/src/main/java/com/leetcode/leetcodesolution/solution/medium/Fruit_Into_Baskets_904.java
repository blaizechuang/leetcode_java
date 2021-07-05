package com.leetcode.leetcodesolution.solution.medium;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;

public class Fruit_Into_Baskets_904 extends logger implements base_solution {
    @Override
    public void execute() {
//        int[] input = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        int[] input = new int[]{1,2,1};
//        int[] input = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        int result = totalFruit_refine(input);
        Log.d("", "result: " + result);
    }

    /***
     *
     * This method is slower than previous, I think the reason is the replace method,
     * It seems that it takes O(n) and consider the outside while, total time complexity
     * might be O(n2), it takes 36 ms
     */
    public int totalFruit_refine(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap();
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        while (end < fruits.length && start < fruits.length) {
            if (map.get(fruits[end]) == null) {
                // new item is not existed
                Log.d("", "now fruit is " + fruits[end] + " busket size: " + map.size());
                if (map.size() >= 2) {
                    int count = map.get(fruits[start]);
                    if (count > 1) {
                        map.replace(fruits[start++], --count);
                    } else {
                        map.remove(fruits[start++]);
                    }
                    Log.d("", "now start: " + start);
                } else {
                    map.put(fruits[end], 1);
                    Log.d("", "now end: " + end);
                    max = Math.max(max, end-start+1);
                    end++;
                }
            } else {
                // new item already existed in basket
                Log.d("", "2 now fruit is " + fruits[end] + " busket size: " + map.size());
                int count = map.get(fruits[end]);
                map.replace(fruits[end], ++count);
                max = Math.max(max, end-start+1);
                end++;

            }
            Log.d("", " now max: " + max + ", current max: " + (end-start+1));

        }
        return max;
    }

    /***
     * 這題就是 sliding window 題型，因為有兩個籃子, 所以定義 second_last_fruit & last_fruit
     * 去移動這個 list, 然後就看題目有什麼條件去判斷就行
     * This method only takes 9ms
     */
    public int totalFruit(int[] tree) {
        int second_last_fruit = -1, last_fruit = -1;
        int current_max = 0;
        int last_fruit_count = 0;
        int max = 0;
        for (Integer fruit : tree) {
            if (fruit == second_last_fruit || fruit == last_fruit) {
                current_max ++;
            } else {
                current_max = last_fruit_count + 1; //  加上最一開始的自己
            }

            if (fruit == last_fruit) {
                last_fruit_count++;
            } else {
                last_fruit_count = 1;
            }


            if (last_fruit != fruit) {
                second_last_fruit = last_fruit;
                last_fruit = fruit;
            }

            max = Math.max(current_max, max);
        }

        return max;
    }
}
