package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Count_and_Say_38 extends logger implements base_solution {
    @Override
    public void execute() {
        int n = 4;
        String result = countAndSay(n);
        print("result: " + result);
    }

    /**
     * 思路：手寫出 n = 4 的 case, 其實就差不多知道只能是 O(n^2), 接下來就是細心了
     */
    public String countAndSay(int n) {
        if (n == 0) return "";
        if (n == 1) return "1";
        String str = "1";

        while (n > 0) {
            print("-- n: " + n);
            StringBuffer sb = new StringBuffer();
            char current = str.charAt(0);
            print("current: " + current);
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                print("-- charAt i: " + str.charAt(i));
                if (str.charAt(i) == current) {
                    count++;
                    print("-- count++: " + count);

                } else {
                    sb.append(count).append(current);
                    current = str.charAt(i);
                    count = 1;
                    print("-- current: " + current + ", sb: " + sb.toString());
                }
            }
            if (count > 0) {
                sb.append(count).append(current);
                print("---- count > 0, sb: " + sb.toString());
            }
            str = sb.toString();
            print("-- str: " + str);
            n--;
        }

        return str;
    }
}
