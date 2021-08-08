package com.leetcode.leetcodesolution.solution.google.leetcodepremium.hard;

import java.util.ArrayList;
import java.util.List;

class Word_Search_II_212 {
    /**
     * time complexity: O(m x n x C x 3^L), m: row, n: col, C: words count, L: words length
     * space complexity: O(cL)
     */
    TrieTree root = new TrieTree(' ');
    public List<String> findWords(char[][] board, String[] words) {
        buildTree(root, words);
        List<String> result = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    find(board, root, i, j, result);
                }
            }
        }
        return result;
    }

    private void find(char[][] board, TrieTree cur, int row, int col, List<String> result) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] == '*') {
            return;
        }

        char c = board[row][col];
        if (cur.children[c - 'a'] == null) return;
        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            result.add(cur.word);
            cur.word = null;
        }

        board[row][col] = '*';
        find(board, cur, row, col + 1, result);
        find(board, cur, row - 1, col, result);
        find(board, cur, row, col - 1, result);
        find(board, cur, row + 1, col, result);
        board[row][col] = c;
    }

    private void buildTree(TrieTree root, String[] words) {
        for (int i = 0; i < words.length; i++) {
            TrieTree cur = root;
            for (char c : words[i].toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c-'a'] = new TrieTree(c);
                }
                cur = cur.children[c-'a'];

            }
            cur.word = words[i];
        }
    }
}

class TrieTree {
    char val;
    TrieTree[] children;
    String word;

    TrieTree(char c) {
        val = c;
        children = new TrieTree[26];
        word = null;
    }
}
