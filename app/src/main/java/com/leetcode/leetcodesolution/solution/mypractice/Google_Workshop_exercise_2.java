package com.leetcode.leetcodesolution.solution.mypractice;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Google_Workshop_exercise_2 extends logger implements base_solution {
    @Override
    public void execute() {
        ArrayList<Integer> input = new ArrayList();
        input.add(0);
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        List<Integer> result = rearrangeList(input);
        for (Integer item : result) {
            Log.d("--", "item: " + item);
        }
    }

    List<Integer> rearrangeList(ArrayList<Integer> input) {
        List<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < input.size(); i++) {
            if (i % 2 == 0) {
                // even
                list.add(input.get(i));
            } else {
                // odd
                stack.push(input.get(i));
            }
        }

        while (!stack.isEmpty()) {
            list.add(stack
            .pop());
        }
        return list;

    }
}
