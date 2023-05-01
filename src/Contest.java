
import javafx.util.Pair;

import java.util.*;
class Solution {

    HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
    HashMap<Pair<Integer, Integer>, Integer> cache = new HashMap<>();


    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int minimumCostSpecial = Integer.MAX_VALUE;
        int[] bestSpecial = new int[]{start[0], start[1]};
        for (int[] special : specialRoads) {
            int[] startSpecial = new int[]{special[2], special[3]};
            int costToSpecial = getCost(start[0], start[1], special[0], special[1]);
            int costFromThere = minimumCostHelper(startSpecial, target, specialRoads);
            int costSpecial = costToSpecial +
                    special[4] +
                    costFromThere;
            if (costSpecial < minimumCostSpecial) {
                minimumCostSpecial = costSpecial;
                bestSpecial[0] = special[0];
                bestSpecial[1] = special[1];
            }
            Pair<Integer, Integer> nodeKey = new Pair<>(special[2], special[3]);
            cache.put(nodeKey, costFromThere);

        }
        int costToTarget = getCost(start[0], start[1], target[0], target[1]);
        return Math.min(costToTarget, minimumCostSpecial);

    }

    public int minimumCostHelper(
            int[] start,
            int[] target,
            int[][] specialRoads) {
        if (Arrays.equals(start, target)) {
            return 0;
        }
        Pair<Integer, Integer> nodeKey = new Pair<>(start[0], start[1]);

        if (cache.containsKey(nodeKey)) {
            return cache.get(nodeKey);
        }

        visited.add(nodeKey);
        int costToTarget = getCost(start[0], start[1], target[0], target[1]);
        int costHopping = Integer.MAX_VALUE;
        for (int[] special : specialRoads) {
            if (!visited.contains(new Pair<>(special[2], special[3]))) {
                int costFromRoad =
                        getCost(start[0], start[1], special[0], special[1])
                                + special[4]
                                + minimumCostHelper(new int[]{special[2], special[3]}, target, specialRoads);
                costHopping = Math.min(costHopping, costFromRoad);
            }
        }
        visited.remove(nodeKey);
        int ans = Math.min(costHopping, costToTarget);


        return ans;

    }

    private int getCost(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}


public class Contest extends Solution {
}
/**
 * class Node {
 * <p>
 * public Node next = null;
 * int val;
 * <p>
 * Node(int val) {
 * this.val = val;
 * }
 * <p>
 * Node(int val, Node next) {
 * this.val = val;
 * this.next = next;
 * }
 * }
 * <p>
 * class CustomLL {
 * <p>
 * Node head;
 * Node tail;
 * <p>
 * int this.
 * <p>
 * public void add(){
 * <p>
 * }
 * <p>
 * }
 */