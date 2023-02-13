package leetcode.editor.en.Q2477;

import java.util.*;

import javafx.util.Pair;

//There is a tree (i.e., a connected, undirected graph with no cycles) 
//structure country network consisting of n cities numbered from 0 to n - 1 and exactly n -
// 1 roads. The capital city is city 0. You are given a 2D integer array roads 
//where roads[i] = [ai, bi] denotes that there exists a bidirectional road 
//connecting cities ai and bi. 
//
// There is a meeting for the representatives of each city. The meeting is in 
//the capital city. 
//
// There is a car in each city. You are given an integer seats that indicates 
//the number of seats in each car. 
//
// A representative can use the car in their city to travel or change the car 
//and ride with another representative. The cost of traveling between two cities is 
//one liter of fuel. 
//
// Return the minimum number of liters of fuel to reach the capital city. 
//
// 
// Example 1: 
// 
// 
//Input: roads = [[0,1],[0,2],[0,3]], seats = 5
//Output: 3
//Explanation: 
//- Representative1 goes directly to the capital with 1 liter of fuel.
//- Representative2 goes directly to the capital with 1 liter of fuel.
//- Representative3 goes directly to the capital with 1 liter of fuel.
//It costs 3 liters of fuel at minimum. 
//It can be proven that 3 is the minimum number of liters of fuel needed.
// 
//
// Example 2: 
// 
// 
//Input: roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
//Output: 7
//Explanation: 
//- Representative2 goes directly to city 3 with 1 liter of fuel.
//- Representative2 and representative3 go together to city 1 with 1 liter of 
//fuel.
//- Representative2 and representative3 go together to the capital with 1 liter 
//of fuel.
//- Representative1 goes directly to the capital with 1 liter of fuel.
//- Representative5 goes directly to the capital with 1 liter of fuel.
//- Representative6 goes directly to city 4 with 1 liter of fuel.
//- Representative4 and representative6 go together to the capital with 1 liter 
//of fuel.
//It costs 7 liters of fuel at minimum. 
//It can be proven that 7 is the minimum number of liters of fuel needed.
// 
//
// Example 3: 
// 
// 
//Input: roads = [], seats = 1
//Output: 0
//Explanation: No representatives need to travel to the capital city.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// roads.length == n - 1 
// roads[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// roads represents a valid tree. 
// 1 <= seats <= 10⁵ 
// 
//
// 👍 1185 👎 40


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long bfs(int n, Map<Integer, List<Integer>> adj, int[] degree, int seats) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int[] representatives = new int[n];
        Arrays.fill(representatives, 1);
        long fuel = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            fuel += Math.ceil((double) representatives[node] / seats);

            for (int neighbor : adj.get(node)) {
                degree[neighbor]--;
                representatives[neighbor] += representatives[node];
                if (degree[neighbor] == 1 && neighbor != 0) {
                    q.offer(neighbor);
                }
            }
        }
        return fuel;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[n];

        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<Integer>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new ArrayList<Integer>()).add(road[0]);
            degree[road[0]]++;
            degree[road[1]]++;
        }

        return bfs(n, adj, degree, seats);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumFuelCostToReportToTheCapital extends Solution {
}