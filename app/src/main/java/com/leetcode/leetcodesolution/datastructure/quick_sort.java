package com.leetcode.leetcodesolution.datastructure;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class quick_sort extends logger implements base_solution {
    @Override
    public void execute() {
        int[] list = {24,12,64,92,77,58,55,30,89,28};
        Log.d("--", "Quick sort soruce: ");
        printIntList(list);
        quickSort(list, 0, list.length - 1);
        Log.d("--", "Quick sort sorted: ");
        printIntList(list);
    }
    private int partition(int[] list, int leftIndex, int rightIndex) {
        Log.d("--", "Partiton: leftIndex: " + leftIndex + ", rightIndex: " + rightIndex);
        int pivot = list[leftIndex];
        while(leftIndex < rightIndex) {
            while (list[leftIndex] < pivot) {
                leftIndex++;
            }
            while (list[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex < rightIndex) {
                int tmp = list[leftIndex];
                list[leftIndex] = list[rightIndex];
                list[rightIndex] = tmp;
            }
        }
        printIntList(list);
        return leftIndex;
    }

    private void quickSort(int[] list, int leftIndex, int rightIndex) {
        int pivot = partition(list, leftIndex, rightIndex);
        Log.d("--", "pivot: " + pivot);
        if (leftIndex < pivot - 1) {
            quickSort(list, leftIndex, pivot - 1);
        }
        if (rightIndex > pivot) {
            quickSort(list, pivot + 1, rightIndex);
        }


    }
}
