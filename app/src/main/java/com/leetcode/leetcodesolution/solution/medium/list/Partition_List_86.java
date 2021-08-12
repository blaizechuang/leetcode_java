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
//                before.next = new ListNode(head.val);
                before.next = head;
                before = before.next;
            } else {
//                after.next = new ListNode(head.val);
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        // 如果沒有 new 新的 node, 而直接使用 head node, 需要把 after.next 設為 null
        // 不然 after.next 會指向 original list's last node
        // 這樣的話下一行就會變成無窮迴圈

        before.next = afterHead.next;
        return beforeHead.next;
    }
}
