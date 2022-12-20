package leetcode.editor.en.Q85;

import java.util.*;

//Given a rows x cols binary matrix filled with 0's and 1's, find the largest 
//rectangle containing only 1's and return its area. 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
//"1"],["1","0","0","1","0"]]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.
// 
//
// Example 2: 
//
// 
//Input: matrix = [["0"]]
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: matrix = [["1"]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// rows == matrix.length 
// cols == matrix[i].length 
// 1 <= row, cols <= 200 
// matrix[i][j] is '0' or '1'. 
// 
//
// 👍 8000 👎 128


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] presum = presumMatrix(matrix);
        int[][] dp = new int[matrix.length][matrix[0].length];
        int[] result = new int[2];
        for (int i = 0; i < presum.length; i++) {
            for (int j = 0; j < presum[i].length; j++) {
                int rowSum = presum[i][j] - getValue(i - 1, j, presum);
                int colSum = presum[i][j] - getValue(i, j - 1, presum);
                int maxRetangle = Math.max(rowSum, colSum); // Row or col alone
            }
        }
        return result[0] * result[1];

    }

    private int getValue(int i, int j, int[][] presum) {
        if (i <= -1 || j <= -1) return 0;
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


public class MaximalRectangle extends Solution {
}