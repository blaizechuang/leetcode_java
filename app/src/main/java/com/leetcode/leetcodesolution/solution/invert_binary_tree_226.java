package com.leetcode.leetcodesolution.solution;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

public class invert_binary_tree_226 extends logger implements base_solution{
    @Override
    public void execute() {

    }

    /**
     * time complexity: O(N)
     * space complexity: O(N)
     */
    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
