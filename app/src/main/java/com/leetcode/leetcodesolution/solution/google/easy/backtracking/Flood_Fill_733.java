package com.leetcode.leetcodesolution.solution.google.easy.backtracking;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Flood_Fill_733 extends logger implements base_solution {
    @Override
    public void execute() {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = floodFill(image, sr, sc, newColor);
    }

    /**
     * 自己寫出來, 這種題目要直覺想到 dfs pattern
     * time complexity: O(N)
     * space complexity: O(N)
     * N: pixels in image
     *
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int color = image[sr][sc];
        dfs(image, visited, sr, sc, color, newColor);
        return image;
    }

    private void dfs(int[][] image, boolean [][] visited, int sr, int sc, int oriColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >=image.length || sc >= image[0].length || visited[sr][sc] || image[sr][sc] != oriColor) {
            print("cur r: " + sr + ", c: " + sc);
            print("-- return");
            return;
        }

        print("cur r: " + sr + ", c: " + sc + ", value: " + image[sr][sc]);
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        dfs(image, visited, sr, sc - 1, oriColor, newColor);
        dfs(image, visited, sr, sc + 1, oriColor, newColor);
        dfs(image, visited, sr - 1, sc, oriColor, newColor);
        dfs(image, visited, sr + 1, sc, oriColor, newColor);
    }
}
