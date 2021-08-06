package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class My_Calendar_I_729 {
}

/**
 * 這個方法比較直覺, 不過 runtime 比較久, 要 69 ms, 再研究一下 tree node
 * time complexity: O(n)
 * space complexity: O(n), n is books items
 */
class MyCalendar_sort {

    List<int[]> books;
    public MyCalendar_sort() {
        books = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] duration : books) {
            if (Math.max(start, duration[0]) < Math.min(end, duration[1])) return false;
        }

        books.add(new int[]{start, end});
        return true;
    }
}

/**
 * time complexity: O(NlogN)
 * space complexity: O(N)
 *
 * runtime: 22 ms
 */
class MyCalendar_TreeMap {

    TreeMap<Integer, Integer> calendar;
    public MyCalendar_TreeMap() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);    // 前一個時段的開始時間
        Integer next = calendar.ceilingKey(start);  // 後一個時段的開始時間
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || next >= end)) {
            calendar.put(start, end);
            return true;
        }

        return false;
    }
}