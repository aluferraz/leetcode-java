package leetcode.editor.en.Q1463;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{1, -1},
            new int[]{1, 0},
            new int[]{1, 1}
    };

    Integer[][][] cache;

    public int cherryPickup(int[][] grid) {
        cache = new Integer[grid.length][grid[0].length][grid[0].length];
        return cherryPickup(0, 0, grid[0].length - 1, grid);
    }

    private int cherryPickup(int row, int col1, int col2, int[][] grid) {
        if (row == grid.length) return 0;
        int colBoundary = grid[row].length;
        int score = (col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2]);
        if (cache[row][col1][col2] != null) {
            return cache[row][col1][col2];
        }
        int best = score;
        for (int[] dir1 : DIRECTIONS) {
            int newCol1 = col1 + dir1[1];
            if (newCol1 >= 0 && newCol1 < colBoundary) {
                for (int[] dir2 : DIRECTIONS) {
                    int newCol2 = col2 + dir2[1];
                    if (newCol2 >= 0 && newCol2 < colBoundary) {
                        best = Math.max(best, score + cherryPickup(row + 1, newCol1, newCol2, grid));
                    }
                }
            }
        }
        cache[row][col1][col2] = best;

        return best;


    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class CherryPickupIi extends Solution {
}