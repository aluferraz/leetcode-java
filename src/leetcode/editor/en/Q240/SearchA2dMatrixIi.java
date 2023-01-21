package leetcode.editor.en.Q240;

import java.util.*;

import javafx.util.Pair;

//Write an efficient algorithm that searches for a value target in an m x n 
//integer matrix matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// 
// Example 1: 
// 
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -10⁹ <= target <= 10⁹ 
// 
//
// 👍 9857 👎 164


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startingCol = Arrays.binarySearch(matrix[0], target);
        if (startingCol >= 0) {
            return true;
        }
        startingCol = Math.abs(startingCol) - 1;
        startingCol = Math.min(startingCol, matrix[0].length - 1);

        for (int i = startingCol; i >= 0; i--) {
            if (target > matrix[matrix.length - 1][i]) return false;
            if (binarySearch(i, matrix, target)) {
                return true;
            }

        }
        return false;
    }

    private boolean binarySearch(int col, int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left <= right) {
            int mid = Math.floorDiv((left + right), 2);
            int value = matrix[mid][col];
            if (value == target) return true;
            if (target < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SearchA2dMatrixIi extends Solution {
}