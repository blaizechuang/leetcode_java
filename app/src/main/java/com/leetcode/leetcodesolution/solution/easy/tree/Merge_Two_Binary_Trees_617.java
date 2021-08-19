package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Merge_Two_Binary_Trees_617 {

    /**
     * time complexity: O(m), m: min of the nodes in two trees
     * space complexity: worst, : O(m), best: O(logm)
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
