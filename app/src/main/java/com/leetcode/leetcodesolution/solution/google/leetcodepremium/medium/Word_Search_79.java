package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

class Word_Search_79 {
    /**
     * time complexity: O(M x N x 3^D), M: 列數, N: 行數, D: word 長度, 三個方向, 上下左右, 因為不往回走所以三個
     * space complexity: O(L), This L is the length of the word
     *
     * 思路：每個點都要找, 然後往外延伸, 所以在 main function 這邊要雙迴圈, 在 search 裏面就單純遞迴去查找
     */
//    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
//        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

//        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
//            return false;
//        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '*' || board[row][col] != word.charAt(index)) {
            return false;
        }

//        visited[row][col] = true;
        char c = board[row][col];
        board[row][col] = '*';
        if (search(board, word, row-1, col, index + 1) ||
                search(board, word, row, col+1, index + 1) ||
                search(board, word, row+1, col, index + 1) ||
                search(board, word, row, col-1, index + 1)) {
            return true;
        }
//        visited[row][col] = false;
        board[row][col] = c;

        return false;
    }
    /**
     * 我寫的錯誤, 這一題不需要 string buffer 去記, 因為重點在於該字是不是有被找到, 而且題目也沒有要回傳字串
     *
     */
//    public boolean exist(char[][] board, String word) {
//        StringBuffer sb = new StringBuffer();
//        boolean result = dfs(board, word, sb, 0, 0);
//        return result;
//    }
//
//    private boolean dfs(char[][] board, String word, StringBuffer sb, int startRow, int startCol) {
//        if (sb.length() == word.length() && sb.toString().equals(word)) {
//            return true;
//        }
//
//        if (startRow < 0 || startCol < 0 || sb.length() > word.length()) return false;
//
//        for (int i = startRow; i < board.length; i++) {
//            for (int j = startCol; j < board[i].length; j++) {
//                sb.append(board[i][j]);
//                if (dfs(board, word, sb, startRow - 1, startCol) ||
//                        dfs(board, word, sb, startRow, startCol + 1) ||
//                        dfs(board, word, sb, startRow + 1, startCol) ||
//                        dfs(board, word, sb, startRow, startCol - 1)) {
//                    return true;
//                }
//                sb.deleteCharAt(sb.length() - 1);
//
//            }
//        }
//        return false;
//    }
}
