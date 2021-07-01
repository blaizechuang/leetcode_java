package com.leetcode.leetcodesolution.solution.medium.list;

import android.util.Log;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.Arrays;

public class Sort_List_148 extends logger implements base_solution {
    @Override
    public void execute() {
        ListNode node = new ListNode(4);
        ListNode head = node;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(3);
        ListNode result = sortList(head);
        while (result != null) {
            Log.d("", "after sort: " + result.val);
            result = result.next;
        }
    }

    /**
     * 思路
     * 要在 nlogn 內解決, 所以直覺想到 heapsort 之類的演算法
     * 所以就是要先找出中間點, 然後左右子樹遞迴跑
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode secondHead = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);
        ListNode result = mergeSort(left, right);
        return result;
    }

    private ListNode mergeSort(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode result;
        if (left.val < right.val) {
            result = left;
            result.next = mergeSort(left.next, right);
        } else {
            result = right;
            result.next = mergeSort(left, right.next);
        }
        return result;
    }

    private ListNode findMiddle(ListNode node) {
        if (node == null) return node;
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Got middle node
        return slow;
    }

    /**
     * 有趣的解法, 三次 while
     * 1. 找出多少元素
     * 2. 塞到 array
     * 3. Arrays.sort
     * 4. 再更新 list
     */
    public ListNode sortList_tricky(ListNode head) {
        ListNode temp=head;
        int c=0;
        while(temp!=null){
            c+=1;
            temp=temp.next;
        }
        int a[]=new int[c];
        temp=head;
        int p=0;
        while(temp!=null){
            a[p]=temp.val;
            temp=temp.next;
            p+=1;
        }
        Arrays.sort(a);
        temp=head;
        p=0;
        while(temp!=null){
            temp.val=a[p];
            temp=temp.next;
            p+=1;
        }
        return head;
    }
}
