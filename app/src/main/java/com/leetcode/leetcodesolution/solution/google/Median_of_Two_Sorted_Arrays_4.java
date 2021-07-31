package com.leetcode.leetcodesolution.solution.google;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Median_of_Two_Sorted_Arrays_4 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] a = new int[]{1,3};
        int[] b = new int[]{2};
        double result = findMedianSortedArrays(a,b);
        Log.d("--", "result: " + result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 第一次寫難的寫出來 喔耶
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result= new int[length1 + length2];
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

        int startIndex = result.length/2;
        Log.d("--", "startIndex: " + startIndex);
        if (twoDigits) {
            return (double)(result[startIndex-1] + result[startIndex])/2;
        } else {
            return result[startIndex];
        }
    }
}
