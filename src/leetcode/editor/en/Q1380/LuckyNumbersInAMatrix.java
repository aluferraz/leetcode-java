package leetcode.editor.en.Q1380;

import java.util.*;

import javafx.util.Pair;

//Given an m x n matrix of distinct numbers, return all lucky numbers in the 
//matrix in any order. 
//
// A lucky number is an element of the matrix such that it is the minimum 
//element in its row and maximum in its column. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
//Output: [15]
//Explanation: 15 is the only lucky number since it is the minimum in its row 
//and the maximum in its column.
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//Output: [12]
//Explanation: 12 is the only lucky number since it is the minimum in its row 
//and the maximum in its column.
// 
//
// Example 3: 
//
// 
//Input: matrix = [[7,8],[1,2]]
//Output: [7]
//Explanation: 7 is the only lucky number since it is the minimum in its row 
//and the maximum in its column.
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= n, m <= 50 
// 1 <= matrix[i][j] <= 10⁵. 
// All elements in the matrix are distinct. 
// 
//
// 👍 1381 👎 74


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] minRows = new int[matrix.length];
        Arrays.fill(minRows, Integer.MAX_VALUE);
        int[] maxCols = new int[matrix[0].length];
        Arrays.fill(maxCols, Integer.MIN_VALUE);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                minRows[row] = Math.min(minRows[row], matrix[row][col]);
                maxCols[col] = Math.max(maxCols[col], matrix[row][col]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int element = matrix[row][col];
                if (element == minRows[row] && element == maxCols[col]) {
                    res.add(matrix[row][col]);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LuckyNumbersInAMatrix extends Solution {
}