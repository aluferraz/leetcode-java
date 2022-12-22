package leetcode.editor.en.Q886;

import java.util.*;

//We want to split a group of n people (labeled from 1 to n) into two groups of 
//any size. Each person may dislike some other people, and they should not go 
//into the same group. 
//
// Given the integer n and the array dislikes where dislikes[i] = [ai, bi] 
//indicates that the person labeled ai does not like the person labeled bi, return 
//true if it is possible to split everyone into two groups in this way. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
//Output: true
//Explanation: group1 [1,4] and group2 [2,3].
// 
//
// Example 2: 
//
// 
//Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2000 
// 0 <= dislikes.length <= 10⁴ 
// dislikes[i].length == 2 
// 1 <= dislikes[i][j] <= n 
// ai < bi 
// All the pairs of dislikes are unique. 
// 
//
// 👍 3355 👎 76


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    private static final int GRAY = 0;
    private static final int BLUE = 1;
    private static final int RED = 2;
    HashSet<Integer> subjects = new HashSet<>();


    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, LinkedList<Integer>> adj_list = new HashMap<>();
        for (int[] dislike : dislikes) {
            int from = dislike[0];
            int to = dislike[1];
            LinkedList<Integer> connections = adj_list.getOrDefault(from, new LinkedList<>());
            connections.add(to);
            adj_list.put(from, connections);

            connections = adj_list.getOrDefault(to, new LinkedList<>());
            connections.add(from);
            adj_list.put(to, connections);
            subjects.add(from);
            subjects.add(to);
        }

        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!subjects.contains(i)) continue;
            if (colors[i] == GRAY) //color(i, colors, adj_list);
                color(i, BLUE, colors, adj_list);
        }
//        }
        for (int[] dislike : dislikes) {
            int from = dislike[0];
            int to = dislike[1];
            if (colors[from] == colors[to]) return false;
        }

        return true;


    }

    private void color(int i, int color, int[] colors, HashMap<Integer, LinkedList<Integer>> adj_list) {
        if (colors[i] != GRAY) return;
        subjects.remove(i);
        colors[i] = color;
        LinkedList<Integer> connections = adj_list.getOrDefault(i, new LinkedList<>());
        for (int conn : connections) {
            if (colors[conn] == GRAY) {
                switch (color) {
                    case BLUE:
                        color(conn, RED, colors, adj_list);
//                        q.add(new int[]{conn, RED});
                        break;
                    case RED:
//                        q.add(new int[]{conn, BLUE});
                        color(conn, BLUE, colors, adj_list);
                        break;
                }
            }
        }
    }

    private void color(int i, int[] colors, HashMap<Integer, LinkedList<Integer>> adj_list) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, BLUE});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] current = q.poll();
                int node = current[0];
                int color = current[1];
                LinkedList<Integer> connections = adj_list.getOrDefault(node, new LinkedList<>());
                colors[node] = color;
                for (int conn :
                        connections) {
                    if (colors[conn] == GRAY) {
                        switch (color) {
                            case BLUE:
                                q.add(new int[]{conn, RED});
                                break;
                            case RED:
                                q.add(new int[]{conn, BLUE});
                                break;
                        }
                    }
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class PossibleBipartition extends Solution {
}