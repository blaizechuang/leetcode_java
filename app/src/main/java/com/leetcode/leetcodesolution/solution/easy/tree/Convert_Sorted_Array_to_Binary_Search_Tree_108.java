package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

    /**
     * 這題的重點在一個前提, 是 ascending 排序過的
     * 所以可以直接用 dfs 的方式去處理
     *
     * time complexity: O(N);
     * space complexity: O(N)
     */
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }

    private TreeNode dfs(int left, int right) {
        if (left > right) return null;
        int middle = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = dfs(left, middle - 1);
        root.right = dfs(middle + 1, right);
        return root;
    }
}
