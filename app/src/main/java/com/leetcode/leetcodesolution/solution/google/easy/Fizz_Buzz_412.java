package com.leetcode.leetcodesolution.solution.google.easy;

import java.util.ArrayList;
import java.util.List;

class Fizz_Buzz_412 {

    /**
     * 這題是瞧不起人嗎
     */
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}