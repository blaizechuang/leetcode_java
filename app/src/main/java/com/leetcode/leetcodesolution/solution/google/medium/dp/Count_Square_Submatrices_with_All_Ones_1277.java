package com.leetcode.leetcodesolution.solution.google.medium.dp;

class Count_Square_Submatrices_with_All_Ones_1277 {

    /**
     * 思路: 用 dp 的想法一直累加
     * 1. matrix[i][j] = 0 => continue or add 0
     * 2. 如果在邊界, 直接加 matrix[i][j] 的值, 基本上是 1
     * 3. 接下來就是找 左/上/左上 這三個值的最小值 + 1, 再累加到 result
     *
     * time complexity: O(m x n)
     * space complexity: O(1)
     */
    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int result = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
//                 if (matrix[i][j] == 0) {
//                     continue;
//                 }

//                 if (i == 0 || j == 0) {
//                     result++;
//                     continue;
//                 }
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
                }
                result += matrix[i][j];
            }
        }

        return result;
    }
}
