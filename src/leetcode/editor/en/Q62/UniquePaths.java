package leetcode.editor.en.Q62;

import java.util.*;

//There is a robot on an m x n grid. The robot is initially located at the top-
//left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right 
//corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at 
//any point in time. 
//
// Given the two integers m and n, return the number of possible unique paths 
//that the robot can take to reach the bottom-right corner. 
//
// The test cases are generated so that the answer will be less than or equal 
//to 2 * 10⁹. 
//
// 
// Example 1: 
// 
// 
//Input: m = 3, n = 7
//Output: 28
// 
//
// Example 2: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach 
//the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// 
//
// 👍 12334 👎 359


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int row = i;
                int col = j;
                paths[row][col] = paths[row + 1][col] + paths[row][col + 1];
            }
        }
        return paths[0][0];
    }


    //TLE
//    private int totalUniquePaths = 0;
//
//    public int uniquePaths(int m, int n) {
//        int[][] visited = new int[m][n];
//        dfs(0, 0, visited);
//        return totalUniquePaths;
//    }
//
//    private void dfs(int row, int col, int[][] visited) {
//        if (!isValidIdx(row, col, visited)) return;
//        if (visited[row][col] != 0) return;
//        if (row == visited.length - 1 && col == visited[row].length - 1) {
//            totalUniquePaths++;
//        }
//        visited[row][col] = 1;
//        dfs(row + 1, col, visited);
//        dfs(row, col + 1, visited);
//        visited[row][col] = 0;
//    }
//
//    private boolean isValidIdx(int row, int col, int[][] grid) {
//        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class UniquePaths extends Solution {
}