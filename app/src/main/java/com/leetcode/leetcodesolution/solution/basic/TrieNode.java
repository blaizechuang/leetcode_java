package com.leetcode.leetcodesolution.solution.basic;

public class TrieNode {
    public char ch;
    public TrieNode[] children;
    public boolean isWord; // 樹葉才標成 true, 表示是一個英文單字

    public TrieNode(char c) {
        this.ch = c;
        children = new TrieNode[26];
        isWord = false;
    }
}
