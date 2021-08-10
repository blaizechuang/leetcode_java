package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Rotate_Image_48 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(m);

    }

    /**
     * 先沿著對角線交換, 再交換行, 這個我比較看得懂，也比較直覺
     * time complexity: O(N^2), N: is col/row count
     * space complexity: O(N^2)
     * @param m
     */
    public void rotate(int[][] m) {
        // swap diagonal
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[i].length; j++) {
                if (i == j) continue;
                swap(m, i, j, j, i);
            }
        }

        // swap column
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length/2; j++) {
                swap(m, i, j, i, m[i].length - 1 - j);

            }
        }
    }

    private void swap(int[][] m, int firstR, int firstC, int secondR, int secondC) {
        int tmp = m[firstR][firstC];
        m[firstR][firstC] = m[secondR][secondC];
        m[secondR][secondC] = tmp;
    }
}
