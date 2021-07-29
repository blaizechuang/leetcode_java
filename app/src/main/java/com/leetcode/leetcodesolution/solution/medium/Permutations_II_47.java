package com.leetcode.leetcodesolution.solution.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II_47 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {1, 2, 2};
        List<List<Integer>> result = permuteUnique(input);
        print("result: " + result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    /**
     *
     * 我還是無法理解怎麼想到 !used[i-1], 這個除非一直去試不然試不出來
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        print("================ begin ===============");
        if (tempList.size() == nums.length) {
            print("Add subList: " + tempList);
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                print("now i: " + i);
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    print("continue");
                    continue;
                }
                used[i] = true;
                print("Add " + nums[i] + " to sublist");
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                print("Remove " + nums[tempList.size() - 1] + " to sublist");
                tempList.remove(tempList.size() - 1);
            }
        }
        print("================ end ===============");
    }
}
