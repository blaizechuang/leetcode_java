package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Plus_One_66 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {9};
        int[] result = plusOne(input);
        printIntList("result", result);
    }

    /**
     * Leetcode solution 的方法, 更直覺, 而且有利用到題目的特性, 就是只會 + 1
     * 所以沒有跑到 index 0 的位置表示答案已經出來了, 就 return
     * 如果跑完 for loop, 表示有進位, 所以再 new 一個 int array, 把 array[0] 設成 1 即可
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }
            // here we have the rightmost not-nine
            else {
                // increase this rightmost not-nine by 1
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * runtime: 0ms
     * 這題一開始在算 carry 的時候寫成 sum - 10, 真蠢
     * 不過進位的處理一開始就有想到
     */
//    public int[] plusOne(int[] digits) {
//        int sum = 0, carry = 0;
//        for (int i = digits.length-1; i >= 0; i--) {
//            if (digits[i] >= 9) {
//                if (i == digits.length-1) {
//                    sum +=1;
//                }
//                sum += digits[i] + carry;
//                carry = sum >= 10 ? 1 : 0;
//                sum -=10;
//                digits[i] = sum;
//            } else {
//                digits[i] = digits[i] + 1;
//                return digits;
//            }
//        }
//        System.out.println("carry: " + carry);
//        if (carry == 1) {
//            int[] newDigits = new int[digits.length+1];
//            newDigits[0] = carry;
//            for (int j = 0; j<digits.length-1;j++) {
//                newDigits[j+1] = digits[j];
//            }
//            return newDigits;
//        } else {
//            return digits;
//        }
//    }
}
