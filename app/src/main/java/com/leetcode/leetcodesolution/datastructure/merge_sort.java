package com.leetcode.leetcodesolution.datastructure;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class merge_sort extends logger implements base_solution {
    @Override
    public void execute() {
        int[] source = { 5, 1, 6, 2, 3, 4 };
        Log.d("--", "Merge sort source; ");
        int[] result = mergeSort(source, source.length);
        Log.d("--", "Merge sort result: ");
    }

    private int[] mergeSort(int[] list, int n) {
        if (list.length < 2) return list;
        int middle = n/2;
        int[] left = new int[middle];
        int[] right = new int[n-middle];
        for (int i = 0; i < middle; i++) {
            left[i] = list[i];
        }

        for (int j = middle; j < n; j++) {
            right[j-middle] = list[j];
        }

        mergeSort(left, left.length);
        mergeSort(right, right.length);
        return merge(list, left, right, left.length, right.length);
    }

    private int[] merge(int result[], int[] left, int[] right, int leftCount, int rightCount) {
        int i = 0, j = 0, index = 0;
        while (i < leftCount && j < rightCount) {
            if (left[i] < right[j]) {
                result[index] = left[i];
                i++;
            } else {
                result[index] = right[j];
                j++;
            }
            index++;
        }

        while (i < leftCount) {
            result[index] = left[i];
            i++; index++;
        }

        while (j < rightCount) {
            result[index] = right[j];
            j++; index++;
        }

        return result;
    }
}
