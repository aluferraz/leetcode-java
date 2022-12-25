package leetcode.editor.en.Q310;

import javafx.util.Pair;

import java.util.*;

//A tree is an undirected graph in which any two vertices are connected by 
//exactly one path. In other words, any connected graph without simple cycles is a 
//tree. 
//
// Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 
//edges where edges[i] = [ai, bi] indicates that there is an undirected edge between 
//the two nodes ai and bi in the tree, you can choose any node of the tree as the 
//root. When you select a node x as the root, the result tree has height h. Among 
//all possible rooted trees, those with minimum height (i.e. min(h)) are called 
//minimum height trees (MHTs). 
//
// Return a list of all MHTs' root labels. You can return the answer in any 
//order. 
//
// The height of a rooted tree is the number of edges on the longest downward 
//path between the root and a leaf. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4, edges = [[1,0],[1,2],[1,3]]
//Output: [1]
//Explanation: As shown, the height of the tree is 1 when the root is the node 
//with label 1 which is the only MHT.
// 
//
// Example 2: 
// 
// 
//Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//Output: [3,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// All the pairs (ai, bi) are distinct. 
// The given input is guaranteed to be a tree and there will be no repeated 
//edges. 
// 
//
// 👍 6285 👎 270


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //    Integer[][] cache;
    HashMap<Pair<Integer, Integer>, Integer> cache;
    Integer[] cacheCalc;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        cacheCalc = new Integer[n];
        cache = new HashMap<>((2 * n));
        HashMap<Integer, HashSet<Integer>> adjList = makeAdjList(edges);
        int minHeight = n;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            minHeight = Math.min(calculate(i, adjList), minHeight);
        }
        for (int i = 0; i < n; i++) {
            if (cacheCalc[i] == minHeight) result.add(i);
        }

        return result;


    }

    private int calculate(int root, HashMap<Integer, HashSet<Integer>> adjList) {
        int height = 0;
        if (adjList.containsKey(root)) {
            if (cacheCalc[root] != null) return cacheCalc[root];
            HashSet<Integer> connections = adjList.get(root);
            for (int edge : connections) {
                height = Math.max(getHeight(edge, root, adjList) + 1, height);
            }
        }
        cacheCalc[root] = height;

        return height;

    }

    private int getHeight(int root, int parent, HashMap<Integer, HashSet<Integer>> adjList) {
        int height = 0;
        Pair<Integer, Integer> cacheKey = new Pair<>(root, parent);
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);
//        String cacheKey = root + ":" + parent;
        if (adjList.containsKey(root)) {
            HashSet<Integer> connections = adjList.get(root);
            for (int edge : connections) {
                int subHeight = 0;
                if (edge != parent) {
                    subHeight = 1 + getHeight(edge, root, adjList);
                }
                height = Math.max(height, subHeight);
            }
        }
        cache.put(cacheKey, height);
        return height;
    }

    private HashMap<Integer, HashSet<Integer>> makeAdjList(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> result = new HashMap<>((2 * edges.length));
        for (int[] edge :
                edges) {
            int from = edge[0];
            int to = edge[1];
            HashSet<Integer> reqs = result.getOrDefault(from, new HashSet<>());
            reqs.add(to);
            result.put(from, reqs);

            reqs = result.getOrDefault(to, new HashSet<>());
            reqs.add(from);
            result.put(to, reqs);
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumHeightTrees extends Solution {
}