package com.leetcode.leetcodesolution.solution.microsoft;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class String_To_Integer_atoi_8 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "00000-42a1234";
        int value = myAtoi(input);
        Log.d("--", "value: " + value);
    }

    public int myAtoi(String s) {
        long value = 0;
        int neg = 0;
        int pos = 0;
        boolean hasPause = false;
        boolean hasAlpha = false;
        boolean hasNumber = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (hasNumber || neg > 0 || pos > 0) break;
            } else if (s.charAt(i) == '-') {
                if (hasNumber) {
                    break;
                }
                if (neg > 0) {
                    break;
                } else {
                    neg++;
                }
            } else if (s.charAt(i) == '+') {
                if (hasNumber) {
                    break;
                }
                if (pos > 0) {
                    break;
                } else {
                    pos++;
                }
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9' && !hasPause && !hasAlpha) {
                hasNumber = true;
                value = value * 10 + s.charAt(i) - '0';
            } else {
                hasAlpha = true;
            }

            if (value / 10 > Integer.MAX_VALUE) break;
        }

        if (neg > 0) {
            value = -value;
        }

        if (neg + pos > 1) return 0;

        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)value;
    }
}
