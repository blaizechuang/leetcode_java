package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;

public class Reverse_Integer_7 extends logger implements base_solution {
    @Override
    public void execute() {
        int x = 120;
        int result = reverse(x);
        print("result: " + result);
    }

    /**
     * 這個解法單純用 int, 重點就是要把 max / 10
     */
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        int res = 0;
        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < res) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return sign * res;
    }

    /**
     *
     * 下面自己想的解法代碼長, 而且很多 case 判斷, 而且題目有提到只能用 int, 所以不能當作解法
     */
    public int reverse_bad(int x) {
        if (x == 0) return 0;
        boolean positive = x > 0 ? true : false;
        int index = 0;
        x = Math.abs(x);
//        if (x < 0) {
//            x = x * -1;
//        }
        ArrayList<Integer> nums = new ArrayList();
        while (x / 10 > 0 || x % 10 > 0) {
            nums.add(x % 10);
            x = x / 10;
        }
        print("nums: " + nums);

        int size = nums.size();
        double result = 0;
        while (nums.size() > 0) {
            // 記得處理結尾是 0 的狀況, ex: 120
            if (result == 0 && nums.get(0) == 0) {
                nums.remove(0);
                continue;
            }
            result = result * 10;
            result += nums.get(0);
            if (result > Integer.MAX_VALUE) return 0;
            if (-result < Integer.MIN_VALUE) return 0;
            nums.remove(0);
        }

        return positive ? (int)result : (int)-result;
    }
}
