package leetcode.editor.en.Q305;

import java.util.*;

import javafx.util.Pair;

//You are given an empty 2D binary grid grid of size m x n. The grid represents 
//a map where 0's represent water and 1's represent land. Initially, all the 
//cells of grid are water cells (i.e., all the cells are 0's). 
//
// We may perform an add land operation which turns the water at position into 
//a land. You are given an array positions where positions[i] = [ri, ci] is the 
//position (ri, ci) at which we should operate the iᵗʰ operation. 
//
// Return an array of integers answer where answer[i] is the number of islands 
//after turning the cell (ri, ci) into a land. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
// 
// 
//Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
//Output: [1,1,2,3]
//Explanation:
//Initially, the 2d grid is filled with water.
//- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We 
//have 1 island.
//- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We 
//still have 1 island.
//- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We 
//have 2 islands.
//- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We 
//have 3 islands.
// 
//
// Example 2: 
//
// 
//Input: m = 1, n = 1, positions = [[0,0]]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n, positions.length <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// positions[i].length == 2 
// 0 <= ri < m 
// 0 <= ci < n 
// 
//
// 
// Follow up: Could you solve it in time complexity O(k log(mn)), where k == 
//positions.length? 
//
// 👍 1677 👎 56


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] directions = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1}
    };

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] linearIsland = new int[m * n];
        Arrays.fill(linearIsland, -1);
        int[][] grid = new int[m][n];
        ArrayList<Integer> res = new ArrayList<>(positions.length);

        int totalIslands = 0;
        for (int[] land : positions) {
            int linearIdx = getLinearIdx(land[0], land[1], n);

            HashSet<Integer> islandsBefore = countIslands(n, linearIsland, grid, land);
            if (grid[land[0]][land[1]] == 1) {
                islandsBefore.add(find(linearIdx, linearIsland));
            }
            totalIslands -= islandsBefore.size();


            grid[land[0]][land[1]] = 1;
            for (int[] dir : directions) {
                int newY = land[0] + dir[0];
                int newX = land[1] + dir[1];
                if (isValidIdx(newY, newX, grid) && grid[newY][newX] == 1) {
                    int neighborIdx = getLinearIdx(newY, newX, n);
                    dsu(linearIsland, new int[]{linearIdx, neighborIdx});
                }
            }


            HashSet<Integer> islandsAfter = countIslands(n, linearIsland, grid, land);
            islandsAfter.add(find(linearIdx, linearIsland));


            totalIslands += islandsAfter.size();
            res.add(totalIslands);

        }
        return res;

    }

    private HashSet<Integer> countIslands(int n, int[] linearIsland, int[][] grid, int[] land) {
        HashSet<Integer> islands = new HashSet<>();
        for (int[] dir : directions) {
            int newY = land[0] + dir[0];
            int newX = land[1] + dir[1];
            if (isValidIdx(newY, newX, grid) && grid[newY][newX] == 1) {
                int neighborIdx = getLinearIdx(newY, newX, n);
                islands.add(find(neighborIdx, linearIsland));
            }
        }
        return islands;
    }


    private int getLinearIdx(int row, int col, int n) {
        return (row * n) + col;
    }

    private void dsu(int[] parents, int[] connection) {
        int from = connection[0];
        int to = connection[1];

        int pFrom = find(from, parents);
        int pTo = find(to, parents);

        if (pFrom != pTo) {
            union(pFrom, pTo, parents);
        }
    }

    private int find(int i, int[] parents) {
        while (parents[i] >= 0) {
            i = parents[i];
        }
        return i;
    }

    private void union(int i, int j, int[] parents) {
        if (parents[j] < parents[i]) {
            union(j, i, parents);
            return;
        }
        parents[i] += parents[j];
        parents[j] = i;
    }

    private boolean isValidIdx(int y, int x, int[][] grid) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[y].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfIslandsIi extends Solution {
}