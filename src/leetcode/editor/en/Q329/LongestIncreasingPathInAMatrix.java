package leetcode.editor.en.Q329;

import javafx.util.Pair;

import java.util.*;

//Given an m x n integers matrix, return the length of the longest increasing 
//path in matrix. 
//
// From each cell, you can either move in four directions: left, right, up, or 
//down. You may not move diagonally or move outside the boundary (i.e., wrap-
//around is not allowed). 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
//Output: 4
//Explanation: The longest increasing path is [1, 2, 6, 9].
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
//Output: 4
//Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally 
//is not allowed.
// 
//
// Example 3: 
//
// 
//Input: matrix = [[1]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 👍 7564 👎 111


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    ArrayList<Pair<Integer, Integer>> directions = new ArrayList<>();

    //    HashMap<Pair<Integer, Integer>, Integer> cache = new HashMap<>();
    Integer[][] cache;
    int[][] directions;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        directions = new int[][]{
                new int[]{0, 1},
                new int[]{0, -1},
                new int[]{1, 0},
                new int[]{-1, 0}
        };
        int best = 0;
        cache = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                best = Math.max(best, longest(i, j, matrix));
            }
        }
        return best;
    }

    private int longest(int row, int col, int[][] matrix) {

        int best = 1;
//        int row = coords.getKey();
//        int col = coords.getValue();
        if (cache[row][col] != null) return cache[row][col];

        int value = matrix[row][col];
        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValidIdx(newRow, newCol, matrix) &&
                    matrix[newRow][newCol] > value) {
                best = Math.max(best, longest(newRow, newCol, matrix) + 1);
            }
        }
        cache[row][col] = best;
        return best;

    }

    private boolean isValidIdx(int row, int col, int[][] board) {
        return row >= 0 &&
                row < board.length &&
                col >= 0 &&
                col < board[row].length
                ;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestIncreasingPathInAMatrix extends Solution {
}