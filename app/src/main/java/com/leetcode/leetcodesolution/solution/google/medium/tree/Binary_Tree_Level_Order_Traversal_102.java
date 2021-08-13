package com.leetcode.leetcodesolution.solution.google.medium.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102 {

    /**
     * time complexity: O(N)
     * space complexity: O(N)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        nodes.offer(root);
        while (nodes.peek() != null) {
            int size = nodes.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                level.add(node.val);
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
