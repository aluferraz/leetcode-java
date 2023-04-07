package leetcode.editor.en.Q1254;

import java.util.*;

import javafx.util.Pair;

//Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal 4
//-directionally connected group of 0s and a closed island is an island totally (
//all left, top, right, bottom) surrounded by 1s. 
//
// Return the number of closed islands. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,
//0,1,0,1],[1,1,1,1,1,1,1,0]]
//Output: 2
//Explanation: 
//Islands in gray are closed because they are completely surrounded by water (
//group of 1s). 
//
// Example 2: 
//
// 
//
// 
//Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,1,1,1,1,1,1],
//               [1,0,0,0,0,0,1],
//               [1,0,1,1,1,0,1],
//               [1,0,1,0,1,0,1],
//               [1,0,1,1,1,0,1],
//               [1,0,0,0,0,0,1],
//               [1,1,1,1,1,1,1]]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
//
// 👍 3338 👎 107


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[][] visited;
    private static final int UNSEEN = 0;
    private static final int VISITING = -1;
    private static final int INVALID = 2;
    private static final int VALID = 1;
    private static final int ISLAND = 0;
    private static final int WATER = 1;

    private final int[][] DIRECTIONS = new int[][]{
            new int[]{-1, 0}, //UP
            new int[]{1, 0}, //DOWN
            new int[]{0, -1}, //LEFT
            new int[]{0, 1}, //RIGHT
    };

    public int closedIsland(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ISLAND && visited[i][j] == UNSEEN) {
                    if (dfs(i, j, grid)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(int row, int col, int[][] grid) {
        if (grid[row][col] == WATER) return true;
        if (visited[row][col] != UNSEEN) {
            switch (visited[row][col]) {
                case VALID:
                    return true;
                case INVALID:
                    return false;
            }
        }
        visited[row][col] = VISITING;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (!isValidIdx(nextRow, nextCol, grid)) {
                visited[row][col] = INVALID;
                return false;
            }
            if (visited[nextRow][nextCol] != VISITING && !dfs(nextRow, nextCol, grid)) {
                visited[row][col] = INVALID;
                return false;
            }
        }
        visited[row][col] = VALID;
        return true;
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfClosedIslands extends Solution {
}