package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Median_of_Two_Sorted_Arrays_4 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{3,4};
        double result = findMedianSortedArrays(a, b);
        Log.d("--", "result: " + result);
    }

    public double findMedianSortedArrays(int[] a, int[] b) {
        int lenA = a.length, lenB = b.length;
        if (lenA > lenB) {
            return findMedianSortedArrays(b, a);
        }
        int len = lenA + lenB;
        int startKA = 0, endKA = lenA;
        int cutA = 0, cutB = 0;
        while (startKA <= endKA) {
            cutA = (endKA + startKA) / 2;
            cutB = (len + 1) / 2 - cutA;
            double l1 = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            double l2 = (cutB == 0) ? Integer.MIN_VALUE : b[cutB - 1];
            double r1 = (cutA == lenA) ? Integer.MAX_VALUE : a[cutA];
            double r2 = (cutB == lenB) ? Integer.MAX_VALUE : b[cutB];
            if (l1 > l2) {
                endKA = cutA - 1;
            } else if (l2 > r1) {
                startKA = cutA + 1;
            } else {
                if (len %2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2;
                } else {
                    return Math.max(l1, l2);
                }
            }
        }
        return -1;
    }

    /**
     * 自己寫的
     * time complexity: O(m+n), 不是題目要的 O(log(m+n))
     * space complexity: O(m+n)
     */
    public double findMedianSortedArrays_blaize(int[] nums1, int[] nums2) {
        // 第一次寫難的寫出來 喔耶
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1 + length2];
        boolean twoDigits = ((length1 + length2) % 2 == 0);
        Log.d("--", "is two digits: " + twoDigits);
        int index = 0, i = 0, j = 0;
        while (index < length1 + length2) {
            if (i < length1 && j < length2) {
                if (nums1[i] < nums2[j]) {
                    result[index] = nums1[i];
                    i++;
                } else {
                    result[index] = nums2[j];
                    j++;
                }
            } else if (i < length1) {
                result[index] = nums1[i];
                i++;
            } else {
                result[index] = nums2[j];
                j++;
            }
            index++;
        }

        printIntList("result: ", result);

        int startIndex = result.length / 2;
        Log.d("--", "startIndex: " + startIndex);
        if (twoDigits) {
            return (double) (result[startIndex - 1] + result[startIndex]) / 2;
        } else {
            return result[startIndex];
        }
    }
}
