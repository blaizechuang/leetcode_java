package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.basic.TrieNode;

class Implement_Trie_Prefix_Tree_208 {


}

/**
 * 這一題是 trieNode 的基本題型
 * time complexity: O(n), n is word's length
 * space complexity: O(n), n is word's length
 */
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
            } else {
                return false;
            }
        }

        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.children[ch - 'a'] != null) {
                cur = cur.children[ch - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}