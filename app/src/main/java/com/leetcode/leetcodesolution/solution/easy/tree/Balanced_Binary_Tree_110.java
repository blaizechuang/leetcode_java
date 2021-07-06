package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

class Balanced_Binary_Tree_110 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        calcHeight(root);
        return isBalanced;
    }

    private int calcHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) isBalanced = false;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
