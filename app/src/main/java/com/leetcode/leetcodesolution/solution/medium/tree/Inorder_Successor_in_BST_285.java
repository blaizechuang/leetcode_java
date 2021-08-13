package com.leetcode.leetcodesolution.solution.medium.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Inorder_Successor_in_BST_285 {

    /**
     * leetcode 神人的解法, 我覺得比 recursive 直覺很多
     * time complexity: best: O(logN), worst: O(N)
     * space complexity: O(1)
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return succ;
    }
}
