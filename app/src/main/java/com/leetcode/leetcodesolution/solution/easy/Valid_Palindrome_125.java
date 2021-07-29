package com.leetcode.leetcodesolution.solution.easy;

class Valid_Palindrome_125 {

    /**
     * 我的方法, 但是超時了
     */
    public boolean isPalindrome_blaize(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.toLowerCase().charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                sb.append(c);
            }
        }
        String string = sb.toString();
        int start = 0, end = string.length() - 1;
        while (start <= end) {
            if (string.charAt(start) == string.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
