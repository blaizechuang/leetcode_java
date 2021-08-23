package com.leetcode.leetcodesolution.solution.medium.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Delete_Node_in_a_BST_450 {

    /**
     * time complexity: O(logH)
     * space complexity: O(H)
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode min = getMinNode(root.right);
                System.out.println("min val: " + min.val);
                root.val = min.val;
                // 下面這一行我覺得不那麼直覺, 應該是我們是從右子樹去拿到 min
                // 所以我們要去更新右子樹的內容
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    private TreeNode getMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
