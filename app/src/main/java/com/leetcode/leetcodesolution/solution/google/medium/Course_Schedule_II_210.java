package com.leetcode.leetcodesolution.solution.google.medium;

import java.util.LinkedList;
import java.util.Queue;

class Course_Schedule_II_210 {

    /**
     * time complexity: O(V + E), v: 課程數, E: 關連數
     * space complexity: O(V + E), v: 課程數, E: 關連數
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] preCourses = new int[numCourses];

        for (int[] pair : prerequisites) {
            preCourses[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preCourses.length; i++) {
            if (preCourses[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index] = cur;
            index++;

            for (int[] pair : prerequisites) {
                int nowCourse = pair[0];
                int preCourse = pair[1];
                if (preCourses[pair[0]] == 0) {
                    continue;
                }

                if (preCourse == cur) {
                    preCourses[nowCourse]--;
                }

                if (preCourses[nowCourse] == 0) {
                    queue.offer(nowCourse);
                }
            }
        }

        for (int i = 0; i < preCourses.length; i++) {
            if (preCourses[i] != 0) {
                return new int[]{};
            }
        }

        return result;
    }
}
