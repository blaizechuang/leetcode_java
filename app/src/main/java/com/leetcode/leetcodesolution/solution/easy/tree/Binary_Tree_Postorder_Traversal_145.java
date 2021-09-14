package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Binary_Tree_Postorder_Traversal_145 {
    /**
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root.left, list);
        postOrder(root.right, list);
        return list;
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
