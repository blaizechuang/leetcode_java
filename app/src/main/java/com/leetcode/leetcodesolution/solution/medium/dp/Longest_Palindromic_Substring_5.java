package com.leetcode.leetcodesolution.solution.medium.dp;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Longest_Palindromic_Substring_5 extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "bb";
        String result = longestPalindrome(input);
        print("-- result: " + result);
    }

    /**
     * time complexity: O(N^2)
     * space complexity: O(1)
     * 要注意的地方是更新 start, end 的判斷, len - 1 這邊要特別注意
     * substring 的部分, 要記得 end + 1, 不然會少拿一個
     */
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            print("current i: " + i);
            int oddLen = expandFromMiddle(s, i, i);
            int evenLen = expandFromMiddle(s, i, i+1);
            print("oddLen: " + oddLen + ", evenLen: " + evenLen);
            len = Math.max(oddLen, evenLen);
            if (len > end - start) {
                start = i - (len-1)/2;
                end = i + len/2;
                print("start = " + i);
            }
        }
        return s.substring(start, end+1);
    }

    private int expandFromMiddle(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        print("start: " + start + ", end: " + end + ", len = " + (end-start-1));
        return end-start - 1;

    }

    /***
     * 長度有奇有偶, 所以兩個位置都要判斷, 因為從左看跟從右看都是相等, 所以去中間值去擴展
     * 先實作一個從中間往外擴展的 function, 然後再用一個 for 迴圈去掃全部
     */
//    public String longestPalindrome(String s) {
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandFromMiddle(s, i, i);
//            int len2 = expandFromMiddle(s, i, i+1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1)/2;
//                end = i + len/2;
//            }
//        }
//
//        return s.substring(start, end + 1);
//    }
//
//    private int expandFromMiddle(String s, int left, int right) {
//        if (left > right) return 0;
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//
//        return right - left - 1;
//    }
}
