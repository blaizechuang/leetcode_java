package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

class Rotate_Image_48 {
    /**
     * 這一題我覺得我只能背起來, 因為我不習慣處理二維陣列, 尤其是 i, j 我會轉不過來
     * 而且兩個 for 全圈也卡很久, 第一層就是 < len/2
     * 第二層的 j 一開始要等於 i, 然後 < len - 1 - i
     * 然後就是求四個點, 口訣是 i, j, j, i, 然後從 [0][0], [0][3], [3][3], [3][0] 去找出算式
     */
    public void rotate(int[][] m) {
        int n = m.length-1;
        for (int i = 0; i < m.length/2; i++) {
            for (int j = i; j < n - i; j++) {
                int p1 = m[i][j];
                int p2 = m[j][n-i];
                int p3 = m[n-i][n-j];
                int p4 = m[n-j][i];

                m[j][n-i] = p1;
                m[n-i][n-j] = p2;
                m[n-j][i] = p3;
                m[i][j] = p4;
            }
        }
    }
}
