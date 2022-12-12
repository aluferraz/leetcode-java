package leetcode.editor.en.Q1368;

import java.util.*;

//Given an m x n grid. Each cell of the grid has a sign pointing to the next 
//cell you should visit if you are currently in this cell. The sign of grid[i][j] 
//can be: 
//
// 
// 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i]
//[j + 1]) 
// 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][
//j - 1]) 
// 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j]
//) 
// 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j]
//) 
// 
//
// Notice that there could be some signs on the cells of the grid that point 
//outside the grid. 
//
// You will initially start at the upper left cell (0, 0). A valid path in the 
//grid is a path that starts from the upper left cell (0, 0) and ends at the 
//bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does 
//not have to be the shortest. 
//
// You can modify the sign on a cell with cost = 1. You can modify the sign on 
//a cell one time only. 
//
// Return the minimum cost to make the grid have at least one valid path. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
//Output: 3
//Explanation: You will start at point (0, 0).
//The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) 
//change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) 
//change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3
//) change the arrow to down with cost = 1 --> (3, 3)
//The total cost = 3.
// 
//
// Example 2: 
// 
// 
//Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
//Output: 0
//Explanation: You can follow the path from (0, 0) to (2, 2).
// 
//
// Example 3: 
// 
// 
//Input: grid = [[1,2],[4,3]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// 1 <= grid[i][j] <= 4 
// 
//
// 👍 1390 👎 13


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int RIGHT = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;
    private static final int UP = 4;

    public int minCost(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        HashMap<String, Integer> visited = new HashMap();
        visited.put("0:0", 0);
        int m = grid.length - 1;
        int n = grid[m].length - 1;
        int result = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int cost = current[2];
                if (row == m && col == n) {
                    result = Math.min(cost, result);
                    //return cost;
                    continue;
                }
                int direction = grid[row][col];
                int[] next = getCoords(row, col, direction);
                boolean valid = queueNext(next, cost, grid, queue, visited);
                if (!valid) {
                    for (int j = RIGHT; j <= UP; j++) {
                        next = getCoords(row, col, j);
                        queueNext(next, (j == direction ? cost : cost + 1), grid, queue, visited); //Will only queue valid coords
                    }
                } else {
                    if (direction != RIGHT) {
                        next = getCoords(row, col, RIGHT);
                        queueNext(next, cost + 1, grid, queue, visited);
                    }
                    if (direction != DOWN) {
                        next = getCoords(row, col, DOWN);
                        queueNext(next, cost + 1, grid, queue, visited);
                    }
                }
            }
        }
        return result;

    }

    private boolean queueNext(int[] next, int cost, int[][] grid, Queue<int[]> queue, HashMap<String, Integer> visited) {
        String key = next[0] + ":" + next[1];
        if (visited.getOrDefault(key, Integer.MAX_VALUE) <= cost) return false;
        if (isValidIdx(next[0], next[1], grid)) {
            visited.put(key, cost);
            queue.add(new int[]{next[0], next[1], cost});
            return true;
        }
        return false;
    }

    private int[] getCoords(int row, int col, int direction) {
        switch (direction) {
            case RIGHT:
                return new int[]{row, col + 1};
            case LEFT:
                return new int[]{row, col - 1};
            case DOWN:
                return new int[]{row + 1, col};
            case UP:
                return new int[]{row - 1, col};
        }
        return new int[]{-1, -1};
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumCostToMakeAtLeastOneValidPathInAGrid extends Solution {
}