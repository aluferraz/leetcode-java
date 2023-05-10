package leetcode.editor.en.Q54;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> ans;
    private int[][] DIRECTIONS = new int[][]{
            new int[]{0, 1}, //right
            new int[]{1, 0}, //down
            new int[]{0, -1}, //left
            new int[]{-1, 0}, //up
    };

    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        ans = new ArrayList<>();
        dfs(0, 0, 0, visited, matrix);
        return ans;
    }

    private void dfs(int row, int col, int dir, boolean[][] visited, int[][] matrix) {
        visited[row][col] = true;
        ans.add(matrix[row][col]);
        int[] next = newDir(row, col, dir, visited);
        if (next[0] == -1) return;
        dfs(next[0], next[1], next[2], visited, matrix);
    }

    private int[] newDir(int row, int col, int dir, boolean[][] visited) {
        int newRow = row + DIRECTIONS[dir][0];
        int newCol = col + DIRECTIONS[dir][1];
        if (isValidIdx(newRow, newCol, visited)) {
            return new int[]{newRow, newCol, dir};
        } else {
            dir = ((dir + 1) % DIRECTIONS.length);
            newRow = row + DIRECTIONS[dir][0];
            newCol = col + DIRECTIONS[dir][1];
            if (isValidIdx(newRow, newCol, visited)) {
                return new int[]{newRow, newCol, dir};
            }
        }
        return new int[]{-1, -1, -1};
    }

    private boolean isValidIdx(int row, int col, boolean[][] visited) {
        return row >= 0 && row < visited.length && col >= 0 && col < visited[row].length && !visited[row][col];
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class SpiralMatrix extends Solution {
}