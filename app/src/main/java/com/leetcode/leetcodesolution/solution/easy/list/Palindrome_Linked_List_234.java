package com.leetcode.leetcodesolution.solution.easy.list;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Palindrome_Linked_List_234 extends logger implements base_solution {
    @Override
    public void execute() {
        ListNode tmp = new ListNode(4);
        ListNode head = tmp;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(1);

        boolean isPalindrome = isPalindrome(head);


        Log.d("", "result: " + isPalindrome);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverse = reverseList(slow);
        while (reverse != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }

        return tail;
    }
}
