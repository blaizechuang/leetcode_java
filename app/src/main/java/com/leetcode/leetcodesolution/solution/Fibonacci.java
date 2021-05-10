package com.leetcode.leetcodesolution.solution;

import android.util.Log;

import java.sql.Timestamp;

public class Fibonacci extends logger implements base_solution {
    @Override
    public void execute() {
        int n = 4000;
        Log.d("--", "Start Time: " + new Timestamp(new Timestamp(System.currentTimeMillis()).getTime()));
        Log.d("--", "Input: " + n);
        int result = fun2(n);
        Log.d("--", "After fibonacci is: " + result);
        Log.d("--", "End Time: " + new Timestamp(new Timestamp(System.currentTimeMillis()).getTime()));

    }

    private int fun(int n) {
        if (n == 0 || n == 1) return 1;
        return fun(n-1) + fun(n-2);
    }

    private int fun2(int n) {
        if (n == 0 ||  n == 1) return 1;
        int[] num = new int[n+1];
        num[0] = 1; num[1] = 1;
        for (int i = 2; i <= n; i++) {
            num[i] = num[i-1] + num[i-2];
        }
        return num[n];

    }
}
