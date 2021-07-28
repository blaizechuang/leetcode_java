package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Diameter_of_Binary_Tree_543 extends logger implements base_solution {
    @Override
    public void execute() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        int path = diameterOfBinaryTree(root);
        print("path: " + path);
    }

    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxPath;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int left = maxDepth(node.left);
        print("left: " + left);
        int right = maxDepth(node.right);
        print("right: " + right);
        maxPath = Math.max(maxPath, left + right);
        print("maxPath: " + maxPath);
        return Math.max(left, right) + 1;
    }
}
