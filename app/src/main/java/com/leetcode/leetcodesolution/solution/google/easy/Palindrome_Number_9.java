package com.leetcode.leetcodesolution.solution.google.easy;

class Palindrome_Number_9 {

    /**
     * Leetcode 神人的解法, 這公式也太厲害, 不過 run time 也是需要 12 ms
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public boolean isPalindrome(int x) {
        int result = 0;
        int inputX = x;
        while (x > 0) {
            result = result * 10 + (x % 10);
            x = x / 10;
        }
        return result == inputX;
    }

    /**
     * 下面是我自己想的先轉成 char[] 在用 sliding window 去解, 不過 run time 需要 14 ms
     * toCharArray 需要 O(N), sliding windows 只需要一半的時間 O(LogN)
     * time complexity: O(N)
     * space complexity: O(N)
     */
//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        char[] array = String.valueOf(x).toCharArray();
//        int start = 0, end = array.length - 1;
//        while (start< end) {
//            if (array[start] != array[end]) return false;
//            start++;
//            end--;
//        }
//        return true;
//    }
}
