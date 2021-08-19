package com.leetcode.leetcodesolution.solution.google.medium.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Insert_into_a_Binary_Search_Tree_701 {

    /**
     * time complexity: O(logN)
     * space complexity: O(1)
     */
    public TreeNode insertIntoBST_iteration(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            if (node.val < val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                }
                node = node.left;
            }
        }
        return new TreeNode(val);
    }

    /**
     * recursive
     * time complexity: O(logN) ~ O(N)
     * space complexity: O(N)
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
