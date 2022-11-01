package leetcode.editor.en.Q1706;

//You have a 2-D grid of size m x n representing a box, and you have n balls. 
//The box is open on the top and bottom sides. 
//
// Each cell in the box has a diagonal board spanning two corners of the cell 
//that can redirect a ball to the right or to the left. 
//
// 
// A board that redirects the ball to the right spans the top-left corner to 
//the bottom-right corner and is represented in the grid as 1. 
// A board that redirects the ball to the left spans the top-right corner to 
//the bottom-left corner and is represented in the grid as -1. 
// 
//
// We drop one ball at the top of each column of the box. Each ball can get 
//stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" 
//shaped pattern between two boards or if a board redirects the ball into either wall 
//of the box. 
//
// Return an array answer of size n where answer[i] is the column that the ball 
//falls out of at the bottom after dropping the ball from the iᵗʰ column at the 
//top, or -1 if the ball gets stuck in the box. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,
//-1,-1,-1]]
//Output: [1,-1,-1,-1,-1]
//Explanation: This example is shown in the photo.
//Ball b0 is dropped at column 0 and falls out of the box at column 1.
//Ball b1 is dropped at column 1 and will get stuck in the box between column 2 
//and 3 and row 1.
//Ball b2 is dropped at column 2 and will get stuck on the box between column 2 
//and 3 and row 0.
//Ball b3 is dropped at column 3 and will get stuck on the box between column 2 
//and 3 and row 0.
//Ball b4 is dropped at column 4 and will get stuck on the box between column 2 
//and 3 and row 1.
// 
//
// Example 2: 
//
// 
//Input: grid = [[-1]]
//Output: [-1]
//Explanation: The ball gets stuck against the left wall.
// 
//
// Example 3: 
//
// 
//Input: grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1
//,-1]]
//Output: [0,1,2,3,4,-1]
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// grid[i][j] is 1 or -1. 
// 
//
// 👍 1650 👎 119


import java.util.*;


public class WhereWillTheBallFall {
    public static int[] findBall(int[][] grid) {
        Solution s = new Solution();
        return s.findBall(grid);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        Arrays.fill(result, -1);
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        HashMap<Integer, int[]> validMoves = new HashMap<>();
        //disable VShapes
        for (int[] row : grid) {
            for (int i = 0; i < row.length - 1; i++) {
                int direction = row[i];
                int nextDirection = row[i + 1];
                boolean VShape = direction == 1 && nextDirection == -1;
                if (VShape) {
                    row[i] = 0;
                    row[i + 1] = 0;
                }
            }
        }
        //Init queue
        for (int i = 0; i < grid[0].length; i++) {
            int direction = grid[0][i];
            if (direction == 0) continue;
            visited[0][i] = i + 1;
            this.move(0, i, i, direction, visited, validMoves, result);
        }
        this.queueNextMoves(validMoves, queue);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.remove();
                int row = pos[0];
                int col = pos[1];
                int cameFrom = pos[2];
                int direction = grid[row][col];
                if (direction == 0) continue;
                this.move(row, col, cameFrom, direction, visited, validMoves, result);
            }
            this.queueNextMoves(validMoves, queue);
        }
        return result;
    }

    private void queueNextMoves(HashMap<Integer, int[]> validMoves, Queue<int[]> queue) {
        for (Map.Entry<Integer, int[]> entry : validMoves.entrySet()) {
            queue.add(entry.getValue());
        }
        validMoves.clear();
    }

    private void move(int row, int col, int cameFrom, int direction, int[][] visited, HashMap<Integer, int[]> validMoves, int[] result) {
        int nextRow = row + 1;
        int nextCol = col + direction;
        int targetRow = visited.length;
        if (isValidIdx(nextRow, nextCol, visited)) {
            if (visited[nextRow][nextCol] != 0) {
                int colToRemove = visited[nextRow][nextCol];
                validMoves.remove(colToRemove);
            } else {
                validMoves.put((col + 1), new int[]{nextRow, (nextCol), cameFrom});
            }
            visited[nextRow][nextCol] = (col + 1);
        } else {
            if (nextRow == targetRow && nextCol >= 0 && nextCol < visited[row].length) {
                result[cameFrom] = nextCol;
            }
        }
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
