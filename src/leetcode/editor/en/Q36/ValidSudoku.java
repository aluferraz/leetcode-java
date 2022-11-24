package leetcode.editor.en.Q36;

import java.util.*;

//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be 
//validated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
//without repetition. 
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily 
//solvable. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// 
//
// 
// Example 1: 
// 
// 
//Input: board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner 
//being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
//invalid.
// 
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit 1-9 or '.'. 
// 
//
// 👍 7137 👎 830


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, HashSet<Character>> rowMap = new HashMap<>();
        HashMap<Character, HashSet<Character>> colMap = new HashMap<>();
        HashMap<Character, HashSet<Character>> blockMap = new HashMap<>();
        for (int row = 0; row < board.length; row++) {
            HashSet<Character> rowSet = getSet(String.valueOf(row).charAt(0), rowMap);
            for (int col = 0; col < board[row].length; col++) {
                HashSet<Character> colSet = getSet(String.valueOf(col).charAt(0), colMap);
                HashSet<Character> blockSet = getSet(getBlock(row, col), blockMap);
                char cellValue = board[row][col];
                if (cellValue == '.') continue;
                if (rowSet.contains(cellValue)) return false;
                rowSet.add(cellValue);
                if (colSet.contains(cellValue)) return false;
                colSet.add(cellValue);
                if (blockSet.contains(cellValue)) return false;
                blockSet.add(cellValue);
            }
        }


        return true;
    }

    private char getBlock(int row, int col) {
        if (row >= 0 && row <= 2) {
            if (col >= 0 && col <= 2) return '1';
            if (col >= 3 && col <= 5) return '2';
            if (col >= 6 && col <= 8) return '3';
        }
        if (row >= 2 && row <= 5) {
            if (col >= 0 && col <= 2) return '4';
            if (col >= 3 && col <= 5) return '5';
            if (col >= 6 && col <= 8) return '6';
        }
        if (row >= 6 && row <= 8) {
            if (col >= 0 && col <= 2) return '7';
            if (col >= 3 && col <= 5) return '8';
            if (col >= 6 && col <= 8) return '9';
        }
        return '0';

    }

    private HashSet<Character> getSet(Character key, HashMap<Character, HashSet<Character>> map) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        HashSet<Character> newSet = new HashSet<Character>();
        map.put(key, newSet);
        return newSet;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class ValidSudoku extends Solution {
}