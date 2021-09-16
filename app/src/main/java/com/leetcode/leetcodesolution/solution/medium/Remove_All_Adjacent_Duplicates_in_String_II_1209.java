package com.leetcode.leetcodesolution.solution.medium;

import org.w3c.dom.Node;

import java.util.Stack;

class Remove_All_Adjacent_Duplicates_in_String_II_1209 {

    /**
     * 跟下面一樣的思路, 換成 Deque 後, run time 縮短至 13 ms, 應該是減少了字串反轉的部分
     */
//    public String removeDuplicates(String s, int k) {
//        Deque<Node> queue = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++) {
//            char current = s.charAt(i);
//            if (queue.isEmpty()) {
//                // System.out.println("push: " + current);
//                queue.offer(new Node(current));
//            } else if (queue.peekLast().times < k - 1 && queue.peekLast().c == current) {
//                // System.out.println("times: " + stack.peek().times + ", now char: " + stack.peek().c);
//                Node tmp = queue.pollLast();
//                tmp.times++;
//                queue.offer(tmp);
//            } else if (queue.peekLast().c == current){
//                // System.out.println("pop, now char is " + stack.peek().c);
//                queue.pollLast();
//            } else {
//                queue.offer(new Node(current));
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!queue.isEmpty()) {
//            Node item = queue.poll();
//            for (int i = 0; i < item.times; i++) {
//                sb.append(item.c);
//            }
//        }
//
//        return sb.toString();
//    }
    /**
     * 參考網路解法自己寫出來, 不過邏輯還是偏複雜,
     *
     * time complexity: O(N), N is the length of s
     * space complexity:O(N)
     * run time: 20 ms
     */
    public String removeDuplicates(String s, int k) {
        Stack<Node1209> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (stack.isEmpty()) {
                // System.out.println("push: " + current);
                stack.push(new Node1209(current));
            } else if (stack.peek().times < k - 1 && stack.peek().c == current) {
                // System.out.println("times: " + stack.peek().times + ", now char: " + stack.peek().c);
                Node1209 tmp = stack.pop();
                tmp.times++;
                stack.push(tmp);
            } else if (stack.peek().c == current) {
                // System.out.println("pop, now char is " + stack.peek().c);
                stack.pop();
            } else {
                stack.push(new Node1209(current));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node1209 item = stack.pop();
            for (int i = 0; i < item.times; i++) {
                sb.append(item.c);
            }
        }

        return sb.reverse().toString();
    }

}

class Node1209{
    char c;
    int times;
    Node1209(char ch) {
        c = ch;
        times = 1;
    }
}