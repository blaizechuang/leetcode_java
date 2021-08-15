package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

class License_Key_Formatting_482 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     * 這題的陷阱是, 只有第一個欄位的字串長可以 < k, 所以只能用 revert 了
     * 不要用 insert, 用 append, 然後再用 builder.reverse() 去反轉字串
     * 另外不要用 string.toUpperCase(), 因為會比較慢, 原因是他還會需要去考慮 language code,
     * 改用 Character.toUpperCase(); 因為他只會去考慮 ascii code
     */
    public String licenseKeyFormatting_good(String s, int k) {
        StringBuilder builder = new StringBuilder();
        String str = "";
        str.toUpperCase();
        int subLength = 0;
        for (int i = s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (subLength == k) {
                    builder.append('-');
                    builder.append(Character.toUpperCase(c));
                    subLength = 1;
                } else {
                    subLength++;
                    builder.append(Character.toUpperCase(c));
                }
            } else {
                continue;
            }
        }
        return builder.reverse().toString();
    }

    /**
     * My method, runtime: 68 ms, memory: 39.2 MB
     */
    public String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        StringBuilder builder = new StringBuilder();
        int subLength = 0;
        for (int i = s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c != '-') {
                if (subLength == k) {
                    builder.insert(0, '-');
                    builder.insert(0, c);
                    subLength = 1;
                } else {
                    subLength++;
                    builder.insert(0, c);
                }
            } else {
                continue;
            }
        }
        return builder.toString();
    }
}
