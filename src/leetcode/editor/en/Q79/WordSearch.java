package leetcode.editor.en.Q79;

import java.util.*;

//Given an m x n grid of characters board and a string word, return true if 
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
//
// 👍 11896 👎 482


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final int VISITING = 1;

    public boolean exist(char[][] board, String word) {
        int[][] cacheVisited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrackFind(board, i, j, word, 0, cacheVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrackFind(char[][] board, int row, int col, String word, int pos, int[][] cacheVisited) {
        if (pos == word.length()) return true;
        if (!isValidIdx(row, col, board)) return false;
        if (cacheVisited[row][col] == VISITING) return false;
        cacheVisited[row][col] = VISITING;
        char target = word.charAt(pos);
        char cellValue = board[row][col];
        if (cellValue != target) {
            cacheVisited[row][col] = 0;
            return false;
        }
        if (backtrackFind(board, row - 1, col, word, pos + 1, cacheVisited)) return true;
        if (backtrackFind(board, row + 1, col, word, pos + 1, cacheVisited)) return true;
        if (backtrackFind(board, row, col - 1, word, pos + 1, cacheVisited)) return true;
        if (backtrackFind(board, row, col + 1, word, pos + 1, cacheVisited)) return true;
        cacheVisited[row][col] = 0;
        return false;
    }


    private boolean isValidIdx(int row, int col, char[][] grid) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class WordSearch extends Solution {
}