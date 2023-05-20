package leetcode.editor.en.Q785;

import java.util.*;

import javafx.util.Pair;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int GRAY = 0;
    private static final int BLUE = 1;
    private static final int GREEN = 2;

    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, Integer> colors = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> adjList = makeAdjList(graph);
        for (int i = 0; i < graph.length; i++) {
            colors.put(i, GRAY);
        }
        for (int i = 0; i < graph.length; i++) {
            if (colors.get(i) != GRAY) continue;
            if (!checkBipartition(i, adjList, colors)) return false;
        }
        return true;
    }

    private boolean checkBipartition(int root,
                                     HashMap<Integer, HashSet<Integer>> adjList,
                                     HashMap<Integer, Integer> colors) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{root, BLUE});
        HashSet<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] shouldBeInfo = queue.poll();
                int node = shouldBeInfo[0];
                int color = shouldBeInfo[1];
                colors.put(node, color);
                visited.add(node);
                if (!adjList.containsKey(node)) continue;
                HashSet<Integer> connected = adjList.get(node);
                int newColor = color == BLUE ? GREEN : BLUE;
                for (int next : connected) {
                    if (colors.get(next) != GRAY && colors.get(next) != newColor) {
                        return false;
                    }
                    if (!visited.contains(next)) queue.add(new int[]{next, newColor});
                }
            }
        }
        return true;

    }

    private HashMap<Integer, HashSet<Integer>> makeAdjList(int[][] graph) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            int from = i;
            for (int to : graph[i]) {
                adjList.computeIfAbsent(from, (v) -> new HashSet<>()).add(to);
                adjList.computeIfAbsent(to, (v) -> new HashSet<>()).add(from);
            }
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class IsGraphBipartite extends Solution {
}