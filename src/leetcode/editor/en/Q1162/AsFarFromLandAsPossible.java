package leetcode.editor.en.Q1162;
import java.util.*;
import javafx.util.Pair;

//Given an n x n grid containing only values 0 and 1, where 0 represents water 
//and 1 represents land, find a water cell such that its distance to the nearest 
//land cell is maximized, and return the distance. If no land or water exists in 
//the grid, return -1. 
//
// The distance used in this problem is the Manhattan distance: the distance 
//between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|. 
//
// 
// Example 1: 
// 
// 
//Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
//Output: 2
//Explanation: The cell (1, 1) is as far as possible from all the land with 
//distance 2.
// 
//
// Example 2: 
// 
// 
//Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
//Output: 4
//Explanation: The cell (2, 2) is as far as possible from all the land with 
//distance 4.
// 
//
// 
// Constraints: 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] is 0 or 1 
// 
//
// 👍 3094 👎 81


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] dirs = new int[][]{
            new int[]{1,0},
            new int[]{-1,0},
            new int[]{0,1},
            new int[]{0,-1},
    };
    Integer[][] visited;
    public int maxDistance(int[][] grid) {

        visited = new Integer[grid.length][grid[0].length];
        int res = -1;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j,0});
                    visited[i][j] = 0;
                }
            }
        }
        bfs(q);

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if(visited[i][j] == null) return -1;
                res = Math.max(visited[i][j],res);
            }
        }

        return res == 0 ? -1 : res;
    }


    private void bfs(Queue<int[]> q){
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                for (int[] dir:dirs) {
                    int[] newPos = new int[]{
                            pos[0] + dir[0],
                            pos[1] + dir[1],
                            pos[2] + 1
                    };
                    if(isValidIdx(newPos[0], newPos[1])){

                        visited[newPos[0]][newPos[1]] = pos[2] + 1;
                        q.add(newPos);
                    }
                }
            }
        }

    }

    private boolean isValidIdx(int row, int col){
        return row >= 0 && row < visited.length &&
                col >= 0 &&
                col < visited[row].length &&
                visited[row][col] == null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



public class AsFarFromLandAsPossible extends Solution {}