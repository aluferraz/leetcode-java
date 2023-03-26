package leetcode.editor.en.Q2316;

import java.util.*;

import javafx.util.Pair;

//You are given an integer n. There is an undirected graph with n nodes, 
//numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, 
//bi] denotes that there exists an undirected edge connecting nodes ai and bi. 
//
// Return the number of pairs of different nodes that are unreachable from each 
//other. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3, edges = [[0,1],[0,2],[1,2]]
//Output: 0
//Explanation: There are no pairs of nodes that are unreachable from each other.
// Therefore, we return 0.
// 
//
// Example 2: 
// 
// 
//Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
//Output: 14
//Explanation: There are 14 pairs of nodes that are unreachable from each other:
//
//[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6]
//,[5,6]].
//Therefore, we return 14.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// 0 <= edges.length <= 2 * 10⁵ 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// There are no repeated edges. 
// 
//
// 👍 1208 👎 28


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int pFrom = find(from, parents);
            int pTo = find(to, parents);
            if (pFrom != pTo) {
                union(pFrom, pTo, parents);
            }
        }
        long res = 0L;
        //int total = n;

        //HashMap<Integer, Integer> processedFromGroup = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int groupRoot = find(i, parents);
           // int processed = processedFromGroup.getOrDefault(groupRoot, 0);
            int groupSize = Math.abs(parents[groupRoot]) ;
            int unconnected = n - groupSize;
           // total--;
            //processedFromGroup.put(groupRoot, processed + 1);
            res += (unconnected);

        }


        return res / 2;
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


public class CountUnreachablePairsOfNodesInAnUndirectedGraph extends Solution {
}