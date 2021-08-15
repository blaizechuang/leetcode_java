package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

class Balanced_Binary_Tree_110 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     *
     * 不新增一個 variable 的情況, 用 return -1 去解, 但是我覺得不直觀, 接手的人會混淆
     */
    public boolean isBalanced(TreeNode root) {
        return calcHeight(root) != -1;
    }

    private int calcHeight(TreeNode node) {
        if (node == null) return 0;
        int left = calcHeight(node.left);
        if (left == -1) return -1;
        int right = calcHeight(node.right);
        if (right == -1) return -1;

        // check if balance
        if (Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    /**
     * time complexity: O(N),
     * space complexity: worst: O(N), best: O(logN)
     */
//    boolean isBalanced = true;
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        calcHeight(root);
//        return isBalanced;
//    }
//
//    private int calcHeight(TreeNode root) {
//        if (root == null) return 0;
//        int leftHeight = calcHeight(root.left);
//        int rightHeight = calcHeight(root.right);
//        if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;
//        return Math.max(leftHeight, rightHeight) + 1;
//    }
}
