package com.leetcode.leetcodesolution.solution.google.easy;

class Reformat_The_String_1417 {
    /**
     * 我的方法, 不過 run time 太久了, 要 16 ms, 只贏 10% 的人
     */
    public String reformat(String s) {
        int digits = 0;
        int chars = 0;
        StringBuilder sbd = new StringBuilder();
        StringBuilder sbc = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                chars++;
                sbc.append(c);
            } else {
                digits++;
                sbd.append(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (Math.abs(chars - digits) == 1 || Math.abs(chars - digits) == 0) {
            if (chars >= digits) {
                for (int i = 0; i < digits; i++) {
                    sb.append(sbc.toString().charAt(i)).append(sbd.toString().charAt(i));
                }
                if (chars > digits) {
                    sb.append(sbc.toString().charAt(sbc.length()-1));
                }
            } else {
                for (int i = 0; i < chars; i++) {
                    sb.append(sbd.toString().charAt(i)).append(sbc.toString().charAt(i));
                }
                sb.append(sbd.toString().charAt(sbd.length()-1));

            }
            return sb.toString();
        }

        return "";
    }
}
