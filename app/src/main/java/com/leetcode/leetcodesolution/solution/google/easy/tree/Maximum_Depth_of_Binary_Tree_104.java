package com.leetcode.leetcodesolution.solution.google.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Maximum_Depth_of_Binary_Tree_104 {

    /**
     * time complexity: O(N)
     * space complexity: best O(logN), worst O(N) skew tree
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
