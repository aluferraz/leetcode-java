package leetcode.editor.en.Q1428;

import java.util.*;

//A row-sorted binary matrix means that all elements are 0 or 1 and each row of 
//the matrix is sorted in non-decreasing order. 
//
// Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) 
//of the leftmost column with a 1 in it. If such an index does not exist, return -1
//. 
//
// You can't access the Binary Matrix directly. You may only access the matrix 
//using a BinaryMatrix interface: 
//
// 
// BinaryMatrix.get(row, col) returns the element of the matrix at index (row, 
//col) (0-indexed). 
// BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2
// elements [rows, cols], which means the matrix is rows x cols. 
// 
//
// Submissions making more than 1000 calls to BinaryMatrix.get will be judged 
//Wrong Answer. Also, any solutions that attempt to circumvent the judge will 
//result in disqualification. 
//
// For custom testing purposes, the input will be the entire binary matrix mat. 
//You will not have access to the binary matrix directly. 
//
// 
// Example 1: 
// 
// 
//Input: mat = [[0,0],[1,1]]
//Output: 0
// 
//
// Example 2: 
// 
// 
//Input: mat = [[0,0],[0,1]]
//Output: 1
// 
//
// Example 3: 
// 
// 
//Input: mat = [[0,0],[0,0]]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// rows == mat.length 
// cols == mat[i].length 
// 1 <= rows, cols <= 100 
// mat[i][j] is either 0 or 1. 
// mat[i] is sorted in non-decreasing order. 
// 
//
// 👍 1063 👎 122

interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
};


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {


        int lastRow = binaryMatrix.dimensions().get(0);
        int lastCol = binaryMatrix.dimensions().get(1) -1;
        int minCol = Integer.MAX_VALUE;
        for (int i = 0; i < lastRow; i++) {
            int left = 0;
            int right = lastCol;
            while (left <= right) {
                int mid = Math.floorDiv((left + right), 2);
                int value = binaryMatrix.get(i, mid);
                if (value == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    minCol = Math.min(minCol, mid);
                }
            }
        }
        return minCol == Integer.MAX_VALUE ? -1 : minCol;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class LeftmostColumnWithAtLeastAOne extends Solution {
}