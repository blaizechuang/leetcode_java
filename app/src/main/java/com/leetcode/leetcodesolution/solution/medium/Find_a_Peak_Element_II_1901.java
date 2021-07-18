package com.leetcode.leetcodesolution.solution.medium;

class Find_a_Peak_Element_II_1901 {
    /**
     *
     * 看完解答後自己寫的
     * 主要的差別在於檢查 left big 跟 right big 的 boundary 方式
     */
    public int[] findPeakGrid(int[][] mat) {
        int startCol = 0, endCol = mat[0].length;
        while(startCol <= endCol) {
            int maxRow = 0;
            int midCol = startCol + (endCol - startCol)/2;
            for (int i = 0; i < mat.length; i++) {
                maxRow = mat[i][midCol] >= mat[maxRow][midCol] ? i : maxRow;
            }

            // Now I find the max row, start to check the left and the right item
            boolean isLeftBig = (midCol > 0) && (mat[maxRow][midCol] < mat[maxRow][midCol-1]);
            boolean isRightBig = (midCol < endCol - 1) && (mat[maxRow][midCol] < mat[maxRow][midCol + 1]);
            if (!isLeftBig && !isRightBig) {
                return new int[]{maxRow, midCol};
            } else if (isLeftBig) {
                endCol = midCol - 1;
            } else if (isRightBig) {
                startCol = midCol+1;
            }
        }
        return new int[] {-1, -1};
    }

    /**
     *
     * 神人的解答
     * 重點在題目的提示, time complexity 要是 mlog(n) or nlog(m)
     * 所以一定要 for loop 一個方向是一定要的, 但是後面卻是log(n)
     * 所以要去想是不是可以再多判斷左右邊, 然後套用 sliding window 的概念
     */
    public int[] findPeakGrid_sol(int[][] mat) {
        int startCol = 0, endCol = mat[0].length-1;

        while(startCol <= endCol){
            int maxRow = 0, midCol = startCol + (endCol-startCol)/2;

            for(int row=0; row<mat.length; row++){
                maxRow = mat[row][midCol] >= mat[maxRow][midCol]? row : maxRow;
            }

            boolean leftIsBig    =   midCol-1 >= startCol  &&  mat[maxRow][midCol-1] > mat[maxRow][midCol];
            boolean rightIsBig   =   midCol+1 <= endCol    &&  mat[maxRow][midCol+1] > mat[maxRow][midCol];

            if(!leftIsBig && !rightIsBig)   // we have found the peak element
                return new int[]{maxRow, midCol};

            else if(rightIsBig)  // if rightIsBig, then there is an element in 'right' that is bigger than all the elements in the 'midCol',
                startCol = midCol+1; //so 'midCol' cannot be a 'peakPlane'

            else // leftIsBig
                endCol = midCol-1;
        }
        return null;
    }
}
