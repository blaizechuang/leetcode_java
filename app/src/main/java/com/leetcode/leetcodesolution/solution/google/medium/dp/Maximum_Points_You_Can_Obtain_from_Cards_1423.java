package com.leetcode.leetcodesolution.solution.google.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Maximum_Points_You_Can_Obtain_from_Cards_1423 extends logger implements base_solution {

    /**
     * 2021/08/24 自己寫的, 跟最下面的解答版一樣, 只是我用 while, 感覺用 for-loop 比較直覺
     * time complexity: O(k)
     * space complexity: O(k), 因為只需要 k 個位置, 不過處理起來比較麻煩, 用 O(N) 寫的方法比較直觀
     */
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] fromLeft = new int[len+1];
        int[] fromRight = new int[len+1];
        for (int i = 0; i < len; i++) {
            fromLeft[i+1] = fromLeft[i] + cardPoints[i];
            fromRight[i+1] = fromRight[i] + cardPoints[len-i-1];
        }

        int result = Integer.MIN_VALUE;
        int j = 0;
        while (k >= 0) {
            result = Math.max(result, fromLeft[k] + fromRight[j]);
            k--;
            j++;
        }
        //        for (int i = 0; i <= k; i++) {
//            int tmp = sumLeft[i] + sumRight[k-i];
//            result = Math.max(result, tmp);
//        }
        return result;
    }

    /**
     * 自己想到的 dp solution
     * time complexity: O(k)
     * space complexity:O(N), 解答說是 O(k);
     *
     * 下面的解答版是比較正規的 dp, 也就是 len + 1 的長度,
     * 而且都是從 0 開始, 不像我的一個是從 0 開始, 一個從 len - 1 開始
     * 而且正規 dp 的好處是不用去管 -1 這個運算, 比較不容易出錯
     */
//    public int maxScore(int[] cardPoints, int k) {
//        int[] sumLeft = new int[cardPoints.length];
//        int[] sumRight = new int[cardPoints.length];
//        int len = cardPoints.length;
//        sumLeft[0] = cardPoints[0];
//        sumRight[len - 1] = cardPoints[len - 1];
//
//        for (int i = 1; i < len; i++) {
//            sumLeft[i] = sumLeft[i-1] + cardPoints[i];
//            sumRight[len - 1 - i] = sumRight[len - i] + cardPoints[len - 1 - i];
//        }
//
//        printIntList("left", sumLeft);
//        printIntList("right", sumRight);
//
//        int left = len, right = k - 1;
//        print("lefrt: " + left + ", right: " + right);
//        int result  = sumLeft[right];
//        print("-- init result: " + sumLeft[right]);
//        while (right >= 0) {
//            right--;
//            left--;
//            if (right == -1) {
//                result = Math.max(result, sumRight[left]);
//            } else {
//                result = Math.max(result, sumLeft[right] + sumRight[left]);
//            }
//        }
//        return result;
//    }

    @Override
    public void execute() {
        int[] input = {100,40,17,9,73,75};
        int target = 3;
        int result = maxScore(input, target);
        print("result: " + result);
    }

//    public int maxScore(int[] cardPoints, int k) {
//        int[] sumLeft = new int[cardPoints.length + 1];
//        int[] sumRight = new int[cardPoints.length + 1];
//        int len = cardPoints.length;
//
//        for (int i = 0; i < len; i++) {
//            sumLeft[i + 1] = sumLeft[i] + cardPoints[i];
//            sumRight[i + 1] = sumRight[i] + cardPoints[len - 1 - i];
//        }
//
//        int result = Integer.MIN_VALUE;
//        for (int i = 0; i <= k; i++) {
//            int tmp = sumLeft[i] + sumRight[k-i];
//            result = Math.max(result, tmp);
//        }
//        return result;
//    }
}
