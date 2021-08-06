package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Swap_Adjacent_in_LR_String_777 extends logger implements base_solution {
    @Override
    public void execute() {
//        String start = "RXXLRXRXL";
//        String end = "XRLXXRRLX";
//        String start = "RXR";
//        String end = "XXR";
        String start = "LR";
        String end = "RL";
        boolean result = canTransform(start, end);
        print("-- rsult: " + result);
    }

    /**
     * 這題題目有陷阱, start 中的 R 不能比 end 中的 R 大, start 中的 L 不能比 end 中的 L 小
     */
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        if (start.length() != end.length()) return false;
        int indexS = 0, indexE = 0;
        while (indexS < start.length() && indexE < end.length()) {
            while (start.charAt(indexS) == 'X') {
                indexS++;
            }

            while (end.charAt(indexE) == 'X') {
                indexE++;
            }
            print("indexS: " + indexS + ", indexE: " + indexE);

            if (indexS == start.length() && indexE == end.length()) {
                print("-- true 1");
                return true;
            }
            if (indexS == start.length() || indexE == end.length()) {
                print("-- false 1");
                return false;
            }
            if (start.charAt(indexS) != end.charAt(indexE)) {
                print("-- false 2");
                return false;
            }
            if (start.charAt(indexS) == 'R' && indexS > indexE) {
                print("-- false 3");
                return false;
            }
            if (start.charAt(indexS) == 'L' && indexS < indexE) {
                print("-- false 4");
                return false;
            }
            indexS++;
            indexE++;
        }

        print("-- true 2");
        return true;
    }
}
