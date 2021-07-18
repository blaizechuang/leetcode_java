package com.leetcode.leetcodesolution.solution.medium;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Fruit_Into_Baskets_904 extends logger implements base_solution {
    @Override
    public void execute() {
//        int[] input = new int[]{3,3,3,1,2,1,1,2,3,3,4};
//        int[] input = new int[]{1,2,1};
        int[] input = new int[]{3,3,3,1,2,1,1,2,3,3,4};
//        int[] input = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        int result = totalFruit(input);
        Log.d("", "result: " + result);
    }

    /**
     * 目前看到最好的版本, 雖然時間沒有快到 5ms 這麼誇張,
     * runtime: 27 ms, memory: 45.9 MB
     * 比我的方法更好的地方是把 hashmap 的 second para 去記 index, 就可以少掉一個回圈
     * 可以熟悉一下 Collections.min() 這種用法
     */
    public int totalFruit(int[] fruits) {
        int start =0;
        int n = fruits.length;
        int maxLength =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int end=0; end<n; end++){
            map.put(fruits[end], end);
            if(map.size()>2){
                int minIndex = Collections.min(map.values());
                map.remove(fruits[minIndex]);
                start = minIndex + 1;
            }
            maxLength = Math.max(maxLength, end-start +1);
        }
        return maxLength;

    }

    /**
     *
     * 在 7/18 又寫了一次，但是還是沒有很精簡
     * runtime: 36 ms, memory: 47.9 MB
     */
//    public int totalFruit_0718(int[] fruits) {
//        int start = 0, end = -1;
//        int index = 0;
//        int max = Integer.MIN_VALUE;
//        HashMap<Integer, Integer> map = new HashMap();
//        while (index < fruits.length) {
//            int current = fruits[index];
//            System.out.println("current: " + current);
//            if (map.containsKey(current)) {
//                map.put(current, (map.get(current) + 1));
//                print("-- has " + current);
//                // already in basket
//                end++;
//                print("1. start: " + start + ", end: " + end);
//            } else {
//                // not in basket
//                while (map.size() == 2) {
//                    int fruitToRemove = fruits[start];
//                    int offset = map.get(fruitToRemove);
//                    if (offset == 1) {
//                        map.remove(fruitToRemove);
//                    } else {
//                        map.put(fruitToRemove, offset - 1);
//                    }
//                    start++;
//                }
//                map.put(current, 1);
//                end++;
//            }
//            max = Math.max(max, end-start+1);
//            index++;
//        }
//        System.out.println("4. end: " + end + ", start: " + start);
//        return max;
//    }

//    /***
//     *
//     * This method is slower than previous, I think the reason is the replace method,
//     * It seems that it takes O(n) and consider the outside while, total time complexity
//     * might be O(n2), it takes 36 ms
//     */
//    public int totalFruit_refine(int[] fruits) {
//        HashMap<Integer, Integer> map = new HashMap();
//        int max = Integer.MIN_VALUE;
//        int start = 0, end = 0;
//        while (end < fruits.length && start < fruits.length) {
//            if (map.get(fruits[end]) == null) {
//                // new item is not existed
//                Log.d("", "now fruit is " + fruits[end] + " busket size: " + map.size());
//                if (map.size() >= 2) {
//                    int count = map.get(fruits[start]);
//                    if (count > 1) {
//                        map.replace(fruits[start++], --count);
//                    } else {
//                        map.remove(fruits[start++]);
//                    }
//                    Log.d("", "now start: " + start);
//                } else {
//                    map.put(fruits[end], 1);
//                    Log.d("", "now end: " + end);
//                    max = Math.max(max, end-start+1);
//                    end++;
//                }
//            } else {
//                // new item already existed in basket
//                Log.d("", "2 now fruit is " + fruits[end] + " busket size: " + map.size());
//                int count = map.get(fruits[end]);
//                map.replace(fruits[end], ++count);
//                max = Math.max(max, end-start+1);
//                end++;
//
//            }
//            Log.d("", " now max: " + max + ", current max: " + (end-start+1));
//
//        }
//        return max;
//    }
//
//    /***
//     * 這題就是 sliding window 題型，因為有兩個籃子, 所以定義 second_last_fruit & last_fruit
//     * 去移動這個 list, 然後就看題目有什麼條件去判斷就行
//     * This method only takes 9ms
//     */
//    public int totalFruit(int[] tree) {
//        int second_last_fruit = -1, last_fruit = -1;
//        int current_max = 0;
//        int last_fruit_count = 0;
//        int max = 0;
//        for (Integer fruit : tree) {
//            if (fruit == second_last_fruit || fruit == last_fruit) {
//                current_max ++;
//            } else {
//                current_max = last_fruit_count + 1; //  加上最一開始的自己
//            }
//
//            if (fruit == last_fruit) {
//                last_fruit_count++;
//            } else {
//                last_fruit_count = 1;
//            }
//
//
//            if (last_fruit != fruit) {
//                second_last_fruit = last_fruit;
//                last_fruit = fruit;
//            }
//
//            max = Math.max(current_max, max);
//        }
//
//        return max;
//    }
}
