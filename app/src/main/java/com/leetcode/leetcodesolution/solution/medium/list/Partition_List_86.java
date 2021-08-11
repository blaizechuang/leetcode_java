package com.leetcode.leetcodesolution.solution.medium.list;

import com.leetcode.leetcodesolution.solution.basic.ListNode;

class Partition_List_86 {

    /**
     * time complexity: O(N)
     * space complexity: O(1)
     */
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(-1);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = new ListNode(head.val);
                before = before.next;
            } else {
                after.next = new ListNode(head.val);
                after = after.next;
            }
            head = head.next;
        }

        before.next = afterHead.next;
        return beforeHead.next;
    }
}
