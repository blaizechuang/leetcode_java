package com.leetcode.leetcodesolution.solution.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Unique_Paths_II_63 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] input = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int result = uniquePathsWithObstacles(input);
        print("-- result: " + result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i=0; i<dp.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                print("1. [" + i + "][" +0 + "] is 1, break ");
                break;
            }
            dp[i][0] = 1;
            print("1. set [" + i + "][" +0 + "] to 1 ");
        }

        print("-- now [0][0]: " + dp[0][0]);

        for (int i=0; i<dp[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                print("2. [" + i + "][" +0 + "] is 1, break ");
                break;
            }
            dp[0][i] = 1;
            print("2. set [" + i + "][" +0 + "] to 1 ");
        }

        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    print("!= 1 -> [" + i + "][" +j + "] = " + "dp[" + (i-1) + "][" + j + "] + " + "dp[" + (i) + "][" + (j-1) + "]");
                }
            }
        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    // My method
    public int uniquePathsWithObstacles_my(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) return 0;
        // Get row length
        int rowCount = obstacleGrid.length;
        // Get column length
        int colCount = obstacleGrid[0].length;

        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < colCount; c++) {
                if (r == 0 || c == 0) {
                    obstacleGrid[r][c] = 1;
//                    print("init input[" + r + "][" +c + "]: " + obstacleGrid[r][c]);
                } else {
                    if (obstacleGrid[r][c] == 0) {
                        print("-- calc new value");
                        obstacleGrid[r][c] = obstacleGrid[r-1][c] + obstacleGrid[r][c-1];
                        print("input[" + r + "][" + c + "]: " + obstacleGrid[r][c] + " = [" + (r-1) + "][" + c + "]: " + obstacleGrid[r-1][c] + " + input[" + (r-1) + "][" + (c-1) + "]: " + obstacleGrid[r][c-1]);
                    } else {
                        obstacleGrid[r][c] = 0;
                    }
                }
            }
        }

        return obstacleGrid[rowCount-1][colCount-1];
    }
}
