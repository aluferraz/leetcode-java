package leetcode.editor.en.Q63;

import java.util.*;

import javafx.util.Pair;

//You are given an m x n integer array grid. There is a robot initially located 
//at the top-left corner (i.e., grid[0][0]). The robot tries to move to the 
//bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down 
//or right at any point in time. 
//
// An obstacle and space are marked as 1 or 0 respectively in grid. A path that 
//the robot takes cannot include any square that is an obstacle. 
//
// Return the number of possible unique paths that the robot can take to reach 
//the bottom-right corner. 
//
// The testcases are generated so that the answer will be less than or equal to 
//2 * 10⁹. 
//
// 
// Example 1: 
// 
// 
//Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//Output: 2
//Explanation: There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
// 
//
// Example 2: 
// 
// 
//Input: obstacleGrid = [[0,1],[0,0]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] is 0 or 1. 
// 
//
// 👍 6881 👎 434


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] visited;
    int VISITING = -1;
    int STONE = 1;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        visited = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles(0, 0, obstacleGrid);
    }

    private int uniquePathsWithObstacles(int row, int col, int[][] obstacleGrid) {
        if (!isValidIdx(row, col, obstacleGrid)) return 0;
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[row].length - 1) {
            return 1;
        }
        if (visited[row][col] != null && visited[row][col] >= 0) {
            return visited[row][col];
        }
        visited[row][col] = VISITING;
        int ans = 0;
        if (isValidIdx(row + 1, col, obstacleGrid) && (visited[row + 1][col] == null || visited[row + 1][col] != VISITING)) {
            ans += uniquePathsWithObstacles(row + 1, col, obstacleGrid);
        }
        if (isValidIdx(row, col + 1, obstacleGrid) && (visited[row][col + 1] == null || visited[row][col + 1] != VISITING)) {
            ans += uniquePathsWithObstacles(row, col + 1, obstacleGrid);
        }

        visited[row][col] = ans;
        return ans;

    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] != STONE;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class UniquePathsIi extends Solution {
}