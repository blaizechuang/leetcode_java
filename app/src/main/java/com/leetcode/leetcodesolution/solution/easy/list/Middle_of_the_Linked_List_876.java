package com.leetcode.leetcodesolution.solution.easy.list;

import com.leetcode.leetcodesolution.solution.basic.ListNode;

class Middle_of_the_Linked_List_876 {

    /**
     * time complexity: O(N)
     * space complexity: O(1)
     * 思路：很直覺的是 slow/fast 方法, 重點是 while 的判斷，從題目去試一下
     * 就可以知道 fast != null && fast.next != null 兩個條件都要成立
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
