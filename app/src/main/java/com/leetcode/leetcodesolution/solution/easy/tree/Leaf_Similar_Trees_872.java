package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Leaf_Similar_Trees_872 {

    /**
     * time complexity: O(M + N), 因為 M, N 是節點數, 所以要寫成 O(max(M, N)) 也行
     * space complexity: O(M + N)
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<Integer>();
        List<Integer> leaf2 = new ArrayList<Integer>();
        collectLeaves(root1, leaf1);
        collectLeaves(root2, leaf2);
        return leaf1.equals(leaf2);
//         if (leaf1.size() != leaf2.size()) return false;
//         for (int i = 0; i < leaf1.size(); i++) {
//             if (leaf1.get(i) != leaf2.get(i)) {
//                 return false;
//             }
//         }

//         return true;
    }

    private void collectLeaves(TreeNode node, List<Integer> list) {
        if (node == null) return ;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        collectLeaves(node.left, list);
        collectLeaves(node.right, list);
    }
}
