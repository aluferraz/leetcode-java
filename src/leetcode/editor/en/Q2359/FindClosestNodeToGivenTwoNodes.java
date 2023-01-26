package leetcode.editor.en.Q2359;

import java.util.*;

import javafx.util.Pair;

//You are given a directed graph of n nodes numbered from 0 to n - 1, where 
//each node has at most one outgoing edge. 
//
// The graph is represented with a given 0-indexed array edges of size n, 
//indicating that there is a directed edge from node i to node edges[i]. If there is no 
//outgoing edge from i, then edges[i] == -1. 
//
// You are also given two integers node1 and node2. 
//
// Return the index of the node that can be reached from both node1 and node2, 
//such that the maximum between the distance from node1 to that node, and from 
//node2 to that node is minimized. If there are multiple answers, return the node 
//with the smallest index, and if no possible answer exists, return -1. 
//
// Note that edges may contain cycles. 
//
// 
// Example 1: 
// 
// 
//Input: edges = [2,2,3,-1], node1 = 0, node2 = 1
//Output: 2
//Explanation: The distance from node 0 to node 2 is 1, and the distance from 
//node 1 to node 2 is 1.
//The maximum of those two distances is 1. It can be proven that we cannot get 
//a node with a smaller maximum distance than 1, so we return node 2.
// 
//
// Example 2: 
// 
// 
//Input: edges = [1,2,-1], node1 = 0, node2 = 2
//Output: 2
//Explanation: The distance from node 0 to node 2 is 2, and the distance from 
//node 2 to itself is 0.
//The maximum of those two distances is 2. It can be proven that we cannot get 
//a node with a smaller maximum distance than 2, so we return node 2.
// 
//
// 
// Constraints: 
//
// 
// n == edges.length 
// 2 <= n <= 10⁵ 
// -1 <= edges[i] < n 
// edges[i] != i 
// 0 <= node1, node2 < n 
// 
//
// 👍 820 👎 196


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {


        HashSet<Integer> visited1 = new HashSet<>();
        HashSet<Integer> visited2 = new HashSet<>();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        q1.add(edges[node1]);
        visited1.add(node1);

        q2.add(edges[node2]);
        visited2.add(node2);

        if (visited1.contains(node2)) {
            return node1;
        }


        int res = Integer.MAX_VALUE;
        while (!q1.isEmpty() || !q2.isEmpty()) {

//            for (int i : visited1) {
//                if (visited2.contains(i)) {
//                    return i;
//                }
//            }


            int size = q1.size();
            for (int i = 0; i < size; i++) {
                int nextIdx = q1.poll();
                if (visited1.contains(nextIdx) || nextIdx == -1) continue;
                q1.add(edges[nextIdx]);
                visited1.add(nextIdx);
                if (visited2.contains(nextIdx)) {
                    res = Math.min(res, nextIdx);
                }

            }

            size = q2.size();
            for (int i = 0; i < size; i++) {
                int nextIdx = q2.poll();

                if (visited2.contains(nextIdx) || nextIdx == -1) continue;
                q2.add(edges[nextIdx]);
                visited2.add(nextIdx);
                if (visited1.contains(nextIdx)) {
                    res = Math.min(res, nextIdx);
                }
            }
            if (res != Integer.MAX_VALUE) {
                return res;
            }

        }
        return -1;

    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class FindClosestNodeToGivenTwoNodes extends Solution {
}