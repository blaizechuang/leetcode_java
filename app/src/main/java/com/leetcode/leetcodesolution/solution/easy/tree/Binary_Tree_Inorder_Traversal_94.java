package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal_94 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /***
     * Solution 2
     */
    List<Integer> result = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        invertTree(root);
        return result;
    }

    public void invertTree(TreeNode root) {
        if (root == null) return;
        invertTree(root.left);
        result.add(root.val);
        invertTree(root.right);
    }

    /***
     * Solution 1
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root != null) {
//            res.addAll(inorderTraversal(root.left));
//            res.add(root.val);
//            res.addAll(inorderTraversal(root.right));
//        }
//        return res;
//    }
}
