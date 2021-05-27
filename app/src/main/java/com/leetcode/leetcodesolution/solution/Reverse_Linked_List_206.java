package com.leetcode.leetcodesolution.solution;

import com.leetcode.leetcodesolution.solution.basic.ListNode;

public class Reverse_Linked_List_206 extends logger implements base_solution {
    @Override
    public void execute() {

    }

    public ListNode reverseList_base(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;

        }
        head = pre;
        return head;
    }

    public ListNode reverseList_good(ListNode head) {
        // 上下差不多
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head = pre;
        return head;
    }
}
