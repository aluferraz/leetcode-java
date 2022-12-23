package leetcode.editor.en.Q174;

import javafx.util.Pair;

import java.util.*;

//The demons had captured the princess and imprisoned her in the bottom-right 
//corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. 
//Our valiant knight was initially positioned in the top-left room and must fight 
//his way through dungeon to rescue the princess. 
//
// The knight has an initial health point represented by a positive integer. If 
//at any point his health point drops to 0 or below, he dies immediately. 
//
// Some of the rooms are guarded by demons (represented by negative integers), 
//so the knight loses health upon entering these rooms; other rooms are either 
//empty (represented as 0) or contain magic orbs that increase the knight's health (
//represented by positive integers). 
//
// To reach the princess as quickly as possible, the knight decides to move 
//only rightward or downward in each step. 
//
// Return the knight's minimum initial health so that he can rescue the 
//princess. 
//
// Note that any room can contain threats or power-ups, even the first room the 
//knight enters and the bottom-right room where the princess is imprisoned. 
//
// 
// Example 1: 
// 
// 
//Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
//Output: 7
//Explanation: The initial health of the knight must be at least 7 if he 
//follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
// 
//
// Example 2: 
//
// 
//Input: dungeon = [[0]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == dungeon.length 
// n == dungeon[i].length 
// 1 <= m, n <= 200 
// -1000 <= dungeon[i][j] <= 1000 
// 
//
// 👍 4789 👎 87


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Integer[][] cache;
    int[][] grid;

    public int calculateMinimumHP(int[][] dungeon) {
        cache = new Integer[dungeon.length][dungeon[0].length];
        grid = dungeon;
        int health = calculateMinimumHP(0, 0);
        return health <= 0 ? Math.abs(health) + 1 : 1;
    }

    public int calculateMinimumHP(int row, int col) {
        if (row == grid.length - 1 && col == grid[row].length - 1) {
            return grid[row][col];
        }
        if (cache[row][col] != null) return cache[row][col];
        int path_down = (isValidIdx(row + 1, col, grid) ? grid[row][col] + calculateMinimumHP(row + 1, col) : Integer.MIN_VALUE);
        int path_right = (isValidIdx(row, col + 1, grid) ? grid[row][col] + calculateMinimumHP(row, col + 1) : Integer.MIN_VALUE);
        // if positive, we do not need to add health
        path_down = Math.min(path_down, grid[row][col]);
        path_right = Math.min(path_right, grid[row][col]);

        cache[row][col] = Math.max(path_down, path_right);
        return cache[row][col];
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class DungeonGame extends Solution {
}