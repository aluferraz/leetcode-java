package leetcode.editor.en.Q864;

import java.util.*;

//You are given an m x n grid grid where: 
//
// 
// '.' is an empty cell. 
// '#' is a wall. 
// '@' is the starting point. 
// Lowercase letters represent keys. 
// Uppercase letters represent locks. 
// 
//
// You start at the starting point and one move consists of walking one space 
//in one of the four cardinal directions. You cannot walk outside the grid, or walk 
//into a wall. 
//
// If you walk over a key, you can pick it up and you cannot walk over a lock 
//unless you have its corresponding key. 
//
// For some 1 <= k <= 6, there is exactly one lowercase and one uppercase 
//letter of the first k letters of the English alphabet in the grid. This means that 
//there is exactly one key for each lock, and one lock for each key; and also that 
//the letters used to represent the keys and locks were chosen in the same order as 
//the English alphabet. 
//
// Return the lowest number of moves to acquire all keys. If it is impossible, 
//return -1. 
//
// 
// Example 1: 
// 
// 
//Input: grid = ["@.a..","###.#","b.A.B"]
//Output: 8
//Explanation: Note that the goal is to obtain all the keys not to open all the 
//locks.
// 
//
// Example 2: 
// 
// 
//Input: grid = ["@..aA","..B#.","....b"]
//Output: 6
// 
//
// Example 3: 
// 
// 
//Input: grid = ["@Aa"]
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 30 
// grid[i][j] is either an English letter, '.', '#', or '@'. 
// The number of keys in the grid is in the range [1, 6]. 
// Each key in the grid is unique. 
// Each key in the grid has a matching lock. 
// 
//
// 👍 920 👎 39


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final static char WALL = '#';

    public int shortestPathAllKeys(String[] grid) {
//        int keyCount = 0;
        int[] coords = new int[]{-1, -1, 0};
        HashSet<String> visited = new HashSet<>();
        char[][] board = new char[grid.length][grid[0].length()];

        StringBuilder sb = new StringBuilder("000000");


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
//                    keyCount++;
                    sb.setCharAt(grid[i].charAt(j) - 'a', '1');
                }
                if (grid[i].charAt(j) == '@') {
                    coords = new int[]{i, j, 0};
                    visited.add(getVisitedKey(i, j, 0));
                }
            }
            board[i] = grid[i].toCharArray();
        }
        int keyCount = Integer.parseUnsignedInt(sb.toString(), 2);
        if (keyCount == 0) return 0;
        if (coords[0] == -1) return -1;

        Queue<int[]> queue = new LinkedList<>();
//        boolean[] keysAcquired = new boolean[6];
//        StringBuilder keysAcquired = new StringBuilder("000000");

        queue.add(coords);
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                coords = queue.poll();
                int row = coords[0];
                int col = coords[1];
                int keys = coords[2];
                char cellValue = board[row][col];
                StringBuilder keysAcquired = new StringBuilder(Integer.toBinaryString((1 << 6) | keys));
                keysAcquired.deleteCharAt(0);
                if (cellValue >= 'a' && cellValue <= 'f') {
                    keysAcquired.setCharAt(cellValue - 'a', '1');
                    keys = Integer.parseInt(keysAcquired.toString(), 2);
                }
                if (keys == keyCount) return moves;
                if (isValidIdx(row + 1, col, board)) {
                    enqueue(row + 1, col, keys, board, keysAcquired, queue, visited);
                }
                if (isValidIdx(row - 1, col, board)) {
                    enqueue(row - 1, col, keys, board, keysAcquired, queue, visited);
                }
                if (isValidIdx(row, col + 1, board)) {
                    enqueue(row, col + 1, keys, board, keysAcquired, queue, visited);
                }
                if (isValidIdx(row, col - 1, board)) {
                    enqueue(row, col - 1, keys, board, keysAcquired, queue, visited);
                }

            }
            moves++;
        }
        return -1;

    }

    private String getVisitedKey(int row, int col, int keys) {
        return row + ":" + col + ":" + keys;
    }

    private void enqueue(int row, int col, int keys, char[][] board, StringBuilder keysAcquired, Queue<int[]> queue, HashSet<String> visited) {
        String visitedKey = getVisitedKey(row, col, keys);
        if (visited.contains(visitedKey)) return;
        if (board[row][col] >= 'A' && board[row][col] <= 'F') {
            int key = Character.toLowerCase(board[row][col]) - 'a';
            if (keysAcquired.charAt(key) == '1') {
                queue.add(new int[]{row, col, keys});
                visited.add(visitedKey);
            }
        } else {
            queue.add(new int[]{row, col, keys});
            visited.add(visitedKey);
        }
    }

    private boolean isValidIdx(int row, int col, char[][] board) {
        return row >= 0 &&
                row < board.length &&
                col >= 0 &&
                col < board[row].length &&
                board[row][col] != WALL

                ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ShortestPathToGetAllKeys extends Solution {
}