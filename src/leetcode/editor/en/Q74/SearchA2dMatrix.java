package leetcode.editor.en.Q74;

import java.util.*;

//Write an efficient algorithm that searches for a value target in an m x n 
//integer matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the 
//previous row. 
// 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// 👍 10375 👎 316


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[row].length - 1;
        while (isValidIdx(row, col, matrix)) {
            int cellValue = matrix[row][col];
            if (cellValue == target) return true;
            if (target < cellValue) col--;
            if (target > cellValue) row++;
        }
        return false;
    }

    private boolean isValidIdx(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}

//leetcode submit region end(Prohibit modification and deletion)


public class SearchA2dMatrix extends Solution {
}