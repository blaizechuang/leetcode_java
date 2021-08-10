package com.leetcode.leetcodesolution.solution.google.medium.backtracking;

public class Number_of_Islands_200 {

    /**
     * backtracking 的題目只要記得 template 後就比較有頭緒了
     * time complexity: O(MxN)
     * space complexity: O(MxN)
     */
    public int numIslands(char[][] grid) {
        int numIslands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}
