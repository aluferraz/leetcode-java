package leetcode.editor.en.Q909;
import java.util.*;
import javafx.util.Pair;

//You are given an n x n integer matrix board where the cells are labeled from 1
// to n² in a Boustrophedon style starting from the bottom left of the board (i.e.
// board[n - 1][0]) and alternating direction each row. 
//
// You start on square 1 of the board. In each move, starting from square curr, 
//do the following: 
//
// 
// Choose a destination square next with a label in the range [curr + 1, min(
//curr + 6, n²)]. 
// 
//
// 
// This choice simulates the result of a standard 6-sided die roll: i.e., there 
//are always at most 6 destinations, regardless of the size of the board. 
// 
// 
// If next has a snake or ladder, you must move to the destination of that 
//snake or ladder. Otherwise, you move to next. 
// The game ends when you reach the square n². 
//
//
// A board square on row r and column c has a snake or ladder if board[r][c] != 
//-1. The destination of that snake or ladder is board[r][c]. Squares 1 and n² do 
//not have a snake or ladder. 
//
// Note that you only take a snake or ladder at most once per move. If the 
//destination to a snake or ladder is the start of another snake or ladder, you do not 
//follow the subsequent snake or ladder. 
//
// 
// For example, suppose the board is [[-1,4],[-1,3]], and on the first move, 
//your destination square is 2. You follow the ladder to square 3, but do not follow 
//the subsequent ladder to 4. 
// 
//
// Return the least number of moves required to reach the square n². If it is 
//not possible to reach the square, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-
//1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
//Output: 4
//Explanation: 
//In the beginning, you start at square 1 (at row 5, column 0).
//You decide to move to square 2 and must take the ladder to square 15.
//You then decide to move to square 17 and must take the snake to square 13.
//You then decide to move to square 14 and must take the ladder to square 35.
//You then decide to move to square 36, ending the game.
//This is the lowest possible number of moves to reach the last square, so 
//return 4.
// 
//
// Example 2: 
//
// 
//Input: board = [[-1,-1],[-1,3]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == board.length == board[i].length 
// 2 <= n <= 20 
// grid[i][j] is either -1 or in the range [1, n²]. 
// The squares labeled 1 and n² do not have any ladders or snakes. 
// 
//
// 👍 2116 👎 616


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int BOARD_SIZE;
    HashMap<Integer, int[]> positions = new HashMap<>();

    public int snakesAndLadders(int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int target = board.length * board.length;
        int pos = 1;
        boolean backwards = false;
//        int[][] debug = new int[board.length][board[0].length];
        for (int i = board.length - 1; i >= 0; i--) {
            Deque<int[]> posQ = new LinkedList<>();
            for (int j = 0; j < board[i].length; j++) {
                posQ.add(new int[]{i, j});
            }
            if (backwards) {
                while (!posQ.isEmpty()) {
                    int[] coords = posQ.pollLast();
//                    debug[coords[0]][coords[1]] = pos;
                    positions.put(pos, coords);
                    pos++;
                }
            } else {
                while (!posQ.isEmpty()) {
                    int[] coords = posQ.pollFirst();
//                    debug[coords[0]][coords[1]] = pos;
                    positions.put(pos, coords);
                    pos++;
                }
            }
            backwards = !backwards;
        }

        BOARD_SIZE = board.length;
        int[][] visited = new int[board.length][board[0].length];
        visited[board.length - 1][0] = 1;

        int res = Integer.MAX_VALUE;
        q.add(new int[]{1, 0});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] info = q.poll();
                int cell = info[0];
                int moves = info[1];
                int maxDice = Math.min(cell + 6, target);
                for (int j = cell + 1; j <= maxDice; j++) {
                    int nextCell = getCellValue(j, board);
                    if (nextCell == -1) {
                        nextCell = j;
                    }
                    if (nextCell == target) {
                        res = Math.min(res, moves + 1);
                        continue;
                    }
                    if (!markVisited(nextCell, visited)) continue;
                    q.add(new int[]{nextCell, moves + 1});
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int getCellValue(int cell, int[][] matrix) {
        int[] rowCol = numToRowCol(cell);
        int row = rowCol[0];
        int col = rowCol[1];
        return matrix[row][col];
    }

    private boolean markVisited(int cell, int[][] visited) {
        int[] rowCol = numToRowCol(cell);
        int row = rowCol[0];
        int col = rowCol[1];
        if (visited[row][col] == 0) {
            visited[row][col] = 1;
            return true;
        }
        return false;
    }


    private int[] numToRowCol(int num) {
        return positions.get(num);
    }

}
//leetcode submit region end(Prohibit modification and deletion)



public class SnakesAndLadders extends Solution {}