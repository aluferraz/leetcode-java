package leetcode.editor.en.Q994;

//You are given an m x n grid where each cell can have one of three values: 
//
// 
// 0 representing an empty cell, 
// 1 representing a fresh orange, or 
// 2 representing a rotten orange. 
// 
//
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten 
//orange becomes rotten. 
//
// Return the minimum number of minutes that must elapse until no cell has a 
//fresh orange. If this is impossible, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation: The orange in the bottom left corner (row 2, column 0) is never 
//rotten, because rotting only happens 4-directionally.
// 
//
// Example 3: 
//
// 
//Input: grid = [[0,2]]
//Output: 0
//Explanation: Since there are already no fresh oranges at minute 0, the answer 
//is just 0.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] is 0, 1, or 2. 
// 
//
// 👍 8805 👎 318


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ROTTEN) queue.add(new int[]{i, j});
                else if (grid[i][j] == FRESH) freshOranges++;
            }
        }
        int minutes = 0;
        while (queue.size() > 0 && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rottenInfo = queue.remove();
                int row = rottenInfo[0];
                int col = rottenInfo[1];
                if (isValidIdx(row, col + 1, grid) && grid[row][col + 1] == FRESH) {
                    freshOranges--;
                    grid[row][col + 1] = ROTTEN;
                    queue.add(new int[]{row, col + 1});
                }
                if (isValidIdx(row, col - 1, grid) && grid[row][col - 1] == FRESH) {
                    freshOranges--;
                    grid[row][col - 1] = ROTTEN;
                    queue.add(new int[]{row, col - 1});
                }
                if (isValidIdx(row + 1, col, grid) && grid[row + 1][col] == FRESH) {
                    freshOranges--;
                    grid[row + 1][col] = ROTTEN;
                    queue.add(new int[]{row + 1, col});
                }

                if (isValidIdx(row - 1, col, grid) && grid[row - 1][col] == FRESH) {
                    freshOranges--;
                    grid[row - 1][col] = ROTTEN;
                    queue.add(new int[]{row - 1, col});
                }
            }
            minutes++;
        }


        return (freshOranges == 0) ? minutes : -1;
    }

    private boolean isValidIdx(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
