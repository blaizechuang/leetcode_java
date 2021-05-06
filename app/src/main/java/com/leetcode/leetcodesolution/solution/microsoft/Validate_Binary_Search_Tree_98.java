package com.leetcode.leetcodesolution.solution.microsoft;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Validate_Binary_Search_Tree_98 extends logger implements base_solution{
    //----------------------------------------------------------------------------------------------
//    public boolean isValidBST(TreeNode root) {
//        return isValidSubTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean isValidSubTree(TreeNode root, long min, long max) {
//        if (root == null) return true;
//        if (root.val <= min) return false;
//        if (root.val >= max) return false;
//        return isValidSubTree(root.left, min, root.val) && isValidSubTree(root.right, root.val, max);
//    }
    //----------------------------------------------------------------------------------------------
    TreeNode last;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (last != null && last.val >= root.val) return false;
        last = root;
        return isValidBST(root.right);
    }

    @Override
    public void execute() {
    }
}
