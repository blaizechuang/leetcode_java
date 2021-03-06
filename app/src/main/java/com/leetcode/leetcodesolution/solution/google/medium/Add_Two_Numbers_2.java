package com.leetcode.leetcodesolution.solution.google.medium;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Add_Two_Numbers_2 extends logger implements base_solution {
    @Override
    public void execute() {
        ListNode l1 = new ListNode(2);
        ListNode ptr1 = l1;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode ptr2 = l2;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(ptr1, ptr2);
        while (l3 != null) {
            Log.d("--", "node is : " + l3.val);
            l3 = l3.next;
        }
    }

    /**
     * Time complexity: O(max(m,n));
     * Space complexity: O(max(m, n)), 長度最長為 max(m, n) + 1
     * 最新的寫法, 我覺得這樣的寫法最直覺簡單, carry 的部分出回圈後再處理就好
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum > 9 ? 1 : 0;
            head.next = new ListNode(sum % 10);
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public ListNode addTwoNumbers_old(ListNode l1, ListNode l2) {
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
