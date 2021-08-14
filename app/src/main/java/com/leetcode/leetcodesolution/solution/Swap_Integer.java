package com.leetcode.leetcodesolution.solution;

class Swap_Integer {
    public void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
