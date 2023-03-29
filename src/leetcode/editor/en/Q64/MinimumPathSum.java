package leetcode.editor.en.Q64;

import java.util.*;

import javafx.util.Pair;

//Given a m x n grid filled with non-negative numbers, find a path from top 
//left to bottom right, which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// 
//
// Example 2: 
//
// 
//Input: grid = [[1,2,3],[4,5,6]]
//Output: 12
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
//
// 👍 10055 👎 130


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] cache;


    public int minPathSum(int[][] grid) {
        cache = new Integer[grid.length][grid[0].length];
        return minPathSumHelper(0, 0, grid);
    }

    private int minPathSumHelper(int row, int col, int[][] grid) {
        if (row == grid.length - 1 && col == grid[row].length - 1) {
            return grid[row][col];
        }
        if (cache[row][col] != null) {
            return cache[row][col];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (isValidIdx(row + 1, col, grid)) {
            down = grid[row][col] + minPathSumHelper(row + 1, col, grid);
        }

        if (isValidIdx(row, col + 1, grid)) {
            right = grid[row][col] + minPathSumHelper(row, col + 1, grid);
        }
        cache[row][col] = Math.min(down, right);
        return cache[row][col];

    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumPathSum extends Solution {
}