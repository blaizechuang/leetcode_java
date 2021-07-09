package com.leetcode.leetcodesolution.solution.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Unique_Paths_II_63 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] input = new int[][]{{0}, {0}, {1}, {0}, {0}, {1}};
        int result = uniquePathsWithObstacles(input);
        print("-- result: " + result);
    }

    /**
     *
     * 不需額外空間的方法
     */
    public int uniquePathsWithObstacles(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        if (grid[0][0] == 1) return 0;
        grid[0][0] = 1;

        for (int i = 1; i < C; i++) {
            if (grid[0][i] == 0 && grid[0][i - 1] == 1) {
                grid[0][i] = 1;
            } else {
                grid[0][i] = 0;
            }
        }

        for (int i = 1; i < R; i++) {
            if (grid[i][0] == 0 && grid[i - 1][0] == 1) {
                grid[i][0] = 1;
            } else {
                grid[i][0] = 0;
            }
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }


        return grid[R - 1][C - 1];
    }

    /**
     *
     * dp method, 新增一個 int[][] space
     */
    public int uniquePathsWithObstacles_my(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i=0; i<dp.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i=0; i<dp[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
