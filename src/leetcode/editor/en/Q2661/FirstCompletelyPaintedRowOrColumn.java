package leetcode.editor.en.Q2661;
import java.util.*;
import javafx.util.Pair;

//You are given a 0-indexed integer array arr, and an m x n integer matrix mat. 
//arr and mat both contain all the integers in the range [1, m * n]. 
//
// Go through each index i in arr starting from index 0 and paint the cell in 
//mat containing the integer arr[i]. 
//
// Return the smallest index i at which either a row or a column will be 
//completely painted in mat. 
//
// 
// Example 1: 
//
// 
// 
//Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
//Output: 2
//Explanation: The moves are shown in order, and both the first row and second 
//column of the matrix become fully painted at arr[2].
// 
//
// Example 2: 
// 
// 
//Input: arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
//Output: 3
//Explanation: The second column becomes fully painted at arr[3].
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n = mat[i].length 
// arr.length == m * n 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 1 <= arr[i], mat[r][c] <= m * n 
// All the integers of arr are unique. 
// All the integers of mat are unique. 
// 
//
// 👍 153 👎 4


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer, int[]> numPos = new HashMap<>();
        HashMap<Integer, Integer> rowCount = new HashMap<>();
        HashMap<Integer, Integer> colCount = new HashMap<>();


        for (int i = 0; i < mat.length; i++) {
            rowCount.put(i, mat[i].length);
            for (int j = 0; j < mat[i].length; j++) {
                numPos.put(mat[i][j], new int[]{i, j});
                colCount.put(j, mat.length);
            }
        }


        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            int[] coords = numPos.get(target);
            int row = coords[0];
            int col = coords[1];

            int rowTot = rowCount.get(row);
            rowTot -= 1;
            if (rowTot == 0) return i;
            rowCount.put(row, rowTot);

            int colTot = colCount.get(col);
            colTot -= 1;
            if (colTot == 0) return i;
            colCount.put(col, colTot);
        }
        return arr.length;

    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class FirstCompletelyPaintedRowOrColumn extends Solution {}