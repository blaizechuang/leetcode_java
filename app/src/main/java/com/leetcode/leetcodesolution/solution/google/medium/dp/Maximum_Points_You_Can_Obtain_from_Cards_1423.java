package com.leetcode.leetcodesolution.solution.google.medium.dp;

class Maximum_Points_You_Can_Obtain_from_Cards_1423 {

    /**
     * 自己想到的 dp solution
     * time complexity: O(k)
     * space complexity:O(N), 解答說是 O(k);
     *
     * 下面的解答版是比較正規的 dp, 也就是 len + 1 的長度,
     * 而且都是從 0 開始, 不像我的一個是從 0 開始, 一個從 len - 1 開始
     * 而且正規 dp 的好處是不用去管 -1 這個運算, 比較不容易出錯
     */
    public int maxScore(int[] cardPoints, int k) {
        int[] sumLeft = new int[cardPoints.length];
        int[] sumRight = new int[cardPoints.length];
        int len = cardPoints.length;
        sumLeft[0] = cardPoints[0];
        sumRight[len - 1] = cardPoints[len - 1];

        for (int i = 1; i < len; i++) {
            sumLeft[i] = sumLeft[i-1] + cardPoints[i];
            sumRight[len - 1 - i] = sumRight[len - i] + cardPoints[len - 1 - i];
        }

        int left = len, right = k - 1;
        int result  = sumLeft[right];
        while (right >= 0) {
            right--;
            left--;
            if (right == -1) {
                result = Math.max(result, sumRight[left]);
            } else {
                result = Math.max(result, sumLeft[right] + sumRight[left]);
            }
        }
        return result;
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
