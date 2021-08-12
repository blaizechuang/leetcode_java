package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_of_Binary_Tree_111 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     * bfs 的解法, 比較直覺, 我愛 bfs
     * time complexity: O(N)
     * space complexity: O(N)
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (queue.peek() != null) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;   // 因為是求最小高度, 如果是求最大高度, 就改成 continue
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }

    public int minDepth_dfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int dep = Integer.MAX_VALUE;
        if (root.left != null) {
            dep = Math.min(dep, minDepth_dfs(root.left));
        }

        if (root.right != null) {
            dep = Math.min(dep, minDepth_dfs(root.right));
        }

        return dep + 1;
    }
}
