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
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            int fromParent = getParent(from, parents);
            int toParent = getParent(to, parents);
            if (fromParent != toParent) {
                union(fromParent, toParent, parents);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] >= 0 && parents[parents[i]] == -2) {
                List<Integer> critical = new ArrayList<>();
                critical.add(i);
                critical.add(parents[i]);
                result.add(critical);
            }
        }
        return result;
    }

    private void union(int i, int j, int[] parents) {
        if (parents[i] <= parents[j]) {
            parents[i] += parents[j];
            parents[j] = i;
        } else {
            union(j, i, parents);
        }
    }


    private int getParent(int i, int[] parents) {
        Stack<Integer> newParents = new Stack<>();
        while (parents[i] >= 0) {
            newParents.push(i);
            i = parents[i];
        }
        while (!newParents.isEmpty()) {
            parents[newParents.pop()] = i;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class CriticalConnectionsInANetwork extends Solution {
}