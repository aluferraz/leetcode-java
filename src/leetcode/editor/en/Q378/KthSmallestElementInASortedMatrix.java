package leetcode.editor.en.Q378;

import java.util.*;

import javafx.util.Pair;

//Given an n x n matrix where each of the rows and columns is sorted in 
//ascending order, return the kᵗʰ smallest element in the matrix. 
//
// Note that it is the kᵗʰ smallest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// You must find a solution with a memory complexity better than O(n²). 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//Output: 13
//Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and 
//the 8ᵗʰ smallest number is 13
// 
//
// Example 2: 
//
// 
//Input: matrix = [[-5]], k = 1
//Output: -5
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// All the rows and columns of matrix are guaranteed to be sorted in non-
//decreasing order. 
// 1 <= k <= n² 
// 
//
// 
// Follow up: 
//
// 
// Could you solve the problem with a constant memory (i.e., O(1) memory 
//complexity)? 
// Could you solve the problem in O(n) time complexity? The solution may be too 
//advanced for an interview but you may find reading this paper fun. 
// 
//
// 👍 8813 👎 309


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        TreeSet<int[]> pq = new TreeSet<>((aValues, bValues) -> {
            int aValue = aValues[0];
            int aRow = aValues[1];
            int aCol = aValues[2];

            int bValue = bValues[0];
            int bRow = bValues[1];
            int bCol = bValues[2];

            if (aValue == bValue) {
                if (aRow == bRow) {
                    return Integer.compare(aCol, bCol);
                }
                return Integer.compare(aRow, bRow);
            }
            return Integer.compare(aValue, bValue);
        });
        int value = matrix[0][0];
        pq.add(new int[]{value, 0, 0});
        int smallest = 0;


        while (smallest < k) {
            int[] next = pq.pollFirst();
            smallest++;
            value = next[0];
            int row = next[1];
            int col = next[2];

            if (isValidIdx(row + 1, col, matrix)) {
                pq.add( new int[] { matrix[row + 1][col] , (row + 1), col});
            }

            if (isValidIdx(row, col + 1, matrix)) {
                pq.add(new int[]{matrix[row][col + 1], row, (col + 1)});
            }

        }

        return value;
    }

    private boolean isValidIdx(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class KthSmallestElementInASortedMatrix extends Solution {
}