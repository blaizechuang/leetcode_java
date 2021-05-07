package com.leetcode.leetcodesolution.solution.microsoft;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_traversal_102 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    public List<List<Integer>> levelOrder_blaize(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> parentNodes = new ArrayList<>();
        parentNodes.add(root);
        queue.offer(root);
        int level = 1;
        ArrayList<Integer> items = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            items.add(node.val);
            System.out.println("Add " + node.val + " to items, content: " + items);
            if (queue.isEmpty()) {
                System.out.println("Queue is empty, Add items to output");
                // 把子節點放進去
                output.add(new ArrayList<Integer>(items));
                System.out.println("Now output is " + output);
                items.clear();
                System.out.println("2 Now output is " + output);
                int parentNodeLength = parentNodes.size();
                List<TreeNode> tmp = new ArrayList<>();
                for (TreeNode child : parentNodes) {
                    if (child.left != null) {
                        queue.offer(child.left);
                        tmp.add(child.left);
                    }
                    if (child.right != null) {
                        queue.offer(child.right);
                        tmp.add(child.right);
                    }
                }
                parentNodes.clear();
                parentNodes.addAll(tmp);
            }
        }
        return output;
    }

    public List<List<Integer>> levelOrder_good(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            output.add(level);
        }
        return output;
    }
}
