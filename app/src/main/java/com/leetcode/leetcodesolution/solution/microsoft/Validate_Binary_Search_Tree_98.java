package com.leetcode.leetcodesolution.solution.microsoft;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.TreeNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Validate_Binary_Search_Tree_98 extends logger implements base_solution{

    /**
     * 花花醬的方法，不要用 long
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * 下面這個是花花醬的解法, 我覺得超讚, 而且很好懂, 只是面試官可能會說可以不要用 long 嗎？
     * time complexity: O(N)
     * space complexity: O(h), h: 樹的高度
     */
//    public boolean isValidBST(TreeNode root) {
//        return isValidSubTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean isValidSubTree(TreeNode root, long min, long max) {
//        if (root == null) return true;
//        if (root.val <= min) return false;
//        if (root.val >= max) return false;
//        return isValidSubTree(root.left, min, root.val) && isValidSubTree(root.right, root.val, max);
//    }

    /**
     * 下面這個是中序的思路, valid bst 的規則是左子樹 < root < 右子樹
     * 所以可以看成我們每次都去跟前一個節點比較, 如果比前一個節點小表示不合法
     * 以左子樹為例, 一開始的 last 是 null, 然後第一個比較的 node 是 左子樹的 leaf, 所以不比較
     * 然後左子樹的 leaf 就變成 last, leaf 的 root 就變成現在的 root
     */
//    TreeNode last;
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        if (!isValidBST(root.left)) return false;
//        if (last != null && root.val <= last.val) return false;
//        last = root;
//        Log.d("", "current last is " + root.val);
//        return isValidBST(root.right);
//    }

    @Override
    public void execute() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean result = isValidBST(root);
        Log.d("", "is valid: " + result);

    }
}
