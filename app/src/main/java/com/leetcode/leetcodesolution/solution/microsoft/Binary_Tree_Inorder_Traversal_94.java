package com.leetcode.leetcodesolution.solution.microsoft;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal_94 extends logger implements base_solution {

    @Override
    public void execute() {

    }

    class Solution_iteratively {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while(root != null || !stack.isEmpty()) {
                while(root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;

            }
            return res;
        }
    }

    class Solution_good {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root != null) {
                list.addAll(inorderTraversal(root.left));
                list.add(root.val);
                list.addAll(inorderTraversal(root.right));
            }
            return list;
        }
    }

        class Solution_recursive {
            public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> output = new ArrayList();
                inOrder(root, output);
                return output;
            }

            private void inOrder(TreeNode node, List<Integer> output) {
                if (node == null) return;
                inOrder(node.left, output);
                output.add(node.val);
                inOrder(node.right, output);
            }
        }
}
