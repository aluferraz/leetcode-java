package leetcode.editor.en.Q286;

import java.util.*;

//You are given an m x n grid rooms initialized with these three possible 
//values. 
//
// 
// -1 A wall or an obstacle. 
// 0 A gate. 
// INF Infinity means an empty room. We use the value 2³¹ - 1 = 2147483647 to 
//represent INF as you may assume that the distance to a gate is less than 214748364
//7. 
// 
//
// Fill each empty room with the distance to its nearest gate. If it is 
//impossible to reach a gate, it should be filled with INF. 
//
// 
// Example 1: 
// 
// 
//Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647
//,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
//Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
// 
//
// Example 2: 
//
// 
//Input: rooms = [[-1]]
//Output: [[-1]]
// 
//
// 
// Constraints: 
//
// 
// m == rooms.length 
// n == rooms[i].length 
// 1 <= m, n <= 250 
// rooms[i][j] is -1, 0, or 2³¹ - 1. 
// 
//
// 👍 2766 👎 49


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //DFS was WAAAY faster, but is because of bias on the test cases.
    private static final int WALL = -1;
    private static final int GATE = 0;

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == GATE) dfs(i, j, 0, rooms);
            }
        }
    }

    private void dfs(int i, int j, int distance, int[][] rooms) {
        if (!isValidIdx(i, j, rooms) || rooms[i][j] == WALL) return;
        rooms[i][j] = distance;
        if (isValidIdx(i - 1, j, rooms) && rooms[i - 1][j] > distance + 1) {
            dfs(i - 1, j, distance + 1, rooms);
        }
        if (isValidIdx(i + 1, j, rooms) && rooms[i + 1][j] > distance + 1) {
            dfs(i + 1, j, distance + 1, rooms);
        }
        if (isValidIdx(i, j - 1, rooms) && rooms[i][j - 1] > distance + 1) {
            dfs(i, j - 1, distance + 1, rooms);
        }
        if (isValidIdx(i, j + 1, rooms) && rooms[i][j + 1] > distance + 1) {
            dfs(i, j + 1, distance + 1, rooms);
        }
    }

    private boolean isValidIdx(int row, int col, int[][] grid) {
        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[row].length;
    }

//
//    public void wallsAndGates(int[][] rooms) {
//        Queue<Integer[]> queue = fillQueue(rooms);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Integer[] coords = queue.poll();
//                int row = coords[0];
//                int col = coords[1];
//                int dist = coords[2];
//                enqueueNext(row - 1, col, dist + 1, rooms, queue);
//                enqueueNext(row + 1, col, dist + 1, rooms, queue);
//                enqueueNext(row, col - 1, dist + 1, rooms, queue);
//                enqueueNext(row, col + 1, dist + 1, rooms, queue);
//            }
//        }
//    }
//
//    private void enqueueNext(int row, int col, int dist, int[][] rooms, Queue<Integer[]> queue) {
//        if (!isValidIdx(row, col, rooms)) return;
//        if (rooms[row][col] == WALL) return;
//        if (rooms[row][col] > dist) {
//            rooms[row][col] = dist; // To avoid double enqueue, we already set the distance
//            queue.add(new Integer[]{row, col, dist});
//        }
//    }
//
//
//    private boolean isValidIdx(int row, int col, int[][] grid) {
//        return row >= 0 &&
//                row < grid.length &&
//                col >= 0 &&
//                col < grid[row].length;
//    }
//
//    private Queue<Integer[]> fillQueue(int[][] rooms) {
//        Queue<Integer[]> queue = new LinkedList<>();
//        for (int i = 0; i < rooms.length; i++) {
//            for (int j = 0; j < rooms[i].length; j++) {
//                if (rooms[i][j] == GATE) queue.add(new Integer[]{i, j, 0});
//            }
//        }
//        return queue;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class WallsAndGates extends Solution {
}