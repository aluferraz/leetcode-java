package leetcode.editor.en.Q1857;

import java.util.*;

//There is a directed graph of n colored nodes and m edges. The nodes are 
//numbered from 0 to n - 1. 
//
// You are given a string colors where colors[i] is a lowercase English letter 
//representing the color of the iᵗʰ node in this graph (0-indexed). You are also 
//given a 2D array edges where edges[j] = [aj, bj] indicates that there is a 
//directed edge from node aj to node bj. 
//
// A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk 
//such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The 
//color value of the path is the number of nodes that are colored the most 
//frequently occurring color along that path. 
//
// Return the largest color value of any valid path in the given graph, or -1 
//if the graph contains a cycle. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
//Output: 3
//Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (
//red in the above image).
// 
//
// Example 2: 
//
// 
//
// 
//Input: colors = "a", edges = [[0,0]]
//Output: -1
//Explanation: There is a cycle from 0 to 0.
// 
//
// 
// Constraints: 
//
// 
// n == colors.length 
// m == edges.length 
// 1 <= n <= 10⁵ 
// 0 <= m <= 10⁵ 
// colors consists of lowercase English letters. 
// 0 <= aj, bj < n 
// 
//
// 👍 1143 👎 41


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int VISITING = -1;
    private static final int VISITED = 1;

    Integer[] cache;

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        HashMap<Integer, ArrayList<Integer>> adjList = makeAdjListDirected(edges);
        if (hasCycle(n, adjList)) return -1;
        int max = 0;

        for (int c = 0; c < 26; c++) {
            cache = new Integer[n];
            for (int i = 0; i < n; i++) {
                max = Math.max(dfsCounter(i, adjList, colors, c), max);
            }

        }

        return max;
    }


    private int dfsCounter(
            int start,
            HashMap<Integer, ArrayList<Integer>> adjList,
            String s,
            int target
    ) {
        if (cache[start] != null) {
            return cache[start];
        }

        int colorIdx = s.charAt(start) - 'a';
        int current = 0;
        if (colorIdx == target) {
            current++;
        }

        int best = current;
        if (adjList.containsKey(start)) {
            ArrayList<Integer> edges = adjList.get(start);
            for (int next : edges) {
                best = Math.max(best, current + dfsCounter(next, adjList, s, target));
            }
        }
        cache[start] = best;
        return best;
    }


    private boolean hasCycle(int n, HashMap<Integer, ArrayList<Integer>> adjList) {

        int[] callstack = new int[n];
        for (int i = 0; i < n; i++) {
            if (dfsCycle(i, adjList, callstack)) return true;
        }
        return false;
    }

    private boolean dfsCycle(int start, HashMap<Integer, ArrayList<Integer>> adjList, int[] callstack) {
        if (callstack[start] == VISITING) return true;
        if (callstack[start] == VISITED) return false;
        callstack[start] = VISITING;
        if (adjList.containsKey(start)) {
            ArrayList<Integer> edges = adjList.get(start);
            for (int next : edges) {
                if (dfsCycle(next, adjList, callstack)) return true;
            }
        }
        callstack[start] = VISITED;
        return false;
    }

    private HashMap<Integer, ArrayList<Integer>> makeAdjListDirected(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], (v) -> new ArrayList<>()).add(edge[1]);
        }
        return adjList;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class LargestColorValueInADirectedGraph extends Solution {
}