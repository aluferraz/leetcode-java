package leetcode.editor.en.Q1584;

import java.util.*;

import javafx.util.Pair;

//You are given an array points representing integer coordinates of some points 
//on a 2D-plane, where points[i] = [xi, yi]. 
//
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan 
//distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute 
//value of val. 
//
// Return the minimum cost to make all points connected. All points are 
//connected if there is exactly one simple path between any two points. 
//
// 
// Example 1: 
// 
// 
//Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//Output: 20
//Explanation: 
//
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
// 
//
// Example 2: 
//
// 
//Input: points = [[3,12],[-2,5],[-4,1]]
//Output: 18
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 1000 
// -10⁶ <= xi, yi <= 10⁶ 
// All pairs (xi, yi) are distinct. 
// 
//
// 👍 3430 👎 84


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, ArrayList<int[]>> adjList = makeAdjList(points);
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            minCost = Math.min(
                    minCost,
                    dfs(0, adjList, new HashSet<>())
            );
        }
        return minCost;
    }


    private int dfs(int i, HashMap<Integer, ArrayList<int[]>> adjList, HashSet<Integer> visited) {
        if (visited.contains(i)) return 0;
        visited.add(i);
        ArrayList<int[]> edges = adjList.get(i);
        int totalCost = 0;
        for (int[] nextAndCost : edges) {
            int next = nextAndCost[0];
            int cost = nextAndCost[1];
            if (!visited.contains(next))
                totalCost += (cost + dfs(next, adjList, visited));
        }
        return totalCost;
    }

    private HashMap<Integer, ArrayList<int[]>> makeAdjList(int[][] points) {
        HashMap<Integer, ArrayList<int[]>> adjList = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] from = points[i];
            ArrayList<int[]> edges = new ArrayList<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int[] to = points[j];

                int dist = Math.abs(Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]));
                edges.add(new int[]{
                        j, dist
                });
            }
            edges.sort(Comparator.comparingInt(a -> a[1]));
            adjList.put(i, edges);
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinCostToConnectAllPoints extends Solution {
}