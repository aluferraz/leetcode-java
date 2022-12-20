package leetcode.editor.en.Q221;

import java.util.*;

//Given an m x n binary matrix filled with 0's and 1's, find the largest square 
//containing only 1's and return its area. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 4
// 
//
// Example 2: 
// 
// 
//Input: matrix = [["0","1"],["1","0"]]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] is '0' or '1'. 
// 
//
// 👍 8338 👎 180


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] presum = presumMatrix(matrix);
        int result = 0;
        for (int i = 0; i < presum.length; i++) {
            for (int j = 0; j < presum[i].length; j++) {
                if (presum[i][j] == 1) {
                    result = Math.max(result, 1);
                }

                int rowSum = presum[i][j] - (i > 0 ? presum[i - 1][j] : 0);
                int colSum = presum[i][j] - (j > 0 ? presum[i][j - 1] : 0);
                int maxSquare = (int) Math.sqrt(result) + 1; //Math.min(rowSum, colSum);
                if (maxSquare > (j + 1) || maxSquare > (i + 1)) continue;
                int squareRow = rowSum - (getValue(i, j - maxSquare, presum) - getValue(i - 1, j - maxSquare, presum));
                int squareCol = colSum - (getValue(i - maxSquare, j, presum) - getValue(i - maxSquare, j - 1, presum));
                int squareSum = presum[i][j] -
                        getValue(i, j - maxSquare, presum) -
                        getValue(i - maxSquare, j, presum) +
                        getValue(i - maxSquare, j - maxSquare, presum);


                if (squareRow == squareCol && squareSum == (squareRow * squareCol)) {
                    result = Math.max(result, (squareRow * squareCol));
                }

            }
        }
        return result;
    }

    private int getValue(int i, int j, int[][] presum) {
        if (i == -1 || j == -1) return 0;
        return presum[i][j];
    }

    private int[][] presumMatrix(char[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        result[0][0] = Character.getNumericValue(matrix[0][0]);
        for (int i = 1; i < matrix.length; i++) {
            result[i][0] = result[i - 1][0] + Character.getNumericValue(matrix[i][0]);
        }
        for (int i = 1; i < matrix[0].length; i++) {
            result[0][i] = result[0][i - 1] + Character.getNumericValue(matrix[0][i]);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                result[i][j] = Character.getNumericValue(matrix[i][j]) +
                        result[i - 1][j] +
                        result[i][j - 1] -
                        result[i - 1][j - 1];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MaximalSquare extends Solution {
}