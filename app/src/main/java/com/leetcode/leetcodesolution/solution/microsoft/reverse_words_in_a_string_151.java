package com.leetcode.leetcodesolution.solution.microsoft;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.List;

public class reverse_words_in_a_string_151 extends logger implements base_solution {
    @Override
    public void execute() {
        String source = "the sky is blue";
        String result = reverseWords(source);
        Log.d("--", "result: " + result);
    }

    // My solution
//    public String reverseWords(String s) {
//        List<String> stringList = new ArrayList();
//        String trimmed = s.trim();
//        int spaceIndex = trimmed.indexOf(" ");
//        while (spaceIndex > 0) {
//            String tmp = trimmed.substring(0, spaceIndex);
//            stringList.add(tmp);
//            trimmed = trimmed.substring(spaceIndex);
//            trimmed = trimmed.trim();
//            spaceIndex = trimmed.indexOf(" ");
//        }
//
//        stringList.add(trimmed);
//
//        String result = "";
//        for (int i = stringList.size() - 1; i >= 0; i--) {
//            result += stringList.get(i);
//            if (i != 0) {
//                result += " ";
//            }
//        }
//        return result;
//    }

    public String reverseWords(String s) {
        String result = "";
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Log.d("--", "current i: " + i + ", now char: " + s.charAt(i));
            char c = s.charAt(i);
            if (s.charAt(i) != ' ') {
                j = i;
                i = s.lastIndexOf(" ", j);
                Log.d("--", " end: " + j + " start: " + i);
                String tmp = s.substring(i+1, j+1) + " ";
                Log.d("--", "sub string: " + tmp);
                result += tmp;
                Log.d("--", "Update i: " + i);
            }
        }

        return result.trim();
    }
}
