package com.leetcode.leetcodesolution.solution.medium;

import java.util.HashSet;

class Set_Matrix_Zeroes_73 {

    /**
     * 自己想到的方法
     * time complexity: O(M x N);
     * space complexity: O(1
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> positionX = new HashSet<>();
        HashSet<Integer> positionY = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    positionX.add(i);
                    positionY.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (positionX.contains(i) || positionY.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
