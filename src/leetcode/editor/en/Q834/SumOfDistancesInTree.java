package leetcode.editor.en.Q834;

import javafx.util.Pair;

import java.util.*;

//There is an undirected connected tree with n nodes labeled from 0 to n - 1 
//and n - 1 edges. 
//
// You are given the integer n and the array edges where edges[i] = [ai, bi] 
//indicates that there is an edge between nodes ai and bi in the tree. 
//
// Return an array answer of length n where answer[i] is the sum of the 
//distances between the iᵗʰ node in the tree and all other nodes. 
//
// 
// Example 1: 
// 
// 
//Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
//Output: [8,12,6,10,10,10]
//Explanation: The tree is shown above.
//We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
//equals 1 + 1 + 2 + 2 + 2 = 8.
//Hence, answer[0] = 8, and so on.
// 
//
// Example 2: 
// 
// 
//Input: n = 1, edges = []
//Output: [0]
// 
//
// Example 3: 
// 
// 
//Input: n = 2, edges = [[1,0]]
//Output: [1,1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 3 * 10⁴ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// The given input represents a valid tree. 
// 
//
// 👍 3585 👎 78


//leetcode submit region begin(Prohibit modification and deletion)
//https://www.youtube.com/watch?v=P3SdIh3gGPQ
class Solution {
    HashMap<Pair<Integer, Integer>, Pair<Integer, Integer>> cache = new HashMap<>();
    int[] result;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashMap<Integer, LinkedList<Integer>> adjList = makeAdjacentList(edges);
        result = new int[n];
        cacheNodesInfo(0, -1, adjList).getKey();
        computeResult(0, -1, 0, 0, adjList);
//        for (int i = 0; i < n; i++) {
//            result[i] = cacheNodesInfo(i, -1, adjList).getValue(); //cache.get(i).getValue();
//        }

        return result;
    }

    private void computeResult(int node, int parent, int otherVertices, int otherEdges, HashMap<Integer, LinkedList<Integer>> adjList) {
        LinkedList<Integer> connections = adjList.getOrDefault(node, new LinkedList<>());
        Pair<Integer, Integer> cacheKey = new Pair<>(node, parent);
        int vertices = cache.get(cacheKey).getKey();
        int edges = cache.get(cacheKey).getValue();
        result[node] = edges + otherEdges;
        for (int nextNode : connections) {
            if (nextNode != parent) {

                Pair<Integer, Integer> childCacheKey = new Pair<>(nextNode, node);
                int childVertices = cache.get(childCacheKey).getKey();
                int childEdges = cache.get(childCacheKey).getValue();


                computeResult(nextNode, node,
                        (vertices - childVertices + otherVertices),
                        (edges - childEdges - childVertices + vertices - childVertices + otherEdges + otherVertices),
                        adjList
                );
            }
        }

    }

    private Pair<Integer, Integer> cacheNodesInfo(int node, int parent, HashMap<Integer, LinkedList<Integer>> adjList) {
        LinkedList<Integer> connections = adjList.getOrDefault(node, new LinkedList<>());
        Pair<Integer, Integer> cacheKey = new Pair<>(node, parent);
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }

        int nodes = 0;
        int edges = 0;

        for (int nextNode : connections) {
            if (nextNode != parent) {
                Pair<Integer, Integer> nodeCountEdgesCount = cacheNodesInfo(nextNode, node, adjList);
                nodes += nodeCountEdgesCount.getKey();
                edges += (nodeCountEdgesCount.getKey() + nodeCountEdgesCount.getValue());
            }
        }
        Pair<Integer, Integer> result = new Pair<>(nodes + 1, edges);
        cache.put(cacheKey, result);
        return result;

    }


    private HashMap<Integer, LinkedList<Integer>> makeAdjacentList(int[][] edges) {
        HashMap<Integer, LinkedList<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            LinkedList<Integer> connections = adjList.getOrDefault(from, new LinkedList<>());
            connections.add(to);
            adjList.put(from, connections);

            connections = adjList.getOrDefault(to, new LinkedList<>());
            connections.add(from);
            adjList.put(to, connections);
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class SumOfDistancesInTree extends Solution {
}