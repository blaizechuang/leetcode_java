package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Path_Sum_112 {

    /**
     * time complexity: O(N), N: node count
     * space complexity: worst case: O(N) => skew tree, best case: O(logN) => complete binary tree
     * 思路：root, left, right 都要去找, 因為是從 root 往下, 所以只要子樹有一邊符合就算找到
     * 1. 先確認 root 不存在的 case
     * 2. 扣掉 root's value, 如果左右子樹都沒有節點, 只有 sum == 0 才算正確
     * 3. [2] 不成立的話, 個別找 left, right 子樹是否符合
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
