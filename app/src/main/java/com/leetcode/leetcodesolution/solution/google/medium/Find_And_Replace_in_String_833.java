package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;

public class Find_And_Replace_in_String_833 extends logger implements base_solution {
    @Override
    public void execute() {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"}, targets = {"eee", "ffff"};
        String result = findReplaceString(s, indices, sources, targets);
        print("result: " + result);
    }

    /**
     * I think the time complexity: O(N), space complexity: O(N)
     * 思路, 有很多 arrays, 所以會需要知道是哪個 index, 加上需要一個一個查找，所以有兩種方式
     * 一種是 HashMap<key, value>, key is indeces[i], value is index
     * 或是用一個 int [] 去存, 用 int array 存的好處是, 就等於是由小到大排列, 不需要再去做 sort
     * 所以要去判斷目前這個 index 是不是需要轉換只需要去找 matches[i] != -1 就找到
     * 至於要另外去找 其他兩個 array 的值只需要帶入 sources[matches[i]], targets[matches[i]]
     * 我突然遇到這樣的題目一定想不到，佩服想到的人
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] matches = new int[n];
        Arrays.fill(matches, -1);
        for (int i = 0; i < indices.length; i++) {
            if (s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])) {
                matches[indices[i]] = i;
            }
        }
        printIntList("matches", matches);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n;) {
            if (matches[i] != -1) {
                sb.append(targets[matches[i]]);
                i += sources[matches[i]].length();
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
