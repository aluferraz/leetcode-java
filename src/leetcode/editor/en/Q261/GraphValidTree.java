package leetcode.editor.en.Q261;

import java.util.*;

import javafx.util.Pair;

//You have a graph of n nodes labeled from 0 to n - 1. You are given an integer 
//n and a list of edges where edges[i] = [ai, bi] indicates that there is an 
//undirected edge between nodes ai and bi in the graph. 
//
// Return true if the edges of the given graph make up a valid tree, and false 
//otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2000 
// 0 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// There are no self-loops or repeated edges. 
// 
//
// 👍 2969 👎 84


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        HashMap<Integer, ArrayList<Integer>> adjList = getAdjList(edges);

        for (Map.Entry<Integer, ArrayList<Integer>> connections : adjList.entrySet()) {
            int from = connections.getKey();
            ArrayList<Integer> connected = connections.getValue();
            for (Integer to : connected) {
                int fromParent = find(from, parents);
                int toParent = find(to, parents);
                if (fromParent != toParent) {
                    union(fromParent, toParent, parents);
                } else {
                    return false; // There is a cycle;
                }
            }
        }

        int minValue = n;

        for (int graphInfo : parents) {
            minValue = Math.min(minValue, graphInfo);
        }

        return Math.abs(minValue) == n; // To be a valid tree it must be n-1 connections and no cycles.

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

    private HashMap<Integer, ArrayList<Integer>> getAdjList(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.computeIfAbsent(from, (v) -> new ArrayList<>()).add(to);
//            adjList.computeIfAbsent(to, (v) -> new ArrayList<>()).add(from);
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class GraphValidTree extends Solution {
}