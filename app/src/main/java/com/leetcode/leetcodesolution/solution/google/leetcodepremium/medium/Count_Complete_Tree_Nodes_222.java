package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Count_Complete_Tree_Nodes_222 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     * 最直覺的方法, 不過不是題目要的, 因為題目說要小於 O(n)
     * Time complexity: O(n)
     * Space complexity: O(1) <-- 錯了, 不是這樣看的
     * Space complexity: O(d) => d = log, 樹的深度
     *
     * 因為是 complete binary tree, 所以可以用這種方式, 先找到左子樹的深, 在找到右子樹的深
     */
    int count = 0;
    public int countNodes＿blaize(TreeNode root) {
        if (root == null) return 0;

        count++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }

    // Return tree depth in O(d) time.
    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    ////////////////////////////////////////////////////////////////////////

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Return True if last level node idx exists.
    // Binary search with O(d) complexity.

    /**
     *
     * Leetcode 的 solution, 不過 binary search 這段有點看不懂
     */
    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        for(int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            }
            else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public int countNodes(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;

        int d = computeDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 1, right = (int)Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root)) left = pivot + 1;
            else right = pivot - 1;
        }

        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
        return (int)Math.pow(2, d) - 1 + left;
    }
}
