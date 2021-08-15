package com.leetcode.leetcodesolution.solution.google.easy.backtracking;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Binary_Tree_Paths_257 {

    /**
     * time complexity: O(N), 因為每個節點都要拜訪一次，所以應該是 O(N)
     * space complexity: O(d + n), 所以應該是 O(N)
     *
     * 這題的重點在於 setLength 這邊的處理，什麼時候要取長度, 什麼時候要減
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        buildPath(root, result, sb);
        return result;
    }

    private void buildPath(TreeNode node, List<String> result, StringBuilder sb){
        if (node == null) return;

        if (node.left == null && node.right == null) {
            sb.append(node.val);
            result.add(sb.toString());
        } else {
            sb.append(node.val);
            sb.append("->");
            int len = sb.length();
            buildPath(node.left, result, sb);
            sb.setLength(len);
            buildPath(node.right, result, sb);
            sb.setLength(len);
        }
    }
}
