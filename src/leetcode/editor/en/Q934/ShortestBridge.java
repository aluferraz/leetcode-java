package leetcode.editor.en.Q934;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestBridge(int[][] grid) {
        boolean marked = false;
        for (int i = 0; i < grid.length && !marked; i++) {
            for (int j = 0; j < grid[i].length && !marked; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    marked = true;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == -1) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] info = q.poll();
                int row = info[0];
                int col = info[1];
                int cost = info[2];

                if (grid[row][col] == 1) {
                    ans = Math.min(ans, cost);
                    continue;
                }

                if (isValidIdx(row + 1, col, grid) && grid[row + 1][col] != -1) {
                    if (grid[row + 1][col] == 1) {
                        ans = Math.min(ans, cost);
                    } else {
                        grid[row + 1][col] = -1;
                        q.add(new int[]{row + 1, col, cost + 1});
                    }
                }
                if (isValidIdx(row - 1, col, grid) && grid[row - 1][col] != -1) {
                    if (grid[row - 1][col] == 1) {
                        ans = Math.min(ans, cost);
                    } else {
                        grid[row - 1][col] = -1;
                        q.add(new int[]{row - 1, col, cost + 1});
                    }
                }

                if (isValidIdx(row, col + 1, grid) && grid[row][col + 1] != -1) {
                    if (grid[row][col + 1] == 1) {
                        ans = Math.min(ans, cost);
                    } else {
                        grid[row][col + 1] = -1;
                        q.add(new int[]{row, col + 1, cost + 1});
                    }
                }

                if (isValidIdx(row, col - 1, grid) && grid[row][col - 1] != -1) {
                    if (grid[row][col - 1] == 1) {
                        ans = Math.min(ans, cost);
                    } else {
                        grid[row][col - 1] = -1;
                        q.add(new int[]{row, col - 1, cost + 1});
                    }
                }
            }
        }
        return ans;

    }

    private void dfs(int row, int col, int[][] grid) {
        grid[row][col] = -1;
        if (isValidIdx(row + 1, col, grid) && grid[row + 1][col] == 1) {
            dfs(row + 1, col, grid);
        }
        if (isValidIdx(row - 1, col, grid) && grid[row - 1][col] == 1) {
            dfs(row - 1, col, grid);
        }

        if (isValidIdx(row, col + 1, grid) && grid[row][col + 1] == 1) {
            dfs(row, col + 1, grid);
        }

        if (isValidIdx(row, col - 1, grid) && grid[row][col - 1] == 1) {
            dfs(row, col - 1, grid);
        }
    }

    private boolean isValidIdx(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ShortestBridge extends Solution {
}