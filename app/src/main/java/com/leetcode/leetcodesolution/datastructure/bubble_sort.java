package com.leetcode.leetcodesolution.datastructure;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class bubble_sort extends logger implements base_solution {
    @Override
    public void execute() {
        Log.d("--", "[Bubble Sort] source");
        int[] list = {36,30,58,75,88,26,25,12,98,66, -2};
        printIntList(list);
        bubbleSort(list);
        Log.d("--", "[Bubble Sort] sorted");
        printIntList(list);
    }

    private void bubbleSort(int[] list) {
        int times = list.length - 1;
        Log.d("--", "Start sorting...");
        while (times > 0) {
            times--;
            for (int i = 0; i < list.length -1; i++) {
                if (list[i] > list[i+1]) {
                    int tmp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = tmp;
                }
            }
            printIntList(list);
        }
        Log.d("--", "Done sorting...");
    }
}
