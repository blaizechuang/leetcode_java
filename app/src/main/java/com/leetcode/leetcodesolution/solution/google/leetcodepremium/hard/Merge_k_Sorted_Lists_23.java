package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Merge_k_Sorted_Lists_23 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     * 思路：看到這種 merge 的, 就是把他切成兩塊, 然後去 merge
     * 1. 設定 start = 0, end = length-1
     * 2. 實作 recursive partition (遞迴也要注意 左邊 < 右邊)
     * 3. 實作 merge
     *
     * time complexity: O(NlogK), merge: O(N), partition: O(logK)
     * space complexity: O(1)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length-1);
    }

    private ListNode partition(ListNode[] list, int left, int right) {
        if (left == right) return list[left];
        if (left < right) {
            int middle = left + (right - left)/2;
            ListNode leftNode = partition(list, left, middle);
            ListNode rightNode = partition(list, middle+1, right);
            return merge(leftNode, rightNode);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}
