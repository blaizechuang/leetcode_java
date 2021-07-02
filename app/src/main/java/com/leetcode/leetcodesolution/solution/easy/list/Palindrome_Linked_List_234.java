package com.leetcode.leetcodesolution.solution.easy.list;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Stack;

public class Palindrome_Linked_List_234 extends logger implements base_solution {
    @Override
    public void execute() {
        ListNode tmp = new ListNode(1);
        ListNode head = tmp;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(1);

        boolean isPalindrome = isPalindrome(head);


        Log.d("", "result: " + isPalindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Has odd number of elements, so skip the middle */
        if (fast != null) {
            slow = slow.next;
        }
        Log.d("", "Now slow: " + slow.val);

        while (slow != null) {
            int top = stack.pop().intValue();
            Log.d("", "top: " + top);
            if (top != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}
