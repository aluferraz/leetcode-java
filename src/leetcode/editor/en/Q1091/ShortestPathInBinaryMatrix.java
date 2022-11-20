package leetcode.editor.en.Q1091;

import java.util.*;

//Given an n x n binary matrix grid, return the length of the shortest clear 
//path in the matrix. If there is no clear path, return -1. 
//
// A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0
//)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that: 
//
// 
// All the visited cells of the path are 0. 
// All the adjacent cells of the path are 8-directionally connected (i.e., they 
//are different and they share an edge or a corner). 
// 
//
// The length of a clear path is the number of visited cells of this path. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[0,1],[1,0]]
//Output: 2
// 
//
// Example 2: 
// 
// 
//Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] is 0 or 1 
// 
//
// 👍 4147 👎 174


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int VISITED = 2;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        //int[][][] backtrack = new int[grid.length][grid[0].length][2];
        int[] target = new int[]{grid.length - 1, grid[grid.length - 1].length - 1};
        // backtrack[target[0]][target[1]] = new int[]{-1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int steps = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.remove();


                int row = pos[0];
                int col = pos[1];

                grid[row][col] = VISITED;
                if (Arrays.equals(pos, target)) {
                    queue.clear();
                    break;
                }
                //Greedy path
                if (isValidIdx(row + 1, col + 1, grid)) {
                    //backtrack[row + 1][col + 1] = pos;
                    grid[row + 1][col + 1] = VISITED;
                    queue.add(new int[]{row + 1, col + 1});
                }

                if (isValidIdx(row + 1, col, grid)) {
                    //backtrack[row + 1][col] = pos;
                    grid[row + 1][col] = VISITED;
                    queue.add(new int[]{row + 1, col});
                }
                if (isValidIdx(row, col + 1, grid)) {
                    // backtrack[row][col + 1] = pos;
                    grid[row][col + 1] = VISITED;
                    queue.add(new int[]{row, col + 1});
                }
                //Other paths
                if (isValidIdx(row - 1, col, grid)) {
                    //  backtrack[row - 1][col] = pos;
                    grid[row - 1][col] = VISITED;
                    queue.add(new int[]{row - 1, col});
                }
                if (isValidIdx(row, col - 1, grid)) {
                    //backtrack[row][col - 1] = pos;
                    grid[row][col - 1] = VISITED;
                    queue.add(new int[]{row, col - 1});
                }

                if (isValidIdx(row - 1, col - 1, grid)) {
                    //backtrack[row - 1][col - 1] = pos;
                    grid[row - 1][col - 1] = VISITED;
                    queue.add(new int[]{row - 1, col - 1});
                }
                if (isValidIdx(row - 1, col + 1, grid)) {
                    //backtrack[row - 1][col - 1] = pos;
                    grid[row - 1][col + 1] = VISITED;
                    queue.add(new int[]{row - 1, col + 1});
                }
                if (isValidIdx(row + 1, col - 1, grid)) {
                    //backtrack[row - 1][col - 1] = pos;
                    grid[row + 1][col - 1] = VISITED;
                    queue.add(new int[]{row + 1, col - 1});
                }
            }
            steps++;
        }

        if (grid[target[0]][target[1]] != VISITED) return -1;
        return steps;
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length &&
                col >= 0 && col < grid[row].length
                && grid[row][col] == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ShortestPathInBinaryMatrix extends Solution {
}