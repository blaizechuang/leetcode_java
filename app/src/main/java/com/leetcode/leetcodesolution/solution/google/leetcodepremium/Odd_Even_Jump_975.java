package com.leetcode.leetcodesolution.solution.google.leetcodepremium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Map;
import java.util.TreeMap;

public class Odd_Even_Jump_975 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {10,13,12,14,15};
        int result = oddEvenJumps(input);
        print("-- result: " + result);

    }

    /**
     * Time complexity: O(nlogn), Space complexity: O(n)
     * 別人寫的, 暫時看不懂
     */
    public int oddEvenJumps(int[] A) {
        int n = A.length, res = 1;
        boolean[] higher = new boolean[n], lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        print("higher[" + (n-1) + "] = lower[" + (n-1) + "] = true");
        print("put (" + A[n-1] + "," + (n-1) + ")");
        for (int i = n - 2; i >= 0; --i) {
            print("-- now i: " + i);
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
            print("hi: " + hi + ", lo: " + lo);
            if (hi != null) {
                print("-- hi.getValue: " + hi.getValue());
                higher[i] = lower[(int) hi.getValue()];
                print("-- higher[" + i + "]: " + higher[i]);
            }
            if (lo != null) {
                print("-- lo.getValue: " + lo.getValue());
                lower[i] = higher[(int) lo.getValue()];
                print("-- lower[" + i + "]: " + lower[i]);
            }
            if (higher[i]) {
                res++;
                print("high[" + i + "] = true, res + 1 -> " + res);
            }
            map.put(A[i], i);
            print("-- put (" + A[i] + "," + i + ")");
        }
        return res;
    }
}
