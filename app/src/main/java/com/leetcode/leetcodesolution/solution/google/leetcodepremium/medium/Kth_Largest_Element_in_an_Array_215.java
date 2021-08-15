package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_215 extends logger implements base_solution {

    public int findKthLargest_ascending(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
    /**
     * PriorityQueue solution
     * insert item need O(logk) complexity and the outer is a for loop O(n)
     * so the time complexity is O(nlogk)
     * But if sorted already, the time complexity is O(n)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }

        print("queue: " + queue);

        int value = 0;
        for (int i = 0; i < k; i++) {
            value = queue.poll();
            print("value: "+ value);
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
        int[] input = {3,2,1,5,6,4};
        int target = 2;
        int result = findKthLargest(input, target);
        print("-- result: " + result);
    }
}
