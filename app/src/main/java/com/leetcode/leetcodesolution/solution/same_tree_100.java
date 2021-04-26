package com.leetcode.leetcodesolution.solution;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

public class same_tree_100 implements base_solution {
    @Override
    public void execute() {
        //
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean l = isSameTree(p.left, q.left);
        boolean r = isSameTree(p.right, q.right);
        if (l && r) {
            return true;
        }

        return false;
    }
}
