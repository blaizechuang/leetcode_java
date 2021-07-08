package com.leetcode.leetcodesolution;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Stack;

public class Crash_Problem extends logger implements base_solution {
    @Override
    public void execute() {
        long start = System.currentTimeMillis();
        int result = getSteps(35);
        print("result: " + result);
        long end = System.currentTimeMillis();
        print("-- total duration: " + (end-start));

    }

    int getSteps(int n) {
        int[] steps = new int[n+1];

        steps[0] = 1;
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <=n; i++) {
            steps[i] = steps[i-1] + steps[i-2] + steps[i-3];
        }
        return steps[n];
    }

    int fibonacci(int x) {
        if (x == 0 || x == 1) return 1;
        int[] cache = new int[x+1];
        int first = 1;
        int second = 1;
        int result = 0;
        for (int i = 2; i <= x; i++) {
            result = first + second;
            first = second;
            second = result;

        }
        return result;

    }

    int covertOddEven(int value) {
        return ((value & 0xaaaaaaaa) >>> 1) | ((value & 0x55555555) << 1);
    }

    void getAllPrimes(int max) {
        boolean[] flags = new boolean[max+1];
        // init all flags to true
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }

        int prime = 2;
        while (prime < Math.sqrt(max)) {
            deleteNonPrimeItem(flags, prime);
            prime = getNextPrime(flags, prime);
        }

        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                print("-- Prime: " + i);
            }
        }
    }

    void deleteNonPrimeItem(boolean[] flags, int prime) {
        for (int i = prime*prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    int getNextPrime(boolean[] flags,  int prime) {
        prime ++;
        while (!flags[prime]) {
            prime ++;
        }
        return prime;
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < (int)Math.sqrt(n); i++) {
            if ((n%i) == 0) return false;
        }
        return true;
    }

    int findDiff(int a, int b) {
        int count = 0;
        for (int i = a^b; i != 0 ; i >>= 1) {
            if ((i & 1) == 1) count++;
        }
        return count;
    }

    String convert(double num) {
        if (num >=1 || num < 0) {
            return "ERROR";
        }
        StringBuffer binary = new StringBuffer("0");
        binary.append(".");
        while (num > 0) {
            if (binary.length() >32) return "ERROR";
            num *=2;
            if (num >= 1) {
                binary.append("1");
                num -= 1;
            } else {
                binary.append("0");
            }
        }
        return binary.toString();
    }

}