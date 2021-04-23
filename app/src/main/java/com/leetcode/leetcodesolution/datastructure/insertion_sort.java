package com.leetcode.leetcodesolution.datastructure;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;

public class insertion_sort implements base_solution {
    @Override
    public void execute() {
        int[] list = {51,17,100,97,36,11,56,95,67,44};
        insertSort(list);
        String str = "";
        str += "{ ";
        for (int i = 0; i < list.length; i++) {
            str += list[i] + " ";
        }
        str += "}";
        Log.d("--", "After insertion sort: " + str);
    }

    private void insertSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (i == 0) continue;
            for (int j = i; j > 0 ; j--) {
                if (list[j] < list[j-1]) {
                    int tmp = list[j];
                    list[j] = list[j-1];
                    list[j-1] = tmp;
                }
            }
        }
    }
}
