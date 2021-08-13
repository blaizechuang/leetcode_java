package com.leetcode.leetcodesolution.solution.google.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {

    /**
     * 這題的解法跟 #236 一樣
     * time complexity: O(N)
     * space complexity: O(N), worse case: skew tree, best case: O(h)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || q.val == root.val) return root;
        // method 1 run time: 4 ms
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
        // method 2 run time: 13 ms
//        if (root.val > p.val && root.val > q.val) {
//            return lowestCommonAncestor(root.left, p, q);
//        } else if (root.val < p.val && root.val < q.val) {
//            return lowestCommonAncestor(root.right, p , q);
//        }
//
//        return root;
    }
}
