package com.leetcode.leetcodesolution.solution.medium.list;

import com.leetcode.leetcodesolution.solution.basic.ListNode;

class Plus_One_Linked_List_369 {
    /**
     * 看到這種 ListNode 的題目就是先想到一個 dummy node 放在最前面, 然後看要一個或是兩個 tmp ListNode 去找
     * 這題主要就是要知道 9 在哪邊, 以及進位的位置, 所以 j 就是一路往右走去 +1,
     * i 就是停在進位的地方, 然後往右走把值設為 0
     * 最後就是去判斷 dummy, 如果沒有進位, 表示 dummy 沒有用, 回他的下一個, 有進位就是回 dummy
     * runtime: 0ms, 
     */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        // now i is in the left position, and j is in the right position
        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            while (i.next != null) {
                i = i.next;
                i.val = 0;
            }
        }
        if (dummy.val == 0) return dummy.next;
        return dummy;
    }
}
