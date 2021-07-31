package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Count_of_Smaller_Numbers_After_Self_315 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {5,2,6,1};
        printIntList("source", input);
        List<Integer> result = countSmaller(input);
        print("result: " + result);
    }

    public List<Integer> countSmaller(int[] nums) {
        int len = (nums == null? 0 : nums.length);

        int[] idxs = new int[len];
        int[] count = new int[len];

        for (int i = 0; i < len; i++) idxs[i] = i;
        printIntList("idxs", idxs);

        mergeSort(nums, idxs, 0, len, count);
        print("After mergeSort");
        printIntList("nums: " , nums);
        printIntList("idx: ", idxs);
        printIntList("count: ", count);

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : count) list.add(i);

        return list;
    }

    private void mergeSort(int[] nums, int[] idxs, int start, int end, int[] count) {
        if (start + 1 >= end) return;

        int mid = (end - start) / 2 + start;
        mergeSort(nums, idxs, start, mid, count);
        mergeSort(nums, idxs, mid, end, count);

        merge(nums, idxs, start, end, count);
    }

    private void merge(int[] nums, int[] idxs, int start, int end, int[] count) {
        print("[merge] start: " + start + ", end: " + end);
        int mid = (end - start) / 2 + start;

        int[] tmp = new int[end - start];
        int[] tmpidx = new int[end - start];
        int i = start, j = mid, k = 0;
        print("mid: " + mid + ", j: " + j);

        while (k < end - start) {
            print("k: " + k + ", j: " + j + ", end: " + end + ", start: " + start + ", i: " + i);
            //  + ", nums[" + j + "]: " + nums[j] + ", nums[" + i + "]: " + nums[i]
            if (i < mid) {
                if (j < end && nums[j] < nums[i]) {
                    print("nums[" + j + "]: " + nums[j] + ", nums[" + i + "]: " + nums[i]);
                    tmpidx[k] = idxs[j];
                    tmp[k++] = nums[j++];
                } else {
                    count[idxs[i]] += j - mid; // add those already counted
                    tmpidx[k] = idxs[i];
                    tmp[k++] = nums[i++];
                }

            } else {
                tmpidx[k] = idxs[j];
                tmp[k++] = nums[j++];
            }
        }

        System.arraycopy(tmpidx, 0, idxs, start, end - start);
        System.arraycopy(tmp, 0, nums, start, end - start);
    }

}
