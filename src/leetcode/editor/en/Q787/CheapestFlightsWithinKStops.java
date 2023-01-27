package leetcode.editor.en.Q787;

import java.util.*;

import javafx.util.Pair;

import javax.print.DocFlavor;

//There are n cities connected by some number of flights. You are given an 
//array flights where flights[i] = [fromi, toi, pricei] indicates that there is a 
//flight from city fromi to city toi with cost pricei. 
//
// You are also given three integers src, dst, and k, return the cheapest price 
//from src to dst with at most k stops. If there is no such route, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], 
//src = 0, dst = 3, k = 1
//Output: 700
//Explanation:
//The graph is shown above.
//The optimal path with at most 1 stop from city 0 to 3 is marked in red and 
//has cost 100 + 600 = 700.
//Note that the path through cities [0,1,2,3] is cheaper but is invalid because 
//it uses 2 stops.
// 
//
// Example 2: 
// 
// 
//Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k =
// 1
//Output: 200
//Explanation:
//The graph is shown above.
//The optimal path with at most 1 stop from city 0 to 2 is marked in red and 
//has cost 100 + 100 = 200.
// 
//
// Example 3: 
// 
// 
//Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k =
// 0
//Output: 500
//Explanation:
//The graph is shown above.
//The optimal path with no stops from city 0 to 2 is marked in red and has cost 
//500.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 10⁴ 
// There will not be any multiple flights between two cities. 
// 0 <= src, dst, k < n 
// src != dst 
// 
//
// 👍 6838 👎 306


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, ArrayList<int[]>> adjList = makeAdjList(flights);

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) return -Integer.compare(a[2], b[2]);
            return a[1] - b[1];
        });
//        Queue<int[]> q = new LinkedList<>();
        HashMap<Pair<Integer, Integer>, Integer> visited = new HashMap<>();
        q.add(new int[]{src, 0, k});
        visited.put(new Pair<>(src, k), 0);
        while (!q.isEmpty()) {
            int[] travel = q.poll();
            int airport = travel[0];
            int cost = travel[1];
            int stopsRemaining = travel[2];
            if (airport == dst) {
                return cost;
            }
            Pair<Integer, Integer> visitKey = new Pair<>(airport, stopsRemaining);
            if (visited.getOrDefault(visitKey, Integer.MAX_VALUE) < cost) {
                continue;
            }

            if (!adjList.containsKey(airport) || stopsRemaining < 0) continue;
            ArrayList<int[]> destinations = adjList.get(airport);
            for (int[] dest : destinations) {
                int travelCost = cost + dest[1];
                visitKey = new Pair<>(dest[0], stopsRemaining - 1);
                if (!visited.containsKey(visitKey) || visited.get(visitKey) > travelCost) {
                    q.add(new int[]{
                            dest[0],
                            cost + dest[1],
                            stopsRemaining - 1
                    });
                    visited.put(visitKey, travelCost);
                }
            }
        }
        return -1;

    }

    private HashMap<Integer, ArrayList<int[]>> makeAdjList(int[][] flights) {
        HashMap<Integer, ArrayList<int[]>> adjList = new HashMap<>();
        for (int[] edge : flights) {
            adjList.computeIfAbsent(edge[0], (k) -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CheapestFlightsWithinKStops extends Solution {
}