package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Rotate_Image_48 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(m);

    }

    /**
     * 突然懂了！！！
     * 先沿著對角線交換, 再交換行, 這個我比較看得懂，也比較直覺
     * time complexity: O(N^2), N: is col/row count
     * space complexity: O(N^2)
     * @param m
     */
    public void rotate(int[][] m) {
        // swap diagonal
        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[i].length; j++) { //  這行要注意, 是  j = i
                if (i == j) continue;
                swap(m, i, j, j, i);
            }
        }

        // swap column
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length/2; j++) {   // 因為我垂直中線交換
                swap(m, i, j, i, m[i].length - 1 - j);

            }
        }
    }

    private void swap(int[][] m, int firstR, int firstC, int secondR, int secondC) {
        int tmp = m[firstR][firstC];
        m[firstR][firstC] = m[secondR][secondC];
        m[secondR][secondC] = tmp;
    }

    /**
     * 這一題我覺得我只能背起來, 因為我不習慣處理二維陣列, 尤其是 i, j 我會轉不過來
     * 而且兩個 for 全圈也卡很久, 第一層就是 < len/2
     * 第二層的 j 一開始要等於 i, 然後 < len - 1 - i
     * 然後就是求四個點, 口訣是 i, j, j, i, 然後從 [0][0], [0][3], [3][3], [3][0] 去找出算式
     */
//    public void rotate(int[][] m) {
//        int n = m.length-1;
//        for (int i = 0; i < m.length/2; i++) {
//            for (int j = i; j < n - i; j++) {
//                int p1 = m[i][j];
//                int p2 = m[j][n-i];
//                int p3 = m[n-i][n-j];
//                int p4 = m[n-j][i];
//
//                m[j][n-i] = p1;
//                m[n-i][n-j] = p2;
//                m[n-j][i] = p3;
//                m[i][j] = p4;
//            }
//        }
//    }
}
