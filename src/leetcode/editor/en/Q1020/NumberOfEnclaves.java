package leetcode.editor.en.Q1020;

import java.util.*;

import javafx.util.Pair;

//You are given an m x n binary matrix grid, where 0 represents a sea cell and 1
// represents a land cell. 
//
// A move consists of walking from one land cell to another adjacent (4-
//directionally) land cell or walking off the boundary of the grid. 
//
// Return the number of land cells in grid for which we cannot walk off the 
//boundary of the grid in any number of moves. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//Output: 3
//Explanation: There are three 1s that are enclosed by 0s, and one 1 that is 
//not enclosed because its on the boundary.
// 
//
// Example 2: 
// 
// 
//Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//Output: 0
//Explanation: All 1s are either on the boundary or can reach the boundary.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] is either 0 or 1. 
// 
//
// 👍 2861 👎 57


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] DIRECTIONS = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};
    boolean[][] visited;
    private static final int LAND = 1;
    private static final int WATER = 0;

    public int numEnclaves(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, grid);
            dfs(i, grid[i].length - 1, grid);
        }
        for (int i = 0; i < grid[0].length; i++) {
            dfs(0, i, grid);
            dfs(grid.length - 1, i, grid);
        }
        int enclaves = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == LAND && !visited[i][j]) {
                    enclaves++;
                }
            }
        }
        return enclaves;

    }

    private void dfs(int row, int col, int[][] grid) {
        if (!isValidIdx(row, col, grid) || grid[row][col] == WATER || visited[row][col]) return;
        visited[row][col] = true;
        for (int[] direction : DIRECTIONS) {
            dfs(row + direction[0], col + direction[1], grid);
        }
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfEnclaves extends Solution {
}