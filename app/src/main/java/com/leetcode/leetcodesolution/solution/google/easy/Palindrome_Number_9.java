package com.leetcode.leetcodesolution.solution.google.easy;

class Palindrome_Number_9 {

    /**
     * Leetcode 的解法, 直接把數值切一半, 譬如 1221 變成 12, 21
     * time complexity: O(log10(底線)N)
     * space complexity: O(1)
     * run time: 6 ms
     */
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

    /**
     * 下面是我自己想的先轉成 char[] 在用 sliding window 去解, 不過 run time 需要 14 ms
     * 而且題目說不能轉成 String Orz...沒注意到, 這個解法不行
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
