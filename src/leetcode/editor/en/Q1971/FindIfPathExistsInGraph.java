package leetcode.editor.en.Q1971;

import java.util.*;

//There is a bi-directional graph with n vertices, where each vertex is labeled 
//from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D 
//integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge 
//between vertex ui and vertex vi. Every vertex pair is connected by at most one 
//edge, and no vertex has an edge to itself. 
//
// You want to determine if there is a valid path that exists from vertex 
//source to vertex destination. 
//
// Given edges and the integers n, source, and destination, return true if 
//there is a valid path from source to destination, or false otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
//Output: true
//Explanation: There are two paths from vertex 0 to vertex 2:
//- 0 → 1 → 2
//- 0 → 2
// 
//
// Example 2: 
// 
// 
//Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, 
//destination = 5
//Output: false
//Explanation: There is no path from vertex 0 to vertex 5.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2 * 10⁵ 
// 0 <= edges.length <= 2 * 10⁵ 
// edges[i].length == 2 
// 0 <= ui, vi <= n - 1 
// ui != vi 
// 0 <= source, destination <= n - 1 
// There are no duplicate edges. 
// There are no self edges. 
// 
//
// 👍 2098 👎 106


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        if (n == 0) return false;
        int[] groups = new int[n];
        Arrays.fill(groups, -1);
        int sourceGroup = -1;
        int destinationGroup = -1;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int parentFrom = getParent(from, groups);
            int parentTo = getParent(to, groups);
            if (from == source) {
                sourceGroup = parentFrom;
            }
            if (to == source) {
                sourceGroup = parentTo;
            }

            if (from == destination) {
                destinationGroup = parentFrom;
            }
            if (to == destination) {
                destinationGroup = parentTo;
            }
            if (sourceGroup == destinationGroup && sourceGroup != -1) return true;
            if (parentTo != parentFrom) {
                union(parentFrom, parentTo, groups);
            }//else thjere is a cycle

        }
        sourceGroup = getParent(source, groups);
        destinationGroup = getParent(destination, groups);

        return (sourceGroup == destinationGroup && sourceGroup != -1);
    }

    private void union(int a, int b, int[] groups) {
        if (groups[a] <= groups[b]) {
            groups[a] += groups[b];
            groups[b] = a;
        } else {
            union(b, a, groups);
        }
    }

    private int getParent(int edge, int[] groups) {
        Deque<Integer> toBeUpdated = new LinkedList<>();
        while (groups[edge] >= 0) {
            toBeUpdated.push(edge);
            edge = groups[edge];
        }
        while (!toBeUpdated.isEmpty()) {
            groups[toBeUpdated.pop()] = edge;
        }
        return edge;
    }

//    HashSet<Integer> visited = new HashSet<>();
//
//    public boolean validPath(int n, int[][] edges, int source, int destination) {
//        if (source == destination) return true;
//        if (n == 0) return false;
//        HashMap<Integer, LinkedList<Integer>> connections = new HashMap<>();
//        for (int[] edge : edges) {
//            int from = edge[0];
//            int to = edge[1];
//            LinkedList<Integer> conn = connections.getOrDefault(from, new LinkedList<>());
//            conn.add(to);
//            connections.put(from, conn);
//            //Bi directional
//            conn = connections.getOrDefault(to, new LinkedList<>());
//            conn.add(from);
//            connections.put(to, conn);
//        }
//        return hasPath(source, destination, connections);
//    }
//
//    private boolean hasPath(int current, int target, HashMap<Integer, LinkedList<Integer>> connections) {
//        if (visited.contains(current)) return false;
//        visited.add(current);
//        LinkedList<Integer> conn = connections.getOrDefault(current, new LinkedList<>());
//        for (int next : conn) {
//            if (next == target) return true;
//            if (!visited.contains(next) && hasPath(next, target, connections)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class FindIfPathExistsInGraph extends Solution {
}