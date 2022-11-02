package leetcode.editor.en.Q542;

//Given an m x n binary matrix mat, return the distance of the nearest 0 for 
//each cell. 
//
// The distance between two adjacent cells is 1. 
//
// 
// Example 1: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
// 
//
// Example 2: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// There is at least one 0 in mat. 
// 
//
// 👍 5925 👎 291


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Zero1Matrix {
    public static int[][] updateMatrix(int[][] mat) {
        return new Solution().updateMatrix(mat);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int[][] distances = new int[mat.length][mat[0].length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cellInfo = q.remove();
                int row = cellInfo[0];
                int col = cellInfo[1];
                int carryOn = cellInfo[2];
                distances[row][col] = Math.min(carryOn, distances[row][col]);
                if (isValidIdx(row, col + 1, distances) && (carryOn + 1) < distances[row][col + 1]) {
                    q.add(new int[]{row, col + 1, carryOn + 1});
                }
                if (isValidIdx(row, col - 1, distances) && (carryOn + 1) < distances[row][col - 1]) {
                    q.add(new int[]{row, col - 1, carryOn + 1});
                }
                if (isValidIdx(row + 1, col, distances) && (carryOn + 1) < distances[row + 1][col]) {
                    q.add(new int[]{row + 1, col, carryOn + 1});
                }

                if (isValidIdx(row - 1, col, distances) && (carryOn + 1) < distances[row - 1][col]) {
                    q.add(new int[]{row - 1, col, carryOn + 1});
                }
            }
        }


        return distances;
    }


    public boolean isValidIdx(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
