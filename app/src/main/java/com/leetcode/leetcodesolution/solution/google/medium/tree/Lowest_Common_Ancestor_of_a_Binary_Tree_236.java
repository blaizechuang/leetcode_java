package com.leetcode.leetcodesolution.solution.google.medium.tree;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     * 這題跟 #235 一樣的解法
     * time complexity: O(N)
     * space complexity: O(N), worse case: skew tree, best case: O(h)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 只要有找到其中一個就表示另一個一定在他的下面, 所以不用繼續找可以直接 return
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
