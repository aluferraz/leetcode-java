import javafx.util.Pair;

import java.util.*;

import java.math.BigInteger;

class Solution {

    HashSet<Pair<Integer, Integer>> edgesToReplace = new HashSet<>();

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        HashMap<Integer, HashMap<Integer, Integer>> adjList = makeAdjList(edges);
        LinkedList<Integer> minimumPath = bfs(n, adjList, source, destination, target);
        HashSet<Pair<Integer, Integer>> mustReplace = new HashSet<>();
        replaceMinimumPath(minimumPath, 0, adjList, target, mustReplace);

        for (Pair<Integer, Integer> edgeToReplace : edgesToReplace) {
            int from = edgeToReplace.getKey();
            int to = edgeToReplace.getValue();
            Pair<Integer, Integer> pairKey = new Pair<>(Math.min(from, to), Math.max(from, to));
            if (mustReplace.contains(pairKey)) continue;
            adjList.get(from).put(to, Integer.MAX_VALUE);
            adjList.get(to).put(from, Integer.MAX_VALUE);
        }

        target -= mustReplace.size();
        if (target < 0) return new int[0][0];


        for (Pair<Integer, Integer> edgeToReplace : mustReplace) {
            int from = edgeToReplace.getKey();
            int to = edgeToReplace.getValue();

            adjList.get(from).put(to, 1);
            adjList.get(to).put(from, 1);


            int maxAllowed = Integer.MAX_VALUE;
            int replace = 1;
            if (target > 0) {
                HashMap<Integer, Integer> edgesFrom = adjList.get(from);
                for (Map.Entry<Integer, Integer> kv : edgesFrom.entrySet()) {
                    if (kv.getValue() == -1 || kv.getKey() == to) continue;
                    maxAllowed = Math.min(maxAllowed, kv.getValue());
                }
                if (maxAllowed >= target + 1) {
                    replace = target + 1;
                } else {
                    replace = maxAllowed;
                }
                target -= replace;
            }
            adjList.get(from).put(to, replace);
            adjList.get(to).put(from, replace);

        }
        if (target > 0) return new int[0][0];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            edge[2] = adjList.get(from).get(to);
        }
        return edges;

    }

    private void replaceMinimumPath(
            LinkedList<Integer> minimumPath,
            int i,
            HashMap<Integer, HashMap<Integer, Integer>> adjList,
            int target,
            HashSet<Pair<Integer, Integer>> mustReplace
    ) {
        if (i == minimumPath.size() - 1) {
            return;
        }
        int from = minimumPath.get(i);
        int to = minimumPath.get(i + 1);
        int cost = adjList.get(from).get(to);
        if (cost == -1) {
            mustReplace.add(new Pair<>(Math.min(from, to), Math.max(from, to)));
        }
        replaceMinimumPath(minimumPath, i + 1, adjList, target - cost, mustReplace);

    }

    private HashMap<Integer, HashMap<Integer, Integer>> makeAdjList(int[][] edges) {
        HashMap<Integer, HashMap<Integer, Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adjList.computeIfAbsent(from, (v) -> new HashMap<>()).put(to, weight);
            adjList.computeIfAbsent(to, (v) -> new HashMap<>()).put(from, weight);
            if (weight == -1) {
                edgesToReplace.add(new Pair<>(Math.min(from, to), Math.max(from, to)));
            }
        }
        return adjList;
    }

    private LinkedList<Integer> bfs(int n, HashMap<Integer, HashMap<Integer, Integer>> adjList, int source, int destination, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{source, 0});
        HashMap<Integer, Integer> visited = new HashMap<>();
        int[] path = new int[n + 1];
        Arrays.fill(path, -1);
        visited.put(source, -1);

        boolean found = false;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] info = q.poll();
                int current = info[0];
                int cost = info[1];
                visited.put(current, Math.min(cost, visited.getOrDefault(current, Integer.MAX_VALUE)));
                if (current == destination) {
                    found = true;
                    continue;
                }

                HashMap<Integer, Integer> connections = adjList.get(current);
                for (Map.Entry<Integer, Integer> kv : connections.entrySet()) {
                    int to = kv.getKey();
                    int weight = kv.getValue();
                    if (weight == -1) {
                        weight = 1;

                    }
                    if (visited.getOrDefault(to, Integer.MAX_VALUE) >= cost + weight) {
                        path[to] = current;
                        q.add(new int[]{to, cost + weight});
                    }
                }
            }
            if (found) break;

        }

        LinkedList<Integer> pathList = new LinkedList<>();

        getPath(path, destination, pathList);


        return pathList;

    }

    private void getPath(int[] path, int i, LinkedList<Integer> pathList) {
        pathList.addFirst(i);
        if (path[i] == -1) {
            return;
        }
        getPath(path, path[i], pathList);
    }


}

public class Contest extends Solution {
}