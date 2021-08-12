package com.leetcode.leetcodesolution.solution.medium.tree;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.LinkedList;
import java.util.Queue;

public class Check_Completeness_of_a_Binary_Tree_958 extends logger implements base_solution {
    @Override
    public void execute() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(5);
        boolean result = isCompleteTree(root);
        print("-- result: " + result);
    }

    /**
     * time complexity: O(N)
     * space complexity: O(N)
     * 思路：這題用 BFS 去解比較直覺, dfs 的方式我看不太懂
     * 不過即使是 bfs, 對我來說也不是很直覺可以想到的, 是看到解法後才知道
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        bfs.offer(root);
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();

    }
}
