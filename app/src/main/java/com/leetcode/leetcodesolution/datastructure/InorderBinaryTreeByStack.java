package com.leetcode.leetcodesolution.datastructure;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderBinaryTreeByStack extends logger implements base_solution {

    Stack<TreeNode> stack = new Stack();
    Stack<TreeNode> result = new Stack();
    @Override
    public void execute() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> result = inorderTree(root);
        for (Integer item : result) {
            Log.d("--", "item: " + item);
        }
    }

    public List<Integer> inorderTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
