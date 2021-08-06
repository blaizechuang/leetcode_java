package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Map;
import java.util.TreeMap;

public class My_Calendar_II_731 extends logger implements base_solution {
    @Override
    public void execute() {
        boolean r1 = book(10, 20);
        boolean r2 = book(50, 60);
        boolean r3 = book(10, 40);
        boolean r4 = book(5,15);
        boolean r5 = book(5, 10);
        boolean r6 = book(25, 55);
        print(r1 + " " + r2 + " " + r3 + " " + r4 + " " + r5 + " " + r6);
    }

    /**
     * 好強！把開始時間的 count 設成 1, 結束時間的 count 設成 -1
     * runtime: 197 ms
     *
     * time complexity: O(n^n) since for(Map.Entry<Integer, Integer> entry : map.entrySet()) need O(n)
     * space complexity: I think is O(n)
     * 跟 No.253 很像, 可以參考
     */
    TreeMap<Integer, Integer> map = new TreeMap();
    public boolean book(int start, int end) {
        print("book [" + start + ", " + end + "]");
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        print("-- map: " + map);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            print("entry: " + entry);
            count += entry.getValue();
            print("count: " + count);
            if(count > 2) {
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0) {
                    print("map.get(" + start + ") = 0");
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0) {
                    print("map.get(" + end + ") = 0");
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }

    /**
     * runtime: 56 ms
     * 這個方法看起來是用 I 的概念去做
     */
//    class MyCalendarTwo {
//        List<int[]> overlap;
//        List<int[]> calendar;
//
//        public MyCalendarTwo() {
//            overlap = new ArrayList<>();
//            calendar = new ArrayList<>();
//        }
//
//        public boolean book(int start, int end) {
//            for (int[] o : overlap) {
//                if (o[1] > start && end > o[0])
//                    return false;
//            }
//
//            for (int[] c : calendar) {
//                if (c[1] > start && end > c[0]) {
//                    overlap.add(new int[]{Math.max(start, c[0]), Math.min(end, c[1])});
//                }
//            }
//            calendar.add(new int[]{start, end});
//            return true;
//        }
//    }
}
