package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Plus_One_66 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {9};
        int[] result = plusOne(input);
        printIntList(result);
    }

    /**
     * runtime: 0ms
     * 這題一開始在算 carry 的時候寫成 sum - 10, 真蠢
     * 不過進位的處理一開始就有想到
     */
    public int[] plusOne(int[] digits) {
        int sum = 0, carry = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] >= 9) {
                if (i == digits.length-1) {
                    sum +=1;
                }
                sum += digits[i] + carry;
                carry = sum >= 10 ? 1 : 0;
                sum -=10;
                digits[i] = sum;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        System.out.println("carry: " + carry);
        if (carry == 1) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = carry;
            for (int j = 0; j<digits.length-1;j++) {
                newDigits[j+1] = digits[j];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}
