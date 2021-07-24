package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_Rooms_II_253 {
    /**
     * 這題幾乎是必考題
     * 在 I 的時候, 只要簡單去判斷前一個的結束時間是否 > 後一個的開始時間就好
     * 但是 II 是要去算最少需要幾間房間
     * 思路：一樣從 start time 去排序
     * 然後透過 priority queue 去記目前的結束時間, 然後 for loop 去找
     * 如果當下的開始時間 < queue 裡面取得最小的結束時間, 就把該時間替換掉
     * 也就是把 queue 裡面的最小值拿出, 把現在的結束時間放進去
     * 因為做 sort: 所以需要 O(nlogn), priority queue 的 poll 只需要 O(logn)
     * 所以 time complexity: O(nlogn)
     */
    public int minMeetingRooms(int[][] intervals) {
        // 有需要考慮開始結束時間都一樣的 case?
        // 開始時間小於結束時間？
        // 時間會丟負的？
        // Empty array?
        if (intervals.length == 0) return 0;

        PriorityQueue<Integer> allocator = new PriorityQueue();
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}
