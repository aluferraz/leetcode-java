package leetcode.editor.en.Q1557;

import java.util.*;

import javafx.util.Pair;

//Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and 
//an array edges where edges[i] = [fromi, toi] represents a directed edge from node 
//fromi to node toi. 
//
// Find the smallest set of vertices from which all nodes in the graph are 
//reachable. It's guaranteed that a unique solution exists. 
//
// Notice that you can return the vertices in any order. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
//Output: [0,3]
//Explanation: It's not possible to reach all the nodes from a single vertex. 
//From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output [0,3]. 
//
//
// Example 2: 
//
// 
//
// 
//Input: n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
//Output: [0,2,3]
//Explanation: Notice that vertices 0, 3 and 2 are not reachable from any other 
//node, so we must include them. Also any of these vertices can reach nodes 1 and 
//4.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10^5 
// 1 <= edges.length <= min(10^5, n * (n - 1) / 2) 
// edges[i].length == 2 
// 0 <= fromi, toi < n 
// All pairs (fromi, toi) are distinct. 
// 
//
// 👍 2088 👎 76


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    HashSet<Integer> visited = new HashSet<>();
//    HashSet<Integer> indegree = new HashSet<>();

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] indegree = new boolean[n];
        for (List<Integer> fromTo : edges) {
            int to = fromTo.get(1);
            indegree[to] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!indegree[i]) res.add(i);
        }
        return res;

    }

//    private void dfs(int node, HashMap<Integer, ArrayList<Integer>> adjList) {
//        visited.add(node);
//        if (!adjList.containsKey(node)) return;
//        ArrayList<Integer> connections = adjList.get(node);
//        for (int neighbor : connections) {
//            if (!visited.contains(neighbor)) {
//                dfs(neighbor, adjList);
//            }
//        }
//    }

//    private HashMap<Integer, ArrayList<Integer>> makeAdjList(List<List<Integer>> edges) {
//        HashMap<Integer, ArrayList<Integer>> res = new HashMap<>();
//        for (List<Integer> fromTo : edges) {
//
//            int to = fromTo.get(1);
//            indegree.remove(to);
//
//            res.computeIfAbsent(fromTo.get(0), (k) -> new ArrayList<>()).add(to);
//        }
//        return res;
//    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumNumberOfVerticesToReachAllNodes extends Solution {
}