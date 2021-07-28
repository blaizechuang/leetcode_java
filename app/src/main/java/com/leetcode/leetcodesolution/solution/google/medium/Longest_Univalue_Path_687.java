package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Longest_Univalue_Path_687 extends logger implements base_solution {
    @Override
    public void execute() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        int value = longestUnivaluePath(root);
        print("value: " + value);
    }

    int max = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        maxPath(root, root.val);
        return max;
    }

    private int maxPath(TreeNode node, int val) {
        if (node == null) return 0;
        int left = maxPath(node.left, node.val);
        print("left: " + left);
        int right = maxPath(node.right, node.val);
        print("right: " + right);
        max = Math.max(max, left + right);
        print("max: " + max + ", val: " + val + ", node.val: " + node.val);
        if (val == node.val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
