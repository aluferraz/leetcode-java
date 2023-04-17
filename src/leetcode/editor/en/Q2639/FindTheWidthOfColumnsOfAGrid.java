package leetcode.editor.en.Q2639;
import java.util.*;
import javafx.util.Pair;

//You are given a 0-indexed m x n integer matrix grid. The width of a column is 
//the maximum length of its integers. 
//
// 
// For example, if grid = [[-10], [3], [12]], the width of the only column is 3 
//since -10 is of length 3. 
// 
//
// Return an integer array ans of size n where ans[i] is the width of the iᵗʰ 
//column. 
//
// The length of an integer x with len digits is equal to len if x is non-
//negative, and len + 1 otherwise. 
//
// 
// Example 1: 
//
// 
//Input: grid = [[1],[22],[333]]
//Output: [3]
//Explanation: In the 0ᵗʰ column, 333 is of length 3.
// 
//
// Example 2: 
//
// 
//Input: grid = [[-15,1,3],[15,7,12],[5,6,-2]]
//Output: [3,1,2]
//Explanation: 
//In the 0ᵗʰ column, only -15 is of length 3.
//In the 1ˢᵗ column, all integers are of length 1. 
//In the 2ⁿᵈ column, both 12 and -2 are of length 2.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -10⁹ <= grid[r][c] <= 10⁹ 
// 
//
// 👍 68 👎 3


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            int[] row = grid[i];
            for(int j = 0; j < row.length; j++){
                ans[j] =  Math.max(ans[j], String.valueOf(row[j]).length());
            }

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class FindTheWidthOfColumnsOfAGrid extends Solution {}