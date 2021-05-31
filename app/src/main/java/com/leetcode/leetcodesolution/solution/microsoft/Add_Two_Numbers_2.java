package com.leetcode.leetcodesolution.solution.microsoft;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Add_Two_Numbers_2 extends logger implements base_solution {
    @Override
    public void execute() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);
        ListNode l3 = addTwoNumbers(l1, l2);
        Log.d("--", "l3 val: " + l3.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode result = l3;
        int value = 0, carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1!= null) {
                value += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }

            value += carry;
            if (value >= 10) {
                value -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode tmp = new ListNode(value);
            l3.next = tmp;
            l3 = l3.next;
            value = 0;
        }

        return result.next;
    }

    // Forced solution
    public ListNode addTwoNumbers_bad(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode result = l3;
        if (l1 == null || l2 == null) {
            return l3;
        }

        int carry = 0;
        int sum = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum/10 != 0) {
                carry = 1;
            } else {
                carry = 0;
            }
            System.out.println("-- 1 carry: " + carry);
            l3.next = new ListNode(sum%10);
            String str = "Add " + sum%10 + " to l3";
            System.out.println(str);
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
            System.out.println("Now l3 is " + l3.val);

        }

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                System.out.println("-- l1 carry: " + carry);
                sum = l1.val + carry;
                if (sum/10 != 0) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = l2.val + carry;
                if (sum/10 != 0) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                l2 = l2.next;
            }
            System.out.println("-2 Add " + sum%10 + " to l3");
            l3.next = new ListNode(sum%10);
            l3 = l3.next;
        }

        if (carry == 1) {
            l3.next = new ListNode(1);
            l3 = l3.next;
        }

        return result.next;
    }
}
