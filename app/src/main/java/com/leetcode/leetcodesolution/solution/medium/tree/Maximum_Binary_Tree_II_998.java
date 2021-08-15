package com.leetcode.leetcodesolution.solution.medium.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Maximum_Binary_Tree_II_998 {

    /**
     * time complexity: O(N)
     * space complexity: O(N), because recursive
     *
     * 這題的陷阱在於題目有說新的 node 要 append, 所以遞迴要往 right 的方向去找
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root != null && root.val > val) {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }

        TreeNode node = new TreeNode(val);
        node.left = root;
        return node;
    }
}
