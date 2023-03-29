package leetcode.editor.en.Q815;

import java.util.*;

import javafx.util.Pair;

//You are given an array routes representing bus routes where routes[i] is a 
//bus route that the iᵗʰ bus repeats forever. 
//
// 
// For example, if routes[0] = [1, 5, 7], this means that the 0ᵗʰ bus travels 
//in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever. 
// 
//
// You will start at the bus stop source (You are not on any bus initially), 
//and you want to go to the bus stop target. You can travel between bus stops by 
//buses only. 
//
// Return the least number of buses you must take to travel from source to 
//target. Return -1 if it is not possible. 
//
// 
// Example 1: 
//
// 
//Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//Output: 2
//Explanation: The best strategy is take the first bus to the bus stop 7, then 
//take the second bus to the bus stop 6.
// 
//
// Example 2: 
//
// 
//Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target =
// 12
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 10⁵ 
// All the values of routes[i] are unique. 
// sum(routes[i].length) <= 10⁵ 
// 0 <= routes[i][j] < 10⁶ 
// 0 <= source, target < 10⁶ 
// 
//
// 👍 2912 👎 73


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (target == source) return 0;
        HashMap<Integer, HashSet<Integer>> busConnections = new HashMap<>();
        HashMap<Integer, LinkedHashSet<Integer>> busStops = new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                busStops.computeIfAbsent(stop, (v) -> new LinkedHashSet<>()).add(bus);
            }
        }
        for (int stop : busStops.keySet()) {
            HashSet<Integer> buses = busStops.get(stop);
            for (int bus : buses) {
                //busConnections.put(bus, buses);
                HashSet<Integer> connections = busConnections.getOrDefault(bus, new HashSet<>());
                connections.addAll(buses);
                connections.remove(bus);
                busConnections.put(bus, connections);
            }
        }


        if (!busStops.containsKey(source) || !busStops.containsKey(target)) return -1;
        int res = Integer.MAX_VALUE;
        for (int startingBus : busStops.get(source)) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{startingBus, 0});
            boolean[] busesSeen = new boolean[routes.length + 1];
            busesSeen[startingBus] = true;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] info = q.poll();
                    int bus = info[0];
                    int cost = info[1];
                    busesSeen[bus] = true;
                    if (busStops.get(target).contains(bus)) {
                        res = Math.min(res, cost + 1);
                        continue;
                    }
                    if (!busConnections.containsKey(bus)) continue;
                    HashSet<Integer> connections = busConnections.get(bus);
                    for (int nextBus : connections) {
                        if (!busesSeen[nextBus]) {
                            q.add(new int[]{nextBus, cost + 1});
                        }
                    }

                }
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class BusRoutes extends Solution {
}