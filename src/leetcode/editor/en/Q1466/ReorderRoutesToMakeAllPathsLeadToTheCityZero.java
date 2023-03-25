package leetcode.editor.en.Q1466;

import java.util.*;

//There are n cities numbered from 0 to n - 1 and n - 1 roads such that there 
//is only one way to travel between two different cities (this network form a tree).
// Last year, The ministry of transport decided to orient the roads in one 
//direction because they are too narrow. 
//
// Roads are represented by connections where connections[i] = [ai, bi] 
//represents a road from city ai to city bi. 
//
// This year, there will be a big event in the capital (city 0), and many 
//people want to travel to this city. 
//
// Your task consists of reorienting some roads such that each city can visit 
//the city 0. Return the minimum number of edges changed. 
//
// It's guaranteed that each city can reach city 0 after reorder. 
//
// 
// Example 1: 
// 
// 
//Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//Output: 3
//Explanation: Change the direction of edges show in red such that each node 
//can reach the node 0 (capital).
// 
//
// Example 2: 
// 
// 
//Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//Output: 2
//Explanation: Change the direction of edges show in red such that each node 
//can reach the node 0 (capital).
// 
//
// Example 3: 
//
// 
//Input: n = 3, connections = [[1,0],[2,0]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 5 * 10⁴ 
// connections.length == n - 1 
// connections[i].length == 2 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// 
//
// 👍 2573 👎 70


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer[] visited;

    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, ArrayList<int[]>> adjList = makeAdjList(connections);
        int res = 0;
        visited = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            //Unvisited
            if (visited[i] == null) {
                res += dfs(i, -1, adjList);
            }
        }
        return res;

    }

    private int dfs(int i, int parent, HashMap<Integer, ArrayList<int[]>> adjList) {
        if (i == 0) {
            return 0;
        }
        if (visited[i] != null) return 0;
        ArrayList<int[]> edges = adjList.get(i);
        int res = 10000000;
        for (int[] edge : edges) {
            if (edge[0] == parent) continue;
            int cost = edge[1] + dfs(edge[0], i, adjList);
            res = Math.min(cost, res);
        }
        if (res < 10000000) visited[i] = res;
        return res;
    }

    private HashMap<Integer, ArrayList<int[]>> makeAdjList(int[][] connections) {
        HashMap<Integer, ArrayList<int[]>> adjList = new HashMap<>();
        for (int[] edge : connections) {
            int from = edge[0];
            int to = edge[1];
            // We can flip the direction, with cost 1.
            adjList.computeIfAbsent(from, (v) -> new ArrayList<>()).add(new int[]{to, 0});

            adjList.computeIfAbsent(to, (v) -> new ArrayList<>()).add(new int[]{from, 1});
        }
        return adjList;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class ReorderRoutesToMakeAllPathsLeadToTheCityZero extends Solution {
}