package com.leetcode.leetcodesolution.solution.easy.list;

import com.leetcode.leetcodesolution.solution.basic.ListNode;

public class Linked_List_Cycle_141 {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        boolean isCollision = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }


        return false;
    }
}
