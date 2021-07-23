package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class threeSum_15 {
    /**
     * Time Complexity: O(n^2), Space Complexity: O(n)
     * 思路：一樣透過 HashMap 去記最後一個差值, 只是 index 的部分是記第一個 i 的 index
     * 這樣才有辦法去判斷是不是屬於這一個 run 的項目
     * 因為項目不可以重複, 所以使用 Set 的單一性去處理, 再因為是 List, 所以可以用 Collections.sort()
     * 排序後再加到 Set 裏面
     * 另一個重點是不需要再去運算相同值的項目, 所以把 nums[i] 存到一個 Set 裏面, 透過 Set 的 add 去判斷是否已存在
     * 這樣的方式我比較容易理解, 雖然最後出來的 runtime 是 249 ms, Orz
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        Set<Integer> dup = new HashSet();
        HashMap<Integer, Integer> seen = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (dup.add(nums[i])) {
                // 可以加表示還沒出現過
                for (int j = i+1; j < nums.length; j++) {
                    int target = -nums[i]-nums[j];
                    if (seen.containsKey(target) && seen.get(target) == i) {
                        List<Integer> tmpList = Arrays.asList(nums[i], nums[j], target);
                        Collections.sort(tmpList);
                        result.add(tmpList);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList(result);
    }
}
