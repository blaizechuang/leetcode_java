package com.leetcode.leetcodesolution.solution;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.basic.ListNode;

public class Reverse_Linked_List_206 extends logger implements base_solution {
    @Override
    public void execute() {
        ListNode dummy = new ListNode(1);
        ListNode head = dummy;
        dummy.next = new ListNode(2);
        dummy = dummy.next;
        dummy.next = new ListNode(3);
//        while (head != null) {
//            Log.d("--", "node is : " + head.val);
//            head = head.next;
//        }
        ListNode result = reverseList(head);
        while (result != null) {
            Log.d("--", "node is : " + result.val);
            result = result.next;
        }
    }

    /**
     * Recursive
     * 我還是不能習慣 recursive, 面試時如果可以避開儘量避開
     */
    public ListNode reverseList(ListNode head) {
        print("Call reverseList -> " + head.val);
        if (head == null || head.next == null) {
            print("return " + head.val);
            return head;
        }
        ListNode p = reverseList(head.next);
        print("Now p: " + p.val + ", head: " + head.val);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
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
