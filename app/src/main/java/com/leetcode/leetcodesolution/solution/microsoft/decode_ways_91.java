package com.leetcode.leetcodesolution.solution.microsoft;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class decode_ways_91 extends logger implements base_solution {
    @Override
    public void execute() {
        String str = "123123";
        Log.d("--", "Raw: " + str);
        int result = numDecodings1(str);
        Log.d("--", "Count: " + result);
    }

    public int numDecodings1(String s) {
        if (s.length() == 0) return 0;
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        if (s.charAt(0) > '0') {
            count[1] = 1;
        }

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) > '0') {
                count[i] = count[i-1];
            }
            if (Integer.parseInt(s.substring(i-2, i)) <= 26 && s.charAt(i-2) != '0') {
                count[i] += count[i-2];
            }
        }

        return count[s.length()];
    }

    public int numDecodings2(String s) {
        if(s.length() ==0) return 0;
        int[] count = new int[s.length()+1];      //count[i]記錄從開始到i-1點有count[i]中可能的編碼方式
        count[0]=1;
        if(s.charAt(0)>'0')
            count[1]=1;
        for(int i=2;i<=s.length();i++){
            if(s.charAt(i-1)>='1')
                count[i] = count[i-1];
            int sum = Integer.parseInt(s.substring(i-2,i));
            if(sum <=26 && s.charAt(i-2)!='0' )
                count[i] += count[i-2];
        }
        return count[s.length()];
    }
}
