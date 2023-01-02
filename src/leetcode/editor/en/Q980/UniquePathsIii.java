package leetcode.editor.en.Q980;

import javafx.util.Pair;

import java.util.*;

//You are given an m x n integer array grid where grid[i][j] could be: 
//
// 
// 1 representing the starting square. There is exactly one starting square. 
// 2 representing the ending square. There is exactly one ending square. 
// 0 representing empty squares we can walk over. 
// -1 representing obstacles that we cannot walk over. 
// 
//
// Return the number of 4-directional walks from the starting square to the 
//ending square, that walk over every non-obstacle square exactly once. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//Output: 2
//Explanation: We have the following two paths: 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
// 
//
// Example 2: 
// 
// 
//Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
//Output: 4
//Explanation: We have the following four paths: 
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
//2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
//3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
//4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
// 
//
// Example 3: 
// 
// 
//Input: grid = [[0,1],[2,0]]
//Output: 0
//Explanation: There is no path that walks over every empty square exactly once.
//
//Note that the starting and ending square can be anywhere in the grid.
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 20 
// 1 <= m * n <= 20 
// -1 <= grid[i][j] <= 2 
// There is exactly one starting cell and one ending cell. 
// 
//
// 👍 4183 👎 160


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 0;
    int emptyCells = 0;
    int[][] directions = new int[][]{
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{-1, 0}
    };
//    HashSet<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> visited =
//            new HashSet<>();
    HashSet<Pair<Integer, Integer>> visiting = new HashSet<>();

    public int uniquePathsIII(int[][] grid) {
        int[] coords = getStartingCell(grid);
        dfs(coords[0], coords[1], 0, grid);
        return result;
    }

    private void dfs(int row, int col, int emptyVisited, int[][] grid) {
        if (grid[row][col] == 0) emptyVisited++;
        if (grid[row][col] == 2) {
            if (emptyVisited == emptyCells) {
                result++;
            }
            return;
        }
        Pair<Integer, Integer> coord = new Pair<>(row, col);
        visiting.add(coord);

        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> key =
                    getCoordsKey(nextRow, nextCol, row, col);
            if (visiting.contains(new Pair<>(nextRow, nextCol))) continue;
            if (isValidIdx(nextRow, nextCol, grid) ) {
//                visited.add(key);
                dfs(nextRow, nextCol, emptyVisited, grid);
            }
        }
        visiting.remove(coord);

    }


    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length &&
                (
                        grid[row][col] == 0 ||
                                grid[row][col] == 2
                );
    }

    private Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> getCoordsKey(int row, int col, int pRow, int pCol) {
        return new Pair<>(new Pair<>(row, col), new Pair<>(pRow, pCol));
    }

    private int[] getStartingCell(int[][] grid) {
        int[] coords = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    coords[0] = i;
                    coords[1] = j;
                }
                if (grid[i][j] == 0) {
                    emptyCells++;
                }
            }
        }
        return coords;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class UniquePathsIii extends Solution {
}