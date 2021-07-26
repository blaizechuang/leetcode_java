package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import com.leetcode.leetcodesolution.solution.basic.ListNode;

public class Remove_Nth_Node_From_End_of_List_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 倒數第 n 個要 remove
        int nodes = 0;
        ListNode dummy = head;
        ListNode dummy2 = head;
        while (dummy != null) {
            nodes++;
            dummy = dummy.next;
        }

        if (n == nodes) {
            // 第一個
            return head.next;
        }

        int indexBeforeRemoved = nodes - n;
        int current = 0;
        ListNode tmp = null;
        while (dummy2 != null) {
            current++;
            if (current == indexBeforeRemoved) {
                if (current == nodes) {
                    dummy2.next = null;
                } else {
                    tmp = dummy2.next.next;
                    dummy2.next = tmp;
                }
                return head;
            }
            dummy2 = dummy2.next;
        }
        return null;
    }
}
