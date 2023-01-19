package leetcode.editor.en.Q59;

import java.util.*;

import javafx.util.Pair;

//Given a positive integer n, generate an n x n matrix filled with elements 
//from 1 to n² in spiral order. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
//
// 👍 4533 👎 201


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] directions = new int[][]{
            new int[]{0, 1}, // Right
            new int[]{1, 0}, // Down
            new int[]{0, -1}, // Left
            new int[]{-1, 0} // UP
    };

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        fillMatrix(1, 0, 0, 0, matrix);
        return matrix;
    }

    private void fillMatrix(int val, int dir, int row, int col, int[][] matrix) {
        matrix[row][col] = val;
        int[] move = directions[dir];
        int newRow = row + move[0];
        int newCol = col + move[1];

        if (isValidIdx(newRow, newCol, matrix)) {
            fillMatrix(val + 1, dir, newRow, newCol, matrix);
            return;
        }

        for (int i = dir + 1; i < directions.length * 2; i++) {
            int idx = i % directions.length;
            if (idx == dir) break;
            move = directions[idx];
            newRow = row + move[0];
            newCol = col + move[1];
            if (isValidIdx(newRow, newCol, matrix)) {
                fillMatrix(val + 1, idx, newRow, newCol, matrix);
                return;
            }
        }


    }

    private boolean isValidIdx(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length && matrix[row][col] == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SpiralMatrixIi extends Solution {
}