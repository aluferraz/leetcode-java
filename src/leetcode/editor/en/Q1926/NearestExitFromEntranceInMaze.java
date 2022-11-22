package leetcode.editor.en.Q1926;

import java.util.*;

//You are given an m x n matrix maze (0-indexed) with empty cells (represented 
//as '.') and walls (represented as '+'). You are also given the entrance of the 
//maze, where entrance = [entrancerow, entrancecol] denotes the row and column of 
//the cell you are initially standing at. 
//
// In one step, you can move one cell up, down, left, or right. You cannot step 
//into a cell with a wall, and you cannot step outside the maze. Your goal is to 
//find the nearest exit from the entrance. An exit is defined as an empty cell 
//that is at the border of the maze. The entrance does not count as an exit. 
//
// Return the number of steps in the shortest path from the entrance to the 
//nearest exit, or -1 if no such path exists. 
//
// 
// Example 1: 
// 
// 
//Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], 
//entrance = [1,2]
//Output: 1
//Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
//Initially, you are at the entrance cell [1,2].
//- You can reach [1,0] by moving 2 steps left.
//- You can reach [0,2] by moving 1 step up.
//It is impossible to reach [2,3] from the entrance.
//Thus, the nearest exit is [0,2], which is 1 step away.
// 
//
// Example 2: 
// 
// 
//Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
//Output: 2
//Explanation: There is 1 exit in this maze at [1,2].
//[1,0] does not count as an exit since it is the entrance cell.
//Initially, you are at the entrance cell [1,0].
//- You can reach [1,2] by moving 2 steps right.
//Thus, the nearest exit is [1,2], which is 2 steps away.
// 
//
// Example 3: 
// 
// 
//Input: maze = [[".","+"]], entrance = [0,0]
//Output: -1
//Explanation: There are no exits in this maze.
// 
//
// 
// Constraints: 
//
// 
// maze.length == m 
// maze[i].length == n 
// 1 <= m, n <= 100 
// maze[i][j] is either '.' or '+'. 
// entrance.length == 2 
// 0 <= entrancerow < m 
// 0 <= entrancecol < n 
// entrance will always be an empty cell. 
// 
//
// 👍 1049 👎 45


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final char EMPTY = '.';
    private static final char WALL = '+';

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList();
        queue.add(entrance);
        boolean foundExit = false;
        int steps = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                maze[row][col] = WALL; //Visited
                if (queueOrExit(row + 1, col, maze, queue, entrance, current)) {
                    foundExit = true;
                    break;
                }
                if (queueOrExit(row - 1, col, maze, queue, entrance, current)) {
                    foundExit = true;
                    break;
                }
                if (queueOrExit(row, col + 1, maze, queue, entrance, current)) {
                    foundExit = true;
                    break;
                }
                if (queueOrExit(row, col - 1, maze, queue, entrance, current)) {
                    foundExit = true;
                    break;
                }
            }
            if (!foundExit) {
                steps++;
            }
        }
        return foundExit ? steps : -1;
    }

    private boolean queueOrExit(int row, int col, char[][] maze, Queue<int[]> queue, int[] entrance, int[] current) {
        int[] next = new int[]{row, col};
        if (isValidIdx(row, col, maze)) {
            if (maze[row][col] == EMPTY) {
                maze[row][col] = WALL; //Visited
                queue.add(next);
                return false;
            }
            return false;
        } else if (!Arrays.equals(entrance, current)) {
            queue.clear();
            return true;
        }
        return false;

    }

    private boolean isValidIdx(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NearestExitFromEntranceInMaze extends Solution {
}