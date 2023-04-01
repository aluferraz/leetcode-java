package leetcode.editor.en.Q1444;

import java.util.*;

import javafx.util.Pair;

//Given a rectangular pizza represented as a rows x cols matrix containing the 
//following characters: 'A' (an apple) and '.' (empty cell) and given the integer 
//k. You have to cut the pizza into k pieces using k-1 cuts. 
//
// For each cut you choose the direction: vertical or horizontal, then you 
//choose a cut position at the cell boundary and cut the pizza into two pieces. If you 
//cut the pizza vertically, give the left part of the pizza to a person. If you 
//cut the pizza horizontally, give the upper part of the pizza to a person. Give 
//the last piece of pizza to the last person. 
//
// Return the number of ways of cutting the pizza such that each piece contains 
//at least one apple. Since the answer can be a huge number, return this modulo 10
//^9 + 7. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: pizza = ["A..","AAA","..."], k = 3
//Output: 3 
//Explanation: The figure above shows the three ways to cut the pizza. Note 
//that pieces must contain at least one apple.
// 
//
// Example 2: 
//
// 
//Input: pizza = ["A..","AA.","..."], k = 3
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: pizza = ["A..","A..","..."], k = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= rows, cols <= 50 
// rows == pizza.length 
// cols == pizza[i].length 
// 1 <= k <= 10 
// pizza consists of characters 'A' and '.' only. 
// 
//
// 👍 1051 👎 62


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final long MOD = 1000000007L;
    HashMap<String, Long> cache = new HashMap<>();

    int m = 0;
    int n = 0;

    public int ways(String[] pizza, int k) {
        int[][] presumPizza = presumMatrix(pizza);
        this.m = presumPizza.length - 1;
        this.n = presumPizza[presumPizza.length - 1].length - 1;
        Long res = (
                dfs(0, 0, 0, 0, k - 1, presumPizza)
                        % MOD);
        return res.intValue();
    }

    private long dfs(
            int startingRow,
            int startingCol,
            int endingRow,
            int endingCol,
            int k,
            int[][] presum) {
        if (k == 0) {
            return getTotalApples(startingRow, startingCol, m, n, presum) >= 1 ? 1L : 0L;
        }

        String cacheKey = startingRow + ":" + startingCol + ":" + endingRow + ":" + endingCol + k;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        long res = 0;

        for (int i = endingCol; i <= n; i++) {
            int totalApples = getTotalApples(
                    startingRow,
                    startingCol,
                    m,
                    i,
                    presum
            );
            if (totalApples >= 1 && isValidIdx(startingRow, i + 1, presum)) {
                res += dfs(startingRow, i + 1, endingRow, i + 1, k - 1, presum);
            }
        }

        for (int i = endingRow; i <= m; i++) {
            int totalApples = getTotalApples(
                    startingRow,
                    startingCol,
                    i,
                    n,
                    presum
            );
            if (totalApples >= 1 && isValidIdx(i + 1, startingCol, presum)) {
                res += dfs(i + 1, startingCol, i + 1, endingCol, k - 1, presum);
            }
        }

        cache.put(cacheKey, res);

        return res;

    }

    private int getTotalApples(
            int startingRow,
            int startingCol,
            int endingRow,
            int endingCol,
            int[][] presum) {

        int total = presum[endingRow][endingCol];
        int rowAbove = (startingRow > 0 ? presum[startingRow - 1][endingCol] : 0);
        int colLeft = (startingCol > 0 ? presum[endingRow][startingCol - 1] : 0);
        int doubleRemoved = ((startingRow > 0 && startingCol > 0) ? presum[startingRow - 1][startingCol - 1] : 0);
        return total - rowAbove - colLeft + doubleRemoved;
    }


    private boolean isValidIdx(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private int[][] presumMatrix(String[] pizza) {
        int y = pizza.length;
        int x = pizza[0].length();
        int[][] presum = new int[y][x];
        presum[0][0] = pizzaToInt(0, 0, pizza);
        for (int i = 1; i < y; i++) {
            presum[i][0] = presum[i - 1][0] + pizzaToInt(i, 0, pizza);
        }
        for (int i = 1; i < x; i++) {
            presum[0][i] = presum[0][i - 1] + pizzaToInt(0, i, pizza);
        }

        for (int i = 1; i < y; i++) {
            for (int j = 1; j < x; j++) {
                presum[i][j] = pizzaToInt(i, j, pizza) +
                        presum[i - 1][j] +
                        presum[i][j - 1] -
                        presum[i - 1][j - 1];

            }
        }
        return presum;

    }

    private int pizzaToInt(int row, int col, String[] pizza) {
        return pizza[row].charAt(col) == 'A' ? 1 : 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfWaysOfCuttingAPizza extends Solution {
}