package com.leetcode.leetcodesolution.solution.easy.tree;

import com.leetcode.leetcodesolution.solution.basic.TreeNode;

class Subtree_of_Another_Tree_572 {

    /**
     * Recursive method
     */
    StringBuilder spre = new StringBuilder();
    StringBuilder tpre = new StringBuilder();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        preOrder(s, spre.append(","));  // 加這個為了避免 [12], [2] 這個 case, 因為會誤認 12 contains 2
        preOrder(t, tpre.append(","));
        return spre.toString().contains(tpre.toString());
    }
    public void preOrder(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#,");
            return;
        }
        str.append(root.val).append(",");
        preOrder(root.left, str);
        preOrder(root.right, str);
    }
    /**
     * Preorder traversal
     * time complexity: O(N) or O(NM)
     */
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         String preOrderRoot = getPreOrderString(root);
//         String preOrderSubRoot = getPreOrderString(subRoot);
//         System.out.println("root: " + preOrderRoot);
//         System.out.println("subRoot: " + preOrderSubRoot);
//         return preOrderRoot.contains(preOrderSubRoot);
//     }

//     private String getPreOrderString(TreeNode node) {
//         StringBuilder sb = new StringBuilder();
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(node);
//         while (!stack.isEmpty()) {
//             TreeNode cur = stack.pop();
//             if (cur == null) {
//                 sb.append(",#");
//             } else {
//                 sb.append(",").append(cur.val);
//             }
//             if (cur != null) {
//                 stack.push(cur.right);
//                 stack.push(cur.left);
//             }
//         }
//         return sb.toString();
//     }
}
