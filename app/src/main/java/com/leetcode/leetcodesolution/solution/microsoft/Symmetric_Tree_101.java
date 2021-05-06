package com.leetcode.leetcodesolution.solution.microsoft;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric_Tree_101 {
    // recursive -----------------------------------------------------------------------------------
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    //----------------------------------------------------------------------------------------------
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        return true;
    }

}
