package com.leetcode.leetcodesolution.solution;

import android.util.Log;

public class logger {
    public void printIntList(int[] list) {
        String str = "";
        str += "{ ";
        for (int i = 0; i < list.length; i++) {
            str += list[i] + " ";
        }
        str += "}";
        Log.d("--", "List: " + str);
    }
}
