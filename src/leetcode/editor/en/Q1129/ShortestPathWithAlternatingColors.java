package leetcode.editor.en.Q1129;

import java.util.*;

import javafx.util.Pair;

//You are given an integer n, the number of nodes in a directed graph where the 
//nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and 
//there could be self-edges and parallel edges. 
//
// You are given two arrays redEdges and blueEdges where: 
//
// 
// redEdges[i] = [ai, bi] indicates that there is a directed red edge from node 
//ai to node bi in the graph, and 
// blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from 
//node uj to node vj in the graph. 
// 
//
// Return an array answer of length n, where each answer[x] is the length of 
//the shortest path from node 0 to node x such that the edge colors alternate along 
//the path, or -1 if such a path does not exist. 
//
// 
// Example 1: 
//
// 
//Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
//Output: [0,1,-1]
// 
//
// Example 2: 
//
// 
//Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
//Output: [0,1,-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 100 
// 0 <= redEdges.length, blueEdges.length <= 400 
// redEdges[i].length == blueEdges[j].length == 2 
// 0 <= ai, bi, uj, vj < n 
// 
//
// 👍 1756 👎 86


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] res;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, ArrayList<Integer>> redAdj = makeAdjList(redEdges);
        HashMap<Integer, ArrayList<Integer>> blueAdj = makeAdjList(blueEdges);

        res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        BFS(redAdj, blueAdj);
        BFS(blueAdj, redAdj);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == Integer.MAX_VALUE)
                res[i] = -1;
        }
        return res;
    }

    private void BFS(HashMap<Integer, ArrayList<Integer>> adj1, HashMap<Integer, ArrayList<Integer>> adj2) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> adjs = new HashMap<>();
        adjs.put(0, adj1);
        adjs.put(1, adj2);
        int path = 0;
        boolean[][] visited = new boolean[res.length][2];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int node = cur[0];
                int list = cur[1];
                HashMap<Integer, ArrayList<Integer>> adjList = adjs.get(list);
                res[node] = Math.min(path, res[node]);
                visited[node][list] = true;
                if (!adjList.containsKey(node)) continue;
                ArrayList<Integer> edges = adjList.get(node);
                int nextList = (list + 1) % 2;
                for (int edge : edges) {
//                    if(res[edge] >= path+1){
                    if (!visited[edge][nextList])
                        q.add(new int[]{edge, nextList});
                }
            }
            path++;
        }


    }

    private HashMap<Integer, ArrayList<Integer>> makeAdjList(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int[] edge :
                edges) {
            adjList.computeIfAbsent(edge[0], (k) -> new ArrayList<>()).add(edge[1]);
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ShortestPathWithAlternatingColors extends Solution {
}