package leetcode.editor.en.Q474;

import java.util.*;

import javafx.util.Pair;

//You are given an array of binary strings strs and two integers m and n. 
//
// Return the size of the largest subset of strs such that there are at most m 0
//'s and n 1's in the subset. 
//
// A set x is a subset of a set y if all elements of x are also elements of y. 
//
// 
// Example 1: 
//
// 
//Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
//Output: 4
//Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001",
// "1", "0"}, so the answer is 4.
//Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
//{"111001"} is an invalid subset because it contains 4 1's, greater than the 
//maximum of 3.
// 
//
// Example 2: 
//
// 
//Input: strs = ["10","0","1"], m = 1, n = 1
//Output: 2
//Explanation: The largest subset is {"0", "1"}, so the answer is 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] consists only of digits '0' and '1'. 
// 1 <= m, n <= 100 
// 
//
// 👍 4802 👎 423


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer cache[][][];

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] counter = new int[strs.length][2];
        cache = new Integer[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                counter[i][Character.getNumericValue(s.charAt(j))]++;
            }
        }

        return findMaxForm(0, counter, m, n);
    }

    private int findMaxForm(int i, int[][] strs, int m, int n) {
        if (i == strs.length) {
            return 0;
        }

        if (cache[i][m][n] != null) return cache[i][m][n];
        int zeros = strs[i][0];
        int ones = strs[i][1];

        if (zeros > m || ones > n) {
            cache[i][m][n] = findMaxForm(i + 1, strs, m, n);
            return cache[i][m][n];
        }


        int ans = Math.max(findMaxForm(i + 1, strs, m, n), 1 + findMaxForm(i + 1, strs, m - zeros, n - ones));


        cache[i][m][n] = ans;
        return cache[i][m][n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class OnesAndZeroes extends Solution {
}