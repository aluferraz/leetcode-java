package leetcode.editor.en.Q323;

import java.util.*;

import javafx.util.Pair;

//You have a graph of n nodes. You are given an integer n and an array edges 
//where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the 
//graph. 
//
// Return the number of connected components in the graph. 
//
// 
// Example 1: 
// 
// 
//Input: n = 5, edges = [[0,1],[1,2],[3,4]]
//Output: 2
// 
//
// Example 2: 
// 
// 
//Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2000 
// 1 <= edges.length <= 5000 
// edges[i].length == 2 
// 0 <= ai <= bi < n 
// ai != bi 
// There are no repeated edges. 
// 
//
// 👍 2436 👎 81


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            union(from, to, parents);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] < 0) res++;
        }
        return res;

    }

    private int find(int i, int[] parents) {
        while (parents[i] >= 0) {
            i = parents[i];
        }
        return i;
    }

    private void union(int i, int j, int[] parents) {
        i = find(i, parents);
        j = find(j, parents);
        if (i == j) return;
        if (parents[j] < parents[i]) {
            parents[j] += parents[i];
            parents[i] = j;
            return;
        }
        parents[i] += parents[j];
        parents[j] = i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfConnectedComponentsInAnUndirectedGraph extends Solution {
}