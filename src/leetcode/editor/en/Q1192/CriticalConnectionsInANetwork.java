package leetcode.editor.en.Q1192;

import java.util.*;

//There are n servers numbered from 0 to n - 1 connected by undirected server-
//to-server connections forming a network where connections[i] = [ai, bi] 
//represents a connection between servers ai and bi. Any server can reach other servers 
//directly or indirectly through the network. 
//
// A critical connection is a connection that, if removed, will make some 
//servers unable to reach some other server. 
//
// Return all critical connections in the network in any order. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
//Output: [[1,3]]
//Explanation: [[3,1]] is also accepted.
// 
//
// Example 2: 
//
// 
//Input: n = 2, connections = [[0,1]]
//Output: [[0,1]]
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 10⁵ 
// n - 1 <= connections.length <= 10⁵ 
// 0 <= ai, bi <= n - 1 
// ai != bi 
// There are no repeated connections. 
// 
//
// 👍 5046 👎 168


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<Integer, Integer> arrivalTimes = new HashMap<>();
    HashMap<Integer, List<Integer>> connectionsMap = new HashMap<>();

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            List<Integer> nodeConnections = connectionsMap.getOrDefault(from, new LinkedList<>());
            nodeConnections.add(to);
            connectionsMap.put(from, nodeConnections);
            nodeConnections = connectionsMap.getOrDefault(to, new LinkedList<>());
            nodeConnections.add(from);
            connectionsMap.put(to, nodeConnections);
        }
        dfs(0, -1, 0);
        return result;
    }

    private int dfs(int i, int parent, int arrivalTime) {
        List<Integer> nodeConnections = connectionsMap.getOrDefault(i, new ArrayList<>());
        int arrival = arrivalTimes.getOrDefault(i, -1);
        if (arrival != -1) return arrival;

        int minimumArrivalTime = arrivalTime;
        arrivalTimes.put(i, minimumArrivalTime);

        for (Integer connection : nodeConnections) {
            if (connection == parent) continue;
            int newArrival = arrivalTimes.getOrDefault(connection, -1);
            if (newArrival == -1) {
                newArrival = Math.min(minimumArrivalTime, dfs(connection, i, arrivalTime + 1));
            }
            minimumArrivalTime = Math.min(minimumArrivalTime, newArrival);
        }
        if (minimumArrivalTime == arrivalTime && parent != -1) {
            result.add(Arrays.asList(parent, i));
        }
        arrivalTimes.put(i, minimumArrivalTime);
        return minimumArrivalTime;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CriticalConnectionsInANetwork extends Solution {
}