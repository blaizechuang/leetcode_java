package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule_207 extends logger implements base_solution {

    /**
     * time complexity: O(V + E), v: 課程數, E: 關連數
     * space complexity: O(V + E), v: 課程數, E: 關連數
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCourseCount = new int[numCourses];
        for (int[] pair : prerequisites) {
            preCourseCount[pair[0]]++;
        }
        // 每個課程有幾個預休項目
        // 0, 1 <-- preCourseCount
        // 1, 0
        printIntList("preCourseCount" , preCourseCount);

        Queue<Integer> noPrerequiredCourse = new LinkedList<>();
        for (int i = 0; i < preCourseCount.length; i++) {
            if (preCourseCount[i] == 0) {
                noPrerequiredCourse.offer(i);
            }
        }
        // noPrerequiredCourse 存放目前不需要預修課程的課程
        print("noPrerequiredCourse: " + noPrerequiredCourse);

        // noPrerequiredCourse now has index 0 and its indegree is 1
        while (!noPrerequiredCourse.isEmpty()) {
            int cur = noPrerequiredCourse.poll();
            print("cur: " + cur);

            // 跟原本的預修列表比對
            for (int[] pair : prerequisites) {
                int course = pair[0];
                int preCourse = pair[1];
                print("preCourseCount[pair[0]]: " + preCourseCount[pair[0]]);
                if (preCourseCount[course] == 0) {
                    print("continue");
                    continue;
                }

                print("preCourse: " + preCourse);
                // 課程 1 的預修列表已經修完了, 表示課程 1 不需要再修這門預修課, 所以課程 1 可以少一堂預修課
                if (preCourse == cur) {
                    print("--");
                    preCourseCount[course] --;
                }

                if (preCourseCount[course] == 0) {
                    print(" offer: " + course);
                    noPrerequiredCourse.offer(course);
                }
            }
        }

        for (int i = 0; i < preCourseCount.length; i++) {
            if (preCourseCount[i] != 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void execute() {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        boolean result = canFinish(numCourses, prerequisites);
        print("-- result: " + result);
    }
}
