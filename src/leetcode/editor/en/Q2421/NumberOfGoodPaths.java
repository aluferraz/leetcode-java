package leetcode.editor.en.Q2421;

import javafx.util.Pair;

import javax.swing.*;
import java.util.*;

//There is a tree (i.e. a connected, undirected graph with no cycles) 
//consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. 
//
// You are given a 0-indexed integer array vals of length n where vals[i] 
//denotes the value of the iᵗʰ node. You are also given a 2D integer array edges where 
//edges[i] = [ai, bi] denotes that there exists an undirected edge connecting 
//nodes ai and bi. 
//
// A good path is a simple path that satisfies the following conditions: 
//
// 
// The starting node and the ending node have the same value. 
// All nodes between the starting node and the ending node have values less 
//than or equal to the starting node (i.e. the starting node's value should be the 
//maximum value along the path). 
// 
//
// Return the number of distinct good paths. 
//
// Note that a path and its reverse are counted as the same path. For example, 0
// -> 1 is considered to be the same as 1 -> 0. A single node is also considered 
//as a valid path. 
//
// 
// Example 1: 
// 
// 
//Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
//Output: 6
//Explanation: There are 5 good paths consisting of a single node.
//There is 1 additional good path: 1 -> 0 -> 2 -> 4.
//(The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.
//)
//Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].
// 
//
// Example 2: 
// 
// 
//Input: vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]
//Output: 7
//Explanation: There are 5 good paths consisting of a single node.
//There are 2 additional good paths: 0 -> 1 and 2 -> 3.
// 
//
// Example 3: 
// 
// 
//Input: vals = [1], edges = []
//Output: 1
//Explanation: The tree consists of only one node, so there is one good path.
// 
//
// 
// Constraints: 
//
// 
// n == vals.length 
// 1 <= n <= 3 * 10⁴ 
// 0 <= vals[i] <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// edges represents a valid tree. 
// 
//
// 👍 991 👎 45


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int numberOfGoodPaths(int[] vals, int[][] edges) {

        HashMap<Integer, ArrayList<Integer>> adjList = makeAdjList(edges);
        int goodPaths = 0;
        TreeMap<Integer, ArrayList<Integer>> sameValueNodes = new TreeMap<>();
        for (int i = 0; i < vals.length; i++) {
            int val = vals[i];
            sameValueNodes.computeIfAbsent(val, (value) -> new ArrayList<>()).add(i);
        }
        int[] parents = new int[vals.length];
        Arrays.fill(parents, -1);

        for (int value : sameValueNodes.keySet()) {
            ArrayList<Integer> targets = sameValueNodes.get(value);
            for (int node : targets) {
                if (!adjList.containsKey(node)) continue;
                ArrayList<Integer> edgesL = adjList.get(node);
                for (int edge : edgesL) {
                    if (value >= vals[edge]) {
                        int pFrom = find(node, parents);
                        int pTo = find(edge, parents);
                        union(pFrom, pTo, parents);
                    }

                }
            }

            HashMap<Integer, Integer> lookup = new HashMap<>();

            for (int node : targets) {
                int parent = find(node, parents);
                goodPaths += lookup.getOrDefault(parent, 0);
                lookup.put(parent, lookup.getOrDefault(parent, 0) + 1);
            }
        }


        return goodPaths + vals.length;
    }


    private void union(int i, int j, int[] parents) {
        if (i == j) return;
        if (parents[i] <= parents[j]) {
            parents[i] += parents[j];
            parents[j] = i;
            return;
        }
        union(j, i, parents);
    }

    private int find(int i, int[] parents) {
        LinkedList<Integer> toCompress = new LinkedList<>();
        while (parents[i] >= 0) {
            toCompress.add(i);
            i = parents[i];
        }
        while (!toCompress.isEmpty()) {
            parents[toCompress.poll()] = i;
        }
        return i;
    }

    private HashMap<Integer, ArrayList<Integer>> makeAdjList(int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], (value) -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], (value) -> new ArrayList<>()).add(edge[0]);
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfGoodPaths extends Solution {
}