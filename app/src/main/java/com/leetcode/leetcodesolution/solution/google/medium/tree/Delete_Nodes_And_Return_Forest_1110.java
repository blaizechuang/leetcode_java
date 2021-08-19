package com.leetcode.leetcodesolution.solution.google.medium.tree;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delete_Nodes_And_Return_Forest_1110 extends logger implements base_solution {
    @Override
    public void execute() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] deletes = {3, 5};
        List<TreeNode> list = delNodes(root, deletes);
        for (TreeNode item : list) {
            print("-- " + item.val);
        }
    }

    Set<Integer> to_delete_set;
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_delete_set = new HashSet<>();
        res = new ArrayList<>();
        for (int i : to_delete)
            to_delete_set.add(i);
        helper(root, true);
        return res;
    }

    private TreeNode helper(TreeNode node, boolean is_root) {
        if (node == null) {
            print("-- node is null, isRoot: " + is_root);
        } else {
            print("-- now checking " + node.val + ", isRoot: " + is_root);
        }
        if (node == null) return null;
        boolean deleted = to_delete_set.contains(node.val);
        if (is_root && !deleted) {
            print("-- add node: " + node.val);
            res.add(node);
        }
        node.left = helper(node.left, deleted);
        node.right =  helper(node.right, deleted);
        return deleted ? null : node;
    }
}
