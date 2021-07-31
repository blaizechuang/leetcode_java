package com.leetcode.leetcodesolution.solution.easy;

class Valid_Palindrome_125 {

    /**
     * 別人的方法, 不過跟我的差不多
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            while (start <= end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (start <= end && !Character.isLetterOrDigit(s.charAt(end))) end--;
            if (start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 我的方法, 但是超時了, 把 String.toLowerCase() 改成 Character.toLowerCase(s.charAt(i)) 就可以了
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public boolean isPalindrome_blaize(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
//            char c = s.toLowerCase().charAt(i);   // 這段會超時
            char c = Character.toLowerCase(s.charAt(i));
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
