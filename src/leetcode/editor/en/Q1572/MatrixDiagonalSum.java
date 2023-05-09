package leetcode.editor.en.Q1572;

import java.util.*;

import javafx.util.Pair;

//Given a square matrix mat, return the sum of the matrix diagonals. 
//
// Only include the sum of all the elements on the primary diagonal and all the 
//elements on the secondary diagonal that are not part of the primary diagonal. 
//
// 
// Example 1: 
// 
// 
//Input: mat = [[1,2,3],
//              [4,5,6],
//              [7,8,9]]
//Output: 25
//Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
//Notice that element mat[1][1] = 5 is counted only once.
// 
//
// Example 2: 
//
// 
//Input: mat = [[1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1],
//              [1,1,1,1]]
//Output: 8
// 
//
// Example 3: 
//
// 
//Input: mat = [[5]]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// n == mat.length == mat[i].length 
// 1 <= n <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// 👍 2392 👎 31


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int diagonalSum(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        return sum(mat, visited, 0, 0, 1, 1) + sum(mat, visited, 0, mat[0].length - 1, 1, -1);
    }

    private int sum(int[][] mat, boolean[][] visited, int row, int col, int rSum, int cSum) {
        if (!isValidIdx(row, col, mat)) return 0;

        if (visited[row][col]) {
            return sum(mat, visited, row + rSum, col + cSum, rSum, cSum);
        }

        visited[row][col] = true;
        return mat[row][col] + sum(mat, visited, row + rSum, col + cSum, rSum, cSum);
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MatrixDiagonalSum extends Solution {
}