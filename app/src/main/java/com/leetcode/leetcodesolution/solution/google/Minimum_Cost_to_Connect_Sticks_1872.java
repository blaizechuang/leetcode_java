package com.leetcode.leetcodesolution.solution.google;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Minimum_Cost_to_Connect_Sticks_1872 extends logger implements base_solution {
    @Override
    public void execute() {
        List<Integer> input = Arrays.asList(1,8,3,5);
        int result = MinimumCost(input);
        Log.d("--", "result = " + result);
    }

    public int MinimumCost(List<Integer> sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int item : sticks) {
            queue.offer(item);
        }

        int sum = 0;
        while (queue.size() > 1) {
            int cost = queue.poll() + queue.poll();
            sum += cost;
            queue.offer(cost);
        }

        return sum;
    }
}
