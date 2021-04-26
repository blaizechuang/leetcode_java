package com.leetcode.leetcodesolution.solution;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

public class invert_binary_tree_226 extends logger implements base_solution{
    @Override
    public void execute() {

    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
