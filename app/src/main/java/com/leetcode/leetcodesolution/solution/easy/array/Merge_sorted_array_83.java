package com.leetcode.leetcodesolution.solution.easy.array;

import java.util.Arrays;

class Merge_sorted_array_83 {
    /***
     *
     * 1 ms, memory usage 與下面差不多
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int item : nums2) {
            nums1[m] = item;
            m++;
        }

        Arrays.sort(nums1);
    }

    /**
     *
     * 0 ms, memory usage 39.3MB
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex1 = m-1;
        int lastIndex2 = n-1;
        int lastMergeIndex = m+n-1;
        while (lastIndex2 >= 0) {
            if (lastIndex1 >= 0 && nums1[lastIndex1] > nums2[lastIndex2]) {
                nums1[lastMergeIndex] = nums1[lastIndex1];
                lastIndex1--;
            } else {
                nums1[lastMergeIndex] = nums2[lastIndex2];
                lastIndex2--;
            }
            lastMergeIndex--;
        }
    }
}
