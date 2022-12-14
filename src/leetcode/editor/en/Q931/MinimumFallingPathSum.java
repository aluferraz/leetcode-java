package leetcode.editor.en.Q931;

import java.util.*;

//Given an n x n array of integers matrix, return the minimum sum of any 
//falling path through matrix. 
//
// A falling path starts at any element in the first row and chooses the 
//element in the next row that is either directly below or diagonally left/right. 
//Specifically, the next element from position (row, col) will be (row + 1, col - 1), (
//row + 1, col), or (row + 1, col + 1). 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown.
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
//
// 👍 3628 👎 111


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[][] cache;

    public int minFallingPathSum(int[][] matrix) {
        cache = new Integer[matrix.length][matrix[0].length];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            result = Math.min(result, dfs(0, i, matrix));
        }
        return result;
    }

    private int dfs(int row, int col, int[][] matrix) {
        if (!isValidIdx(row, col, matrix)) return 0;
        if (row == matrix.length - 1) return matrix[row][col];
        if (cache[row][col] != null) return cache[row][col];

        int bellow = isValidIdx(row + 1, col, matrix) ? dfs(row + 1, col, matrix) : Integer.MAX_VALUE;
        int leftDiag = isValidIdx(row + 1, col - 1, matrix) ? dfs(row + 1, col - 1, matrix) : Integer.MAX_VALUE;
        int rightDiag = isValidIdx(row + 1, col + 1, matrix) ? dfs(row + 1, col + 1, matrix) : Integer.MAX_VALUE;

        int minPath = Math.min(bellow, Math.min(leftDiag, rightDiag));
        cache[row][col] = matrix[row][col] + minPath;
        return cache[row][col];
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumFallingPathSum extends Solution {
}