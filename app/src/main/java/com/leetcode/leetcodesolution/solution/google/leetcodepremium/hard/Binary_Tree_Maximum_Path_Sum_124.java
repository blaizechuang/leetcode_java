package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Binary_Tree_Maximum_Path_Sum_124 extends logger implements base_solution {
    @Override
    public void execute() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int result = maxPathSum(root);
        print("result: " + result);
    }

    int maxValue;

    // 543 687
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) {
            print("return");
            return 0;
        }
        int left = Math.max(0, maxPathDown(node.left));
        print("left: " + left);
        int right = Math.max(0, maxPathDown(node.right));
        print("right: " + right);
        maxValue = Math.max(maxValue, left + right + node.val);
        print("maxValue: " + maxValue);
        return Math.max(left, right) + node.val;
    }
}
