package leetcode.editor.en.Q2492;

import java.util.*;

//You are given a positive integer n representing n cities numbered from 1 to n.
// You are also given a 2D array roads where roads[i] = [ai, bi, distancei] 
//indicates that there is a bidirectional road between cities ai and bi with a distance 
//equal to distancei. The cities graph is not necessarily connected. 
//
// The score of a path between two cities is defined as the minimum distance of 
//a road in this path. 
//
// Return the minimum possible score of a path between cities 1 and n. 
//
// Note: 
//
// 
// A path is a sequence of roads between two cities. 
// It is allowed for a path to contain the same road multiple times, and you 
//can visit cities 1 and n multiple times along the path. 
// The test cases are generated such that there is at least one path between 1 
//and n. 
// 
//
// 
// Example 1: 
// 
// 
//Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
//Output: 5
//Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4.
// The score of this path is min(9,5) = 5.
//It can be shown that no other path has less score.
// 
//
// Example 2: 
// 
// 
//Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
//Output: 2
//Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 
//-> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10⁵ 
// 1 <= roads.length <= 10⁵ 
// roads[i].length == 3 
// 1 <= ai, bi <= n 
// ai != bi 
// 1 <= distancei <= 10⁴ 
// There are no repeated edges. 
// There is at least one path between 1 and n. 
// 
//
// 👍 807 👎 151


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] seen;
    private Integer[] cache;
    private static final int VISITING = -1;
    private static final int UNVISITED = 0;

    public int minScore(int n, int[][] roads) {
        HashMap<Integer, ArrayList<int[]>> adjList = makeAdjList(n, roads);
        seen = new int[n + 1];
        cache = new Integer[n + 1];
        return dfs(1, n, adjList);

    }

    private int dfs(int node, int target, HashMap<Integer, ArrayList<int[]>> adjList) {
        if (!adjList.containsKey(node)) {
            return 10000000;
        }

        if (cache[node] != null) {
            return cache[node];
        }

        int res = 10000000;

        ArrayList<int[]> edges = adjList.get(node);
        seen[node] = VISITING;
        for (int[] edge : edges) {
            int next = edge[0];
            int cost = edge[1];
            if (seen[next] != VISITING) {
                if (node == target) {
                    res = Math.min(res, cost);
                } else {
                    int costHere = Math.min(cost, dfs(next, target, adjList));
                    res = Math.min(res, costHere);
                }
            }

        }
        seen[node] = 0;
        cache[node] = res;
        return res;
    }

    private HashMap<Integer, ArrayList<int[]>> makeAdjList(int n, int[][] roads) {
        HashMap<Integer, ArrayList<int[]>> adjList = new HashMap<>();
        for (int[] edge : roads) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            adjList.computeIfAbsent(from, (v) -> new ArrayList<>()).add(new int[]{to, cost});
            adjList.computeIfAbsent(to, (v) -> new ArrayList<>()).add(new int[]{from, cost});

        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumScoreOfAPathBetweenTwoCities extends Solution {
}