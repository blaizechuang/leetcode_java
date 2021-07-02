package com.leetcode.leetcodesolution.solution.easy.list;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.basic.ListNode;
import com.leetcode.leetcodesolution.solution.logger;

public class Intersection_of_Two_Linked_Lists_160 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /**
     *
     * 先找出 list 的長度
     * 把比較長的前面 filter 掉
     * 然後找出位址相同的那個點, 不是值, 所以不可以比較 val
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeHeadA = getLength(headA);
        int sizeHeadB = getLength(headB);

        ListNode longer = sizeHeadA > sizeHeadB ? headA : headB;
        ListNode shorter = sizeHeadA > sizeHeadB ? headB : headA;

        ListNode filterLong = filterLongList(longer, Math.abs(sizeHeadA - sizeHeadB));

        while (shorter != filterLong) {
            shorter = shorter.next;
            filterLong = filterLong.next;
        }

        return filterLong;
    }

    private ListNode filterLongList(ListNode list, int count) {
        int value = count;
        while (list != null && value != 0) {
            list = list.next;
            value--;
        }
        return list;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
