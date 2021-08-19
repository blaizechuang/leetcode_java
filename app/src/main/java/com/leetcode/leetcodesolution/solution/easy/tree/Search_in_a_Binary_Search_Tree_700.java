package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Search_in_a_Binary_Search_Tree_700 {

    /**
     * recursive
     * time complexity: best: O(logN), worst, O(N)
     * space complexity: O(N)
     */
    public TreeNode searchBST_recursive(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val < val) {
            return searchBST_recursive(root.right, val);
        } else {
            return searchBST_recursive(root.left, val);
        }
    }

    /**
     * My solution [iterative]
     * time complexity: O(logN);
     * space complexity: O(1)
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val) {
                return node;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return null;
    }
}
