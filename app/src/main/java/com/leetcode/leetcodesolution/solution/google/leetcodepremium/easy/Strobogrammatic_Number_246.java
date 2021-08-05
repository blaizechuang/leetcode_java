package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import java.util.HashMap;
import java.util.Map;

class Strobogrammatic_Number_246 {

    /**
     * time complexity: O(N)
     * space complexity: O(1)
     *
     * 看到這題目, 就是左右兩邊往內縮, 注意 while 裏面是 <=
     */
    public boolean isStrobogrammatic(String num) {
//        Map<Character, Character> rotatedDigits = new Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');
        Map<Character, Character> rotatedDigits = new HashMap();
        rotatedDigits.put('0', '0');
        rotatedDigits.put('1', '1');
        rotatedDigits.put('6', '9');
        rotatedDigits.put('8', '8');
        rotatedDigits.put('9', '6');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char lch = num.charAt(left++);
            char rch = num.charAt(right--);
            if (!rotatedDigits.containsKey(lch) || rotatedDigits.get(lch) != rch) {
                return false;
            }
        }

        return true;
    }
}
