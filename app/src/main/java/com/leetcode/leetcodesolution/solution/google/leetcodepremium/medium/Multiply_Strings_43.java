package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Multiply_Strings_43 extends logger implements base_solution {
    @Override
    public void execute() {
        String s1 = "9";
        String s2 = "9";
        String result = multiply(s1, s2);
        print("-- result: " + result);
    }

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
        for (int i = len1-1; i>=0; i--) {
            for (int j = len2-1; j >= 0; j--) {
                print("num1.charAt(" + i + ") = " + num1.charAt(i) + ", num2.charAt(" + j + ") = " + num2.charAt(j));
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                print("-- i: " + i + ", j: " + j + ", mul: " + mul);
                int left = i+j;
                int right = i+j+1;
                int sum = mul + result[right];
                print("-- left: " + left + ", right: " + right);
                print("-- pos[" + right + "] = " + result[right] + ",sum: " + sum);

                result[left] += sum / 10;
                result[right] = sum % 10;
                print("-- result[" + left + "] = " + result[left]);
                print("-- result[" + right + "] = " + result[right]);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < result.length; k++) {
            print("-- value: " + result[k]);
            if (!(builder.length() == 0 && result[k] == 0)) {
                builder.append(result[k]);
            }
        }
        if (builder.length() == 0) return "0";
        return builder.toString();
    }

    /**
     * 這個不知道邏輯根本不會寫, 這題的重點是這一行 pos[p1] += sum / 10;
     * 因為左邊的位置有可能是上一回算出的進位, 所以要把算出來的 sum 加上上一回的值
     * 另外 ASCII 的數字要轉成 int 只需要去 - '0' 就可以了
     *
     * test case:
     * 1. 其中一個是 0 <-- 在寫的當下沒有想到, 雖然後面的結果是正確的
     * runtime: 3 ms
     *
     */
    public String multiply_solution(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                print("num1.charAt(" + i + ") = " + num1.charAt(i) + ", num2.charAt(" + j + ") = " + num2.charAt(j));
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                print("-- i: " + i + ", j: " + j + ", mul: " + mul);
                int p1 = i + j, p2 = i + j + 1;
                print("-- p1: " + p1 + ", p2: " + p2);
                int sum = mul + pos[p2];    // 加上前一組的進位, 因為這次的 j 是 ++ 過的, 所以要拿上一個, 有點迂迴的邏輯
                print("-- pos[" + p2 + "] = " + pos[p2] + ",sum: " + sum);

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
                print("-- pos[" + p1 + "] = " + pos[p1]);
                print("-- pos[" + p2 + "] = " + pos[p2]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
