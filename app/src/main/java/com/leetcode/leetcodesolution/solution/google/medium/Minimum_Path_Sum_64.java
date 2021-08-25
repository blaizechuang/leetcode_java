package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Minimum_Path_Sum_64 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int result = minPathSum(grid);
        print("result: " + result);
    }

    /**
     * 這題就是標準的 dp, 不過我直接去更改原本的 grid, 所以空間複雜度只需要 O(1)
     * 要特別注意的就是邊界的部分, 直接跟前一個相加即可
     * 不是邊界的話, 就找最小值去加
     *
     * time complexity: O(N), N: m x n
     * space complexity: O(1)
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                if (j == 0) {
                    grid[i][j] += grid[i-1][j];
                } else if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                } else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
