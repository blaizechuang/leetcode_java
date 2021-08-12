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

    /**
     * time complexity: O(N)
     * space complexity: O(1)
     * 思路：先找出中間點, 中間點的起始位置要判斷是奇還是偶, 如果是 even list, slow = slow.next
     *
     */
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 表示目前的 list 是 even list, 所以 middle 要再往下一個, 這行是這個答案的重點
        if (fast != null) {
            slow = slow.next;
        }

        ListNode revert = revert(slow);
        fast = head;
        while(revert != null) {
            if (revert.val != fast.val) {
                return false;
            }
            revert = revert.next;
            fast = fast.next;
        }

        return true;
    }

    // 字串反轉老是會卡住, 記得就是先把 prev 先 new 出來指向 null
    // 然後再一個一個往後找
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
