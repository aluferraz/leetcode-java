package leetcode.editor.en.Q1579;

import java.time.temporal.TemporalAccessor;
import java.util.*;

import javafx.util.Pair;

//Alice and Bob have an undirected graph of n nodes and three types of edges: 
//
// 
// Type 1: Can be traversed by Alice only. 
// Type 2: Can be traversed by Bob only. 
// Type 3: Can be traversed by both Alice and Bob. 
// 
//
// Given an array edges where edges[i] = [typei, ui, vi] represents a 
//bidirectional edge of type typei between nodes ui and vi, find the maximum number of 
//edges you can remove so that after removing the edges, the graph can still be fully 
//traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob 
//if starting from any node, they can reach all other nodes. 
//
// Return the maximum number of edges you can remove, or return -1 if Alice and 
//Bob cannot fully traverse the graph. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
//Output: 2
//Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will 
//still be fully traversable by Alice and Bob. Removing any additional edge will not 
//make it so. So the maximum number of edges we can remove is 2.
// 
//
// Example 2: 
//
// 
//
// 
//Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
//Output: 0
//Explanation: Notice that removing any edge will not make the graph fully 
//traversable by Alice and Bob.
// 
//
// Example 3: 
//
// 
//
// 
//Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
//Output: -1
//Explanation: In the current graph, Alice cannot reach node 4 from the other 
//nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph 
//fully traversable. 
//
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= edges.length <= min(10⁵, 3 * n * (n - 1) / 2) 
// edges[i].length == 3 
// 1 <= typei <= 3 
// 1 <= ui < vi <= n 
// All tuples (typei, ui, vi) are distinct. 
// 
//
// 👍 933 👎 10


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int ALICE = 1;
    private static final int BOB = 2;
    private static final int BOTH = 3;



    public int maxNumEdgesToRemove(int n, int[][] edges) {

        HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> paths = new HashMap<>();
        for (int[] edge : edges) {
            int type = edge[0];
            HashMap<Integer, ArrayList<Integer>> target = paths.getOrDefault(type, new HashMap<>());
            makeAdjacentList(edge, target);
            paths.put(type, target);

        }

        //Check if path exists
        int[] visit = new int[n + 1];
        if (!dfs(1,
                visit,
                paths.getOrDefault(ALICE, new HashMap<>()),
                paths.getOrDefault(BOTH, new HashMap<>()),
                n
        )) return -1;

        visit = new int[n + 1];
        if (!dfs(1,
                visit,
                paths.getOrDefault(BOB, new HashMap<>()),
                paths.getOrDefault(BOTH, new HashMap<>()),
                n
        )) return -1;


        //Delete backnodes of each list individually
        int[] arrivalTimes = new int[n + 1];
        int aliceRemovals = countBackNodes(-1, 1, 0, arrivalTimes, paths.get(ALICE));
        arrivalTimes = new int[n + 1];
        int bobRemovals = countBackNodes(-1, 1, 0, arrivalTimes, paths.get(BOB));
        arrivalTimes = new int[n + 1];
        int bothRemovals = countBackNodes(-1, 1, 0, arrivalTimes, paths.get(BOTH));


        //Now there are no backnodes, which means that from 1 to n there is only one path
        //We must se were bob and alice paths overlaps
        //To graph will need (n-1) edges to be fully connected + overlapping nodes of alice and bob

        int overlaps = 0;

        return edges.length - ( (n-1) + overlaps );
    }

    private boolean dfs(int i,
                        int[] visit,
                        HashMap<Integer, ArrayList<Integer>> edges1,
                        HashMap<Integer, ArrayList<Integer>> edges2,
                        int target) {
        if (i == target) {
            return true;
        }
        if (!edges1.containsKey(i) && !edges2.containsKey(i)) return false;
        visit[i] = 1; //visiting
        ArrayList<Integer> neighbors = edges1.getOrDefault(i, new ArrayList<>());
        for (int neighbor : neighbors) {
            if (visit[neighbor] != 0) continue;
            if (dfs(neighbor, visit, edges1, edges2, target)) return true;
        }
        neighbors = edges2.getOrDefault(i, new ArrayList<>());

        for (int neighbor : neighbors) {
            if (visit[neighbor] != 0) continue;
            if (dfs(neighbor, visit, edges1, edges2, target)) return true;
        }
        visit[i] = 2; //visited
        return false;

    }


    private int countBackNodes(int parent, int i, int time, int[] arrivalTimes, HashMap<Integer, ArrayList<Integer>> edges) {
        int res = 0;
        int currentNodeTime = time + 1;
        arrivalTimes[i] = currentNodeTime;
        if (!edges.containsKey(i)) return res;
        ArrayList<Integer> neighbors = edges.get(i);

        for (int neighbor : neighbors) {
            if (neighbor == parent) continue;
            if (arrivalTimes[neighbor] > 0 && arrivalTimes[neighbor] < currentNodeTime) {
                //Found a back node
                res++;
            }
            res += countBackNodes(i, neighbor, currentNodeTime, arrivalTimes, edges);
        }
        return res;
    }

    private void makeAdjacentList(int[] edge, HashMap<Integer, ArrayList<Integer>> adjList) {

        int from = edge[1];
        int to = edge[2];
        ArrayList<Integer> connections = adjList.getOrDefault(from, new ArrayList<>());
        connections.add(to);
        adjList.put(from, connections);

        connections = adjList.getOrDefault(to, new ArrayList<>());
        connections.add(from);
        adjList.put(to, connections);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable extends Solution {
}