package com.leetcode.leetcodesolution.datastructure;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;

public class select_sort implements base_solution {
    @Override
    public void execute() {
        int[] num = {3,5,1,4};
        int[] result = sort(num);
        String str = "";
        for (int i = 0; i < result.length; i++) {
            str += result[i] + ", ";

        }
        Log.d("tag", "After sort: " + str);
    }

    private int[] sort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < list.length; j++) {
                if (list[min] > list[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int tmp = list[min];
                list[min] = list[i];
                list[i] = tmp;
            }
        }

        return list;
    }
}
