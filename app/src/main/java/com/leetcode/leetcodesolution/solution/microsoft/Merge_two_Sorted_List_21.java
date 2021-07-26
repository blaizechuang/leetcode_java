package com.leetcode.leetcodesolution.solution.microsoft;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Merge_two_Sorted_List_21 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     * 相較於 recursive, 我還是比較喜歡 iteratively (迭代)
     * 感覺比較直覺, 寫起來也順手
     * Time complexity O(m+n)
     * Space complexity O(1)
     */
    public ListNode mergeTwoLists_iteratively(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        }

        if (l2 != null) {
            dummy.next = l2;
        }

        return head.next;
    }

    /**
     * Recursive, 我不愛, 而且容易 stackoverflow
     */
    public ListNode mergeTwoLists_resur(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_resur(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_resur(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode tmpPointer = result;
        int l1Val, l2Val;
        if (l1 == null && l2 == null) return l1;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ListNode tmp = new ListNode(l2.val);
                System.out.println("tmp: " + tmp.val);
                result.next = tmp;
                l2 = l2.next;
            } else if (l2 == null) {
                ListNode tp2 = new ListNode(l1.val);
                System.out.println("tp2: " + tp2.val);
                result.next = tp2;
                l1 = l1.next;
            } else {
                ListNode tp3;
                if (l1.val < l2.val) {
                    tp3 = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    tp3 = new ListNode(l2.val);
                    l2 = l2.next;
                }
                result.next = tp3;
                System.out.println("tp3: " + tp3.val);
            }
            result = result.next;

        }
        return tmpPointer.next;
    }
}
