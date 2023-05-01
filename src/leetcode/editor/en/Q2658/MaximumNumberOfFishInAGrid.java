package leetcode.editor.en.Q2658;
import java.util.*;
import javafx.util.Pair;

//You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) 
//represents: 
//
// 
// A land cell if grid[r][c] = 0, or 
// A water cell containing grid[r][c] fish, if grid[r][c] > 0. 
// 
//
// A fisher can start at any water cell (r, c) and can do the following 
//operations any number of times: 
//
// 
// Catch all the fish at cell (r, c), or 
// Move to any adjacent water cell. 
// 
//
// Return the maximum number of fish the fisher can catch if he chooses his 
//starting cell optimally, or 0 if no water cell exists. 
//
// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 
//1), (r + 1, c) or (r - 1, c) if it exists. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
//Output: 7
//Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move 
//to cell (2,3) and collect 4 fish.
// 
//
// Example 2: 
// 
// 
//Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
//Output: 1
//Explanation: The fisher can start at cells (0,0) or (3,3) and collect a 
//single fish. 
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// 0 <= grid[i][j] <= 10 
// 
//
// 👍 148 👎 12


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] DIRECTIONS = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    };

    Integer[][] cache;
    boolean[][] visiting;

    public int findMaxFish(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    q.add(new int[]{i, j});
                }
            }
        }


        int ans = 0;
        if (q.isEmpty()) return ans;

        cache = new Integer[grid.length][grid[0].length];
        while (!q.isEmpty()) {

            int[] start = q.poll();
            int row = start[0];
            int col = start[1];
            visiting = new boolean[grid.length][grid[0].length];


            ans = Math.max(ans, dfs(row, col, grid));
        }


        return ans;


    }

    private int dfs(int row, int col, int[][] grid) {

        int best = 0;

        if (cache[row][col] != null) {
            return cache[row][col];
        }
        int cell = grid[row][col];
        visiting[row][col] = true;
        grid[row][col] = 0;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (isValidIdx(newRow, newCol, grid)) {
                int fish = grid[newRow][newCol];
                grid[newRow][newCol] = 0;
                best += fish + dfs(newRow, newCol, grid);
                grid[newRow][newCol] = fish;
            }
        }
        best += cell;
        grid[row][col] = cell;
        cache[row][col] = best;
//        visiting[row][col] = false;
        return best;

    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] > 0 && !visiting[row][col];
    }

}


//leetcode submit region end(Prohibit modification and deletion)



public class MaximumNumberOfFishInAGrid extends Solution {}