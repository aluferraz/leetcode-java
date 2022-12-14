package leetcode.editor.en.Q51;

import java.util.*;

//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//You may return the answer in any order. 
//
// Each solution contains a distinct board configuration of the n-queens' 
//placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as 
//shown above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
//
// 👍 8900 👎 197


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //    private static final char ATTACK = 'X';
    private static final char QUEEN = 'Q';
    private static final char EMPTY = '.';

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, EMPTY);
        }
        placeQueen(0, 0, board);
        return result;
    }

    private boolean placeQueen(int row, int col, char[][] board) {
        if (row == board.length) {
            // We reached the bottom successfully
            fillResult(board);
            return true;
        }
        if (!isValidIdx(row, col, board)) {
            return false;
        }
        if (board[row][col] != EMPTY) {
            return placeQueen(row, col + 1, board);
        }
        board[row][col] = QUEEN;
        placeValue(row, col, Character.forDigit(row, 10), board);
        placeQueen(row + 1, 0, board);
        //Undo and try next col
        placeValue(row, col, EMPTY, board);
        board[row][col] = EMPTY;
        return placeQueen(row, col + 1, board);
    }

    private void fillResult(char[][] board) {
        ArrayList<String> boardSolution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == QUEEN) row.append(QUEEN);
                else row.append(EMPTY);
            }
            boardSolution.add(row.toString());
        }
        result.add(boardSolution);
    }

    private void placeValue(int row, int col, char value, char[][] board) {
        if (!isValidIdx(row, col, board)) return;

        int chRow = row + 1;
        int chCol = col;
        char queenValue = Character.forDigit(row, 10);
        while (isValidIdx(chRow, chCol, board)) {
            if (board[chRow][chCol] == EMPTY || board[chRow][chCol] == queenValue) {
                board[chRow][chCol] = value;
            }
            chRow++;
        }
        chRow = row + 1;
        chCol = col + 1;
        while (isValidIdx(chRow, chCol, board)) {
            if (board[chRow][chCol] == EMPTY || board[chRow][chCol] == queenValue) {
                board[chRow][chCol] = value;
            }
            chRow++;
            chCol++;
        }
        chRow = row + 1;
        chCol = col - 1;
        while (isValidIdx(chRow, chCol, board)) {
            if (board[chRow][chCol] == EMPTY || board[chRow][chCol] == queenValue) {
                board[chRow][chCol] = value;
            }
            chRow++;
            chCol--;
        }
    }

    private boolean isValidIdx(int row, int col, char[][] board) {
        return row >= 0 &&
                row < board.length &&
                col >= 0 &&
                col < board[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NQueens extends Solution {
}