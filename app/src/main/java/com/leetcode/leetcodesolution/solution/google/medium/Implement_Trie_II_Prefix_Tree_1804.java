package com.leetcode.leetcodesolution.solution.google.medium;

class Implement_Trie_II_Prefix_Tree_1804 {
}

/**
 * 跟 I 的差別在於 count 這個欄位，而且另一個重點是樹葉原本是用 boolean 去記, 也要改成用 int 去記
 * 不然會出錯, 因為 test case 太多了, 還不知道原因
 *
 * time complexity: O(n), n is word's length
 * space complexity: O(n), n is word's length
 */
class TrieNode2 {
    public char ch;
    public TrieNode2[] children;
    public int wordCount; // 樹葉才標成 true, 表示是一個英文單字
    public int count;

    public TrieNode2(char c) {
        this.ch = c;
        children = new TrieNode2[26];
        wordCount = 0;
        count = 0;
    }
}

class Trie2 {

    TrieNode2 root;

    public Trie2() {
        root = new TrieNode2(' ');
    }

    public void insert(String word) {
        TrieNode2 cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode2(c);
            }
            cur = cur.children[c - 'a'];
            cur.count ++;
        }
        cur.wordCount ++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode2 cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return 0;
            } else {
                cur = cur.children[c - 'a'];
            }
        }

        return cur.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode2 cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return 0;
            } else {
                cur = cur.children[c - 'a'];
            }
        }

        return cur.count;
    }

    public void erase(String word) {
        TrieNode2 cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] != null) {
                cur = cur.children[c - 'a'];
                cur.count--;
            } else {
                return;
            }
        }
        cur.wordCount--;
    }
}