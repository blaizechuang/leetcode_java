package com.leetcode.leetcodesolution.solution.medium.list;

import com.leetcode.leetcodesolution.solution.basic.ListNode;

import java.util.Stack;

class Add_Two_Numbers_II_445 {

    /**
     * leetcode 神人的方法, 用 stack
     * time complexity: O(N)
     * space complextiy: O(N)
     */
    public ListNode addTwoNumbers_stack(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = list;
            list = head;
            sum /= 10;
        }

        return list.val == 0 ? list.next : list;
    }
    /**
     * time complexity: O(M+N)
     * space complexity: O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revertL1 = revert(l1);
        ListNode revertL2 = revert(l2);
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while (revertL1 != null || revertL2 != null) {
            int x = (revertL1 == null) ? 0 : revertL1.val;
            int y = (revertL2 == null) ? 0 : revertL2.val;
            int sum = x + y + carry;
            carry = sum > 9 ? 1 : 0;
            head.next = new ListNode(sum % 10);
            head = head.next;
            if (revertL1 != null) {
                revertL1 = revertL1.next;
            }
            if (revertL2 != null) {
                revertL2 = revertL2.next;
            }
        }
        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return revert(dummy.next);
    }

    private ListNode revert(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
