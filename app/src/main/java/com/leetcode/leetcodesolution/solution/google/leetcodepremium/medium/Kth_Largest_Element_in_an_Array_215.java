package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_215 extends logger implements base_solution {

    /**
     * PriorityQueue solution
     * insert item need O(logn) complexity and the outer is a for loop O(n)
     * so the time complexity is O(nlogn)
     * But if sorted already, the time complexity is O(n)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        int value = 0;
        for (int i = 0; i < k; i++) {
            value = queue.poll();
        }
        return value;
    }
    /**
     * TimeComplexity: O(nlogn)
     */
    public int findKthLargest_sort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    @Override
    public void execute() {
        int[] input = {1,2,3,4,5};
        int target = 2;
        int result = findKthLargest(input, target);
        print("-- result: " + result);
    }
}
