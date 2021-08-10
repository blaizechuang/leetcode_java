package com.leetcode.leetcodesolution.solution.google.medium.backtracking;

class Max_Area_of_Island_695 {

    /**
     * time complexity: O(M x N)
     * space complexity: O(M x N)
     */
    int value = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    dfs(grid, r, c);
                    max = Math.max(max, value);
                    value = 0;
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        value++;
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}
