package leetcode.editor.en.Q417;

import java.util.*;

//There is an m x n rectangular island that borders both the Pacific Ocean and 
//Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and 
//the Atlantic Ocean touches the island's right and bottom edges. 
//
// The island is partitioned into a grid of square cells. You are given an m x 
//n integer matrix heights where heights[r][c] represents the height above sea 
//level of the cell at coordinate (r, c). 
//
// The island receives a lot of rain, and the rain water can flow to 
//neighboring cells directly north, south, east, and west if the neighboring cell's height 
//is less than or equal to the current cell's height. Water can flow from any cell 
//adjacent to an ocean into the ocean. 
//
// Return a 2D list of grid coordinates result where result[i] = [ri, ci] 
//denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic 
//oceans. 
//
// 
// Example 1: 
// 
// 
//Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//
//Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//Explanation: The following cells can flow to the Pacific and Atlantic oceans, 
//as shown below:
//[0,4]: [0,4] -> Pacific Ocean 
//       [0,4] -> Atlantic Ocean
//[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//       [1,3] -> [1,4] -> Atlantic Ocean
//[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//       [1,4] -> Atlantic Ocean
//[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
//[3,0]: [3,0] -> Pacific Ocean 
//       [3,0] -> [4,0] -> Atlantic Ocean
//[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//       [3,1] -> [4,1] -> Atlantic Ocean
//[4,0]: [4,0] -> Pacific Ocean 
//       [4,0] -> Atlantic Ocean
//Note that there are other possible paths for these cells to flow to the 
//Pacific and Atlantic oceans.
// 
//
// Example 2: 
//
// 
//Input: heights = [[1]]
//Output: [[0,0]]
//Explanation: The water can flow from the only cell to the Pacific and 
//Atlantic oceans.
// 
//
// 
// Constraints: 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
//
// 👍 5876 👎 1116


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int PACIFIC = 3;
    private static final int ATLANTIC = 2;
    private static final int BOTH = 5;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int[][] scores = Arrays.stream(heights)
                .map(int[]::clone)
                .toArray(int[][]::new);
        for (int[] ints : scores) {
            Arrays.fill(ints, 0);
        }
        pushResult(0, scores[0].length - 1, scores, result);
        if (0 != scores.length - 1 || 0 != scores[0].length - 1) {
            pushResult(scores.length - 1, 0, scores, result);
        }


        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (scores[i][j] != BOTH) scores[i][j] = 0;
                dfs(i, j, heights, scores, result);
            }
        }
        return result;
    }

    private int dfs(int i, int j, int[][] heights, int[][] scores, List<List<Integer>> result) {
        if (!isValidIdx(i, j, heights)) return 0;
        if (scores[i][j] != 0) return scores[i][j];
        int backup = heights[i][j];
        heights[i][j] = Integer.MAX_VALUE;
        int touchesPacific = ((i == 0 || j == 0)) ? PACIFIC : 0;
        int touchesAtlantic = ((j == scores[i].length - 1) || (i == scores.length - 1)) ? ATLANTIC : 0;
        int score = 0;
        if (isValidIdx(i - 1, j, heights) && heights[i - 1][j] <= backup && (touchesAtlantic + touchesPacific != BOTH)) {
            score = dfs(i - 1, j, heights, scores, result);
            switch (score) {
                case BOTH:
                    pushResult(i, j, scores, result);
                    heights[i][j] = backup;
                    return score;
                case ATLANTIC:
                    touchesAtlantic = ATLANTIC;
                    break;
                case PACIFIC:
                    touchesPacific = PACIFIC;
                    break;
            }

        }
        if (isValidIdx(i + 1, j, heights) && heights[i + 1][j] <= backup && (touchesAtlantic + touchesPacific != BOTH)) {
            score = dfs(i + 1, j, heights, scores, result);
            switch (score) {
                case BOTH:
                    pushResult(i, j, scores, result);
                    heights[i][j] = backup;
                    return score;
                case ATLANTIC:
                    touchesAtlantic = ATLANTIC;
                    break;
                case PACIFIC:
                    touchesPacific = PACIFIC;
                    break;
            }
        }
        if (isValidIdx(i, j - 1, heights) && heights[i][j - 1] <= backup && (touchesAtlantic + touchesPacific != BOTH)) {
            score = dfs(i, j - 1, heights, scores, result);
            switch (score) {
                case BOTH:
                    pushResult(i, j, scores, result);
                    heights[i][j] = backup;
                    return score;
                case ATLANTIC:
                    touchesAtlantic = ATLANTIC;
                    break;
                case PACIFIC:
                    touchesPacific = PACIFIC;
                    break;
            }
        }
        if (isValidIdx(i, j + 1, heights) && heights[i][j + 1] <= backup && (touchesAtlantic + touchesPacific != BOTH)) {
            score = dfs(i, j + 1, heights, scores, result);
            switch (score) {
                case BOTH:
                    pushResult(i, j, scores, result);
                    heights[i][j] = backup;
                    return score;
                case ATLANTIC:
                    touchesAtlantic = ATLANTIC;
                    break;
                case PACIFIC:
                    touchesPacific = PACIFIC;
                    break;
            }
        }
        if (touchesAtlantic + touchesPacific == BOTH) {
            pushResult(i, j, scores, result);
            heights[i][j] = backup;
            return BOTH;
        }
        heights[i][j] = backup;
        scores[i][j] = Math.max(touchesAtlantic, touchesPacific);
        return scores[i][j];
    }


    private void pushResult(int i, int j, int[][] scores, List<List<Integer>> result) {
        List<Integer> coords = new ArrayList<>();
        coords.add(i);
        coords.add(j);
        result.add(coords);
        scores[i][j] = BOTH;
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class PacificAtlanticWaterFlow extends Solution {
}