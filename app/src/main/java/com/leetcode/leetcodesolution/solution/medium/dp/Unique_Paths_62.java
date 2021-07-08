package com.leetcode.leetcodesolution.solution.medium.dp;

class Unique_Paths_62 {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 || c == 0) {
                    map[r][c] = 1;
                } else {
                    map[r][c] = map[r][c-1] + map[r-1][c];
                }
            }
        }

        return map[m-1][n-1];
    }
}
