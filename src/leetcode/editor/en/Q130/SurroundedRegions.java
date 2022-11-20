package leetcode.editor.en.Q130;

import java.util.*;

//Given an m x n matrix board containing 'X' and 'O', capture all regions that 
//are 4-directionally surrounded by 'X'. 
//
// A region is captured by flipping all 'O's into 'X's in that surrounded 
//region. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]]
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]]
//Explanation: Notice that an 'O' should not be flipped if:
//- It is on the border, or
//- It is adjacent to an 'O' that should not be flipped.
//The bottom 'O' is on the border, so it is not flipped.
//The other three 'O' form a surrounded region, so they are flipped.
// 
//
// Example 2: 
//
// 
//Input: board = [["X"]]
//Output: [["X"]]
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] is 'X' or 'O'. 
// 
//
// 👍 6121 👎 1381


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class CellValue {
        public char val;
        public int row;
        public int col;
        public boolean seen;

        public CellValue(char val, int row, int col) {
            this.val = val;
            this.seen = false;
            this.row = row;
            this.col = col;
        }
    }

    public void solve(char[][] board) {
        CellValue[][] cellValues = new CellValue[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                CellValue running = cellValues[i][j] == null ? new CellValue(board[i][j], i, j) : cellValues[i][j];
                cellValues[i][j] = running;
                flip(board, i, j, cellValues, running);
                running.seen = true;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = cellValues[i][j].val;
            }
        }

    }

    private boolean flip(char[][] board, int row, int col, CellValue[][] cellValues, CellValue running) {

        if(row == 4 && col == 5){
            int a = 1;
        }
        if (!isValidIdx(row, col, board)) return false;
        if (board[row][col] == 'X') return true;
        if (cellValues[row][col] != null && cellValues[row][col].seen) {
            return cellValues[row][col].val == 'X';
        }
        cellValues[row][col] = running;
        board[row][col] = 'X'; //Try it
        if (
        /**It is very important to start from up and left, because
         * the main loop already evaluated those itens.
         * See test-case at the bottom for better understanding.
         *
         */
                flip(board, row - 1, col, cellValues, running) &&
                        flip(board, row, col - 1, cellValues, running) &&
                        flip(board, row + 1, col, cellValues, running) &&
                        flip(board, row, col + 1, cellValues, running)

        ) {
            running.val = 'X';
            return true; //Success
        }
        board[row][col] = 'O'; // Fail
        running.val = board[row][col];
        return false;
    }


    private boolean isValidIdx(int row, int col, char[][] grid) {
        return row >= 0 &&  //Borders are not accepted
                row < grid.length  && //Borders are not accepted
                col >= 0 &&
                col < grid[row].length ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SurroundedRegions extends Solution {
    /**
     * [
     *     ["O","X","O","O","O","X"],
     *     ["O","O","X","X","X","O"],
     *     ["X","X","X","X","X","O"],
     *     ["O","O","O","O","X","X"],
     *     ["X","X","O","O","X","O"],
     *     ["O","O","X","X","X","X"],
     * ]
     */
}