package com.leetcode.leetcodesolution.solution.google.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Maximum_Number_of_Points_with_Cost_1937 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] points = {{2,4,0,5,5},{0,5,4,2,5},{2,0,2,3,1},{3,0,5,5,2}};
        long result = maxPoints(points);
        print("result: " + result);
    }

    /**
     * 這題我不懂, 看了很久還是不懂, 先跳過
     */
    public long maxPoints(int[][] points) {
        int result = 0;
        int[] preMaxArray = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            print("-------- now i: " + i +" ---------");
            int rowMax = Integer.MIN_VALUE;
            for (int j = 0; j < points[i].length; j++) {
                if (points[i][j] > rowMax) {
                    rowMax = points[i][j];
                    preMaxArray[i] = j;
                    print("rowMax: " + rowMax + ", preMaxArrau[" + i + "]: " + j);
                    if (i > 0) {
                        print("diff -> j: " + j + ", preMaxArray[" + (i-1) + "]: " + preMaxArray[i-1]);
                        rowMax -= (Math.abs(j - preMaxArray[i-1]));
                        print("減完後 rowMax: " + rowMax);
                    }
                }
            }
            result += rowMax;
            print("result: " + result);
        }
        return result;
    }
}
