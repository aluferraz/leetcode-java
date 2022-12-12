package leetcode.editor.en.Q1319;

import java.util.*;

//There are n computers numbered from 0 to n - 1 connected by ethernet cables 
//connections forming a network where connections[i] = [ai, bi] represents a 
//connection between computers ai and bi. Any computer can reach any other computer 
//directly or indirectly through the network. 
//
// You are given an initial computer network connections. You can extract 
//certain cables between two directly connected computers, and place them between any 
//pair of disconnected computers to make them directly connected. 
//
// Return the minimum number of times you need to do this in order to make all 
//the computers connected. If it is not possible, return -1. 
//
// 
// Example 1: 
// 
// 
//Input: n = 4, connections = [[0,1],[0,2],[1,2]]
//Output: 1
//Explanation: Remove cable between computer 1 and 2 and place between 
//computers 1 and 3.
// 
//
// Example 2: 
// 
// 
//Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
//Output: -1
//Explanation: There are not enough cables.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= connections.length <= min(n * (n - 1) / 2, 10⁵) 
// connections[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// There are no repeated connections. 
// No two computers are connected by more than one cable. 
// 
//
// 👍 2912 👎 36


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //https://www.youtube.com/watch?v=wU6udHRIkcc
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int cycles = 0;
        int disjoint = n;
        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            int parentFrom = find(from, parents);
            int parentTo = find(to, parents);
            if (parentFrom == parentTo) {
                cycles++;
            } else {
                union(parentFrom, parentTo, parents);
                disjoint--;
            }
        }

        if (disjoint == 1) return 0; // They all are in the same network
        return cycles >= (disjoint - 1) ? disjoint - 1 : -1;
    }

    private int find(int i, int[] parents) {
//        return parents[i] == -1 ? i : ;

        //https://www.youtube.com/watch?v=PGZ64ob440I Compression
        Stack<Integer> newParent = new Stack<>();
        while (parents[i] >= 0) {
            newParent.push(i);
            i = parents[i];
        }
        // amortized time O(N)
        while (!newParent.isEmpty()) {
            parents[newParent.pop()] = i;
        }
        return i;
    }

    private void union(int i, int j, int[] parents) {
        if (parents[i] <= parents[j]) {
            parents[i] += parents[j];
            parents[j] = i;
        } else {
            parents[j] += parents[i];
            parents[i] = j;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfOperationsToMakeNetworkConnected extends Solution {
}