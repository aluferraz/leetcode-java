package leetcode.editor.en.Q37;

import java.util.*;

//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-
//boxes of the grid. 
// 
//
// The '.' character indicates empty cells. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5
//",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".
//",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".
//","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5
//"],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4
//","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3
//"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],[
//"9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3",
//"4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is 
//shown below:
// 
//
//
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit or '.'. 
// It is guaranteed that the input board has only one solution. 
// 
//
// 👍 7016 👎 188


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
    private HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
    private HashMap<Integer, HashSet<Character>> blocks = new HashMap<>();


    public void solveSudoku(char[][] board) {
        initSets(board);
        solve(0, 0, board);
    }

    private boolean solve(int row, int col, char[][] board) {
        if (row == board.length && col == 0) {
            return true; // Finished the board
        }
        if (board[row][col] != '.') {
            if (col == 8) return solve(row + 1, 0, board);
            return solve(row, col + 1, board);
        }
        int block = getBlock(row, col);

        for (int i = 1; i <= 9; i++) {
            char candidate = Character.forDigit(i, 10);

            if (!rows.get(row).contains(candidate) &&
                    !cols.get(col).contains(candidate) &&
                    !blocks.get(block).contains(candidate)
            ) {

                rows.get(row).add(candidate);
                cols.get(col).add(candidate);
                blocks.get(block).add(candidate);
                board[row][col] = candidate;

                if (col == 8) {
                    if (solve(row + 1, 0, board)) return true;
                } else {
                    if (solve(row, col + 1, board)) return true;
                }
                board[row][col] = '.';
                rows.get(row).remove(candidate);
                cols.get(col).remove(candidate);
                blocks.get(block).remove(candidate);
            }
        }

        return false;
    }

    private void initSets(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = rows.getOrDefault(i, new HashSet<>());
            for (int j = 0; j < board[i].length; j++) {
//                 continue;
                int block = getBlock(i, j);
                HashSet<Character> colSet = cols.getOrDefault(j, new HashSet<>());
                HashSet<Character> blockSet = blocks.getOrDefault(block, new HashSet<>());
                if (board[i][j] != '.') {
                    rowSet.add(board[i][j]);
                    colSet.add(board[i][j]);
                    blockSet.add(board[i][j]);
                }
                cols.put(j, colSet);
                blocks.put(block, blockSet);
            }
            rows.put(i, rowSet);
        }
    }

    private int getBlock(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) return 0;
        if (row >= 0 && row <= 2 && col >= 3 && col <= 5) return 1;
        if (row >= 0 && row <= 2 && col >= 6) return 2;

        if (row >= 3 && row <= 5 && col >= 0 && col <= 2) return 3;
        if (row >= 3 && row <= 5 && col >= 3 && col <= 5) return 4;
        if (row >= 3 && row <= 5 && col >= 6) return 5;

        if (row >= 6 && col >= 0 && col <= 2) return 6;
        if (row >= 6 && col >= 3 && col <= 5) return 7;
        return 8;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SudokuSolver extends Solution {
}