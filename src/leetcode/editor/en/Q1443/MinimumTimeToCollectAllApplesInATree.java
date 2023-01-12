package leetcode.editor.en.Q1443;

import javafx.util.Pair;

import java.util.*;

//Given an undirected tree consisting of n vertices numbered from 0 to n-1, 
//which has some apples in their vertices. You spend 1 second to walk over one edge 
//of the tree. Return the minimum time in seconds you have to spend to collect all 
//apples in the tree, starting at vertex 0 and coming back to this vertex. 
//
// The edges of the undirected tree are given in the array edges, where edges[i]
// = [ai, bi] means that exists an edge connecting the vertices ai and bi. 
//Additionally, there is a boolean array hasApple, where hasApple[i] = true means that 
//vertex i has an apple; otherwise, it does not have any apple. 
//
// 
// Example 1: 
// 
// 
//Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [
//false,false,true,false,true,true,false]
//Output: 8 
//Explanation: The figure above represents the given tree where red vertices 
//have an apple. One optimal path to collect all apples is shown by the green arrows.
//  
// 
//
// Example 2: 
// 
// 
//Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [
//false,false,true,false,false,true,false]
//Output: 6
//Explanation: The figure above represents the given tree where red vertices 
//have an apple. One optimal path to collect all apples is shown by the green arrows.
//  
// 
//
// Example 3: 
//
// 
//Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [
//false,false,false,false,false,false,false]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai < bi <= n - 1 
// fromi < toi 
// hasApple.length == n 
// 
//
// 👍 1919 👎 163


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<Boolean> hasApple;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, HashSet<Integer>> adjList = makeAdjList(edges);
        this.hasApple = hasApple;
        int[] res = dfs(0, -1, adjList);
        if (res[0] > 0) {
            return res[1] - 2;
        }
        return 0;
    }

    private int[] dfs(int node,
                      int parent,
                      HashMap<Integer,
                              HashSet<Integer>> adjList) {
        int totalCost = 0;
        int foundApples = 0;
        if (adjList.containsKey(node)) {
            HashSet<Integer> edges = adjList.get(node);
            for (int nextNode : edges) {
                if (nextNode == parent) continue;
                int[] res = dfs(nextNode, node, adjList);
                if (res[0] > 0) {
                    foundApples = 1;
                    totalCost += res[1];
                }

            }
        }
        if (hasApple.get(node) || foundApples > 0) {
            foundApples = 1;
            totalCost += 2;
        }
        return new int[]{foundApples, totalCost};
    }

    public HashMap<Integer, HashSet<Integer>> makeAdjList(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            HashSet<Integer> connections = adjList.getOrDefault(from, new HashSet<>());
            connections.add(to);
            adjList.put(from, connections);
            connections = adjList.getOrDefault(to, new HashSet<>());
            connections.add(from);
            adjList.put(to, connections);
        }
        return adjList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class MinimumTimeToCollectAllApplesInATree extends Solution {
}

/**
 * V1
 * class Solution {
 * <p>
 * <p>
 * public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
 * HashMap<Integer, HashSet<Integer>> adjList = makeAdjList(edges);
 * Queue<Integer> nextApple = queueApples(adjList, hasApple);
 * int minimumTime = 0;
 * int currentNode = 0;
 * while (!nextApple.isEmpty()) {
 * int target = nextApple.poll();
 * minimumTime += bfs(currentNode, target, adjList);
 * currentNode = target;
 * }
 * minimumTime += bfs(currentNode, 0, adjList);
 * <p>
 * return minimumTime;
 * }
 * <p>
 * private int bfs(int start, int target, HashMap<Integer, HashSet<Integer>> adjList) {
 * HashSet<Integer> visited = new HashSet<>();
 * Queue<Integer> queue = new LinkedList<>();
 * queue.add(start);
 * visited.add(start);
 * int minumumTime = 0;
 * while (!queue.isEmpty()) {
 * int size = queue.size();
 * for (int i = 0; i < size; i++) {
 * int node = queue.poll();
 * if (node == target) {
 * return minumumTime;
 * }
 * HashSet<Integer> edges = adjList.getOrDefault(node, new HashSet<>());
 * for (int nextNode : edges) {
 * if (!visited.contains(nextNode)) {
 * if (nextNode == target) {
 * return minumumTime + 1;
 * }
 * queue.add(nextNode);
 * visited.add(nextNode);
 * }
 * }
 * }
 * minumumTime++;
 * }
 * return minumumTime;
 * }
 * <p>
 * private Queue<Integer> queueApples(HashMap<Integer, HashSet<Integer>> adjList, List<Boolean> hasApple) {
 * Queue<Integer> applesByLevel = new LinkedList<>();
 * HashSet<Integer> visited = new HashSet<>();
 * dfs(0, adjList, hasApple, visited, applesByLevel);
 * <p>
 * return applesByLevel;
 * }
 * <p>
 * private void dfs(int node,
 * HashMap<Integer,
 * HashSet<Integer>> adjList,
 * List<Boolean> hasApple,
 * HashSet<Integer> visited,
 * Queue<Integer> applesByLevel) {
 * if (hasApple.get(node)) {
 * applesByLevel.add(node);
 * }
 * visited.add(node);
 * HashSet<Integer> edges = adjList.getOrDefault(node, new HashSet<>());
 * for (int nextNode : edges) {
 * if (!visited.contains(nextNode)) {
 * dfs(nextNode, adjList, hasApple, visited, applesByLevel);
 * }
 * }
 * <p>
 * }
 * <p>
 * public HashMap<Integer, HashSet<Integer>> makeAdjList(int[][] edges) {
 * HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
 * for (int[] edge : edges) {
 * int from = edge[0];
 * int to = edge[1];
 * HashSet<Integer> connections = adjList.getOrDefault(from, new HashSet<>());
 * connections.add(to);
 * adjList.put(from, connections);
 * connections = adjList.getOrDefault(to, new HashSet<>());
 * connections.add(from);
 * adjList.put(to, connections);
 * }
 * return adjList;
 * }
 * }
 **/