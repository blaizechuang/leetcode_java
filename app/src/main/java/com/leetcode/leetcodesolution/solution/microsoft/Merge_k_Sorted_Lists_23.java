package com.leetcode.leetcodesolution.solution.microsoft;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists_23 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                if (listNode.val < t1.val) return -1;
                else if (listNode.val == t1.val) return 0;
                else return 1;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.offer(node);
            }
        }

        ListNode result = new ListNode(-1);
        ListNode ptr = result;
        while (!priorityQueue.isEmpty())  {
            ListNode node = priorityQueue.poll();
            ptr.next = node;
            ptr = ptr.next;
            if (node.next!= null) {
                priorityQueue.offer(node.next);
            }
        }

        return result.next;
    }

    /// Below code only use pointer
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//        return mergeKLists(lists, 0, lists.length - 1);
//    }
//
//    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
//        if (start == end) return lists[start];
//        int middle = start + (end - start)/2;
//        ListNode left = mergeKLists(lists, start, middle);
//        ListNode right = mergeKLists(lists, middle + 1, end);
//        return mergeTwoLists(left, right);
//    }
//
//    private ListNode mergeTwoLists(ListNode left, ListNode right) {
//        ListNode result = new ListNode(-1);
//        ListNode ptr = result;
//        while (left != null || right != null) {
//            if (left == null) {
//                ptr.next = right;
//                right = right.next;
//            } else if (right == null) {
//                ptr.next = left;
//                left = left.next;
//            } else if (left.val <= right.val) {
//                ptr.next = left;
//                left = left.next;
//            } else {
//                ptr.next = right;
//                right = right.next;
//            }
//            ptr = ptr.next;
//        }
//        return result.next;
//    }
}
