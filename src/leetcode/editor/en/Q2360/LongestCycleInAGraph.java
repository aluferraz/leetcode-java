package leetcode.editor.en.Q2360;

import java.util.*;

import javafx.util.Pair;

//You are given a directed graph of n nodes numbered from 0 to n - 1, where 
//each node has at most one outgoing edge. 
//
// The graph is represented with a given 0-indexed array edges of size n, 
//indicating that there is a directed edge from node i to node edges[i]. If there is no 
//outgoing edge from node i, then edges[i] == -1. 
//
// Return the length of the longest cycle in the graph. If no cycle exists, 
//return -1. 
//
// A cycle is a path that starts and ends at the same node. 
//
// 
// Example 1: 
// 
// 
//Input: edges = [3,3,4,2,3]
//Output: 3
//Explanation: The longest cycle in the graph is the cycle: 2 -> 4 -> 3 -> 2.
//The length of this cycle is 3, so 3 is returned.
// 
//
// Example 2: 
// 
// 
//Input: edges = [2,-1,3,1]
//Output: -1
//Explanation: There are no cycles in this graph.
// 
//
// 
// Constraints: 
//
// 
// n == edges.length 
// 2 <= n <= 10⁵ 
// -1 <= edges[i] < n 
// edges[i] != i 
// 
//
// 👍 1312 👎 24


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] seen;
    private static final int VISITED = 2;
    private static final int VISITING = -1;
    private static final int UNVISITED = 0;

    public int longestCycle(int[] edges) {
        HashSet<Integer> cycleIdxes = new HashSet<>();
        int[] parents = new int[edges.length];
        seen = new int[edges.length];
        Arrays.fill(parents, -1);

        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == -1) continue;
            int from = i;
            int to = edges[i];
            adjList.computeIfAbsent(from, (v) -> new ArrayList<>()).add(to);
            int pFrom = find(from, parents);
            int pTo = find(to, parents);
            if (pFrom != pTo) {
                union(pFrom, pTo, parents);
            } else {
                cycleIdxes.add(from);
                cycleIdxes.add(to);
            }
        }

        if (cycleIdxes.isEmpty()) return -1;
        int res = 0;
        for (int cycle : cycleIdxes) {
            if (seen[cycle] == UNVISITED) {
                res = Math.max(res, cycleLength(cycle, adjList));
            }
        }

        return res;

    }


    private int cycleLength(int i, HashMap<Integer, ArrayList<Integer>> adjList) {
        if (seen[i] == VISITING) {
            seen[i] = VISITED;
            return 0;
        }
        if (!adjList.containsKey(i)) {
            return 100000001;
        }
        seen[i] = VISITING;
        ArrayList<Integer> edges = adjList.get(i);
        int len = 0;
        for (int edge : edges) {
            // if (edge != parent) {
            len += 1 + cycleLength(edge, adjList);
            //}
        }
        seen[i] = VISITED;
        return len;
    }


    private int find(int i, int[] parents) {
        Queue<Integer> pathCompression = new LinkedList<>();
        while (parents[i] >= 0) {
            pathCompression.add(i);
            i = parents[i];
        }
        while (!pathCompression.isEmpty()) {
            parents[pathCompression.poll()] = i;

        }
        return i;
    }

    private void union(int i, int j, int[] parents) {
        if (i == j) return;
        if (parents[j] < parents[i]) {
            union(j, i, parents);
            return;
        }
        parents[i] += parents[j];
        parents[j] = i;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class LongestCycleInAGraph extends Solution {
}