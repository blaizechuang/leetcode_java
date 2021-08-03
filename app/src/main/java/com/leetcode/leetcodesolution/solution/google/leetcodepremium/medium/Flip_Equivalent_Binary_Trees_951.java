package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Flip_Equivalent_Binary_Trees_951 extends logger implements base_solution {
    @Override
    public void execute() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right.left = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        boolean result = flipEquiv(root1, root2);
        print("-- result: " + result);
    }

    /**
     * time complexity:
     * 需要檢查左右子樹,
     * (Left node of tree 1 == left node of tree 2 && right node of tree 1 == right node of tree 2)
     * (Left node of tree1 == right node of tree2 && right node of tree1 == left node of tree2)
     * 因為有兩個狀況, 且為左右子樹, 比較的次數看深度, 所以是 O((2 x 2)^log(N)) == O(2 x log(N)^2) == O(N^2)
     * https://leetcode.com/problems/flip-equivalent-binary-trees/discuss/200514/JavaPython-3-DFS-3-liners-and-BFS-with-explanation-time-and-space%3A-O(n).
     *
     * space complexity: O(h) 高度, worst case: O(n), skew tree
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return isEqual(root1, root2);
    }

    private boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        print("root1 val: " + root1.val + ", root2 val: " + root2.val);
        if (root1.val != root2.val) {
            print("return false");
            return false;
        }
        print("-- keep tracking children");

        return (isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right)) || (isEqual(root1.left, root2.right) && isEqual(root1.right, root2.left));
    }
}
