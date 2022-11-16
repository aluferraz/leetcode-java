package leetcode.editor.en.Q547;

import java.util.*;

//There are n cities. Some of them are connected, while some are not. If city a 
//is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c. 
//
// A province is a group of directly or indirectly connected cities and no 
//other cities outside of the group. 
//
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the 
//iᵗʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0 
//otherwise. 
//
// Return the total number of provinces. 
//
// 
// Example 1: 
// 
// 
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2
// 
//
// Example 2: 
// 
// 
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] is 1 or 0. 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
//
// 👍 6544 👎 271


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numberOfProvinces = isConnected.length;
        for (int i = 0; i < isConnected.length; i++) {
            int numberOfConnections = dfsConnections(isConnected, i);
            numberOfProvinces -= Math.max( (numberOfConnections - 1) , 0);
        }
        return numberOfProvinces;
    }

    private int dfsConnections(int[][] isConnected, int idx) {
        int[] connections = isConnected[idx];
        if (connections[idx] == 0) return 0;
        connections[idx] = 0; // Visited
        int totalConnections = 1;
        for (int i = 0; i < connections.length; i++) {
            if (connections[i] == 0) continue;
            totalConnections += dfsConnections(isConnected, i);
        }
        return totalConnections;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class NumberOfProvinces extends Solution {
}