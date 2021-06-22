package com.leetcode.leetcodesolution.solution.medium.tree;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II_95 extends logger implements base_solution {
    @Override
    public void execute() {
        int input = 3;
        List<TreeNode> result = generateTrees(input);
    }

    /**
     * DP solution
     * 思路：
     * 後面的 n 一定是前面的 n 的總和, 所以就會想到 dp
     * 所以等於是查找 1 ~ n 然後再把結果列出來, 因為是樹, 所以可以分成兩段,
     * 左 -> root - 1, root, root + 1 -> 右
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (l > r) {
            res.add(null);
            return res;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTree = generateTrees(l, i - 1);
            List<TreeNode> rightTree = generateTrees(i+1, r);
            for (TreeNode l_node : leftTree) {
                for (TreeNode r_node : rightTree) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = l_node;
                    tmp.right = r_node;
                    res.add(tmp);
                }
            }
        }

        return res;
    }
}
