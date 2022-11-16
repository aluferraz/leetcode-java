package leetcode.editor.en.Q947;

import java.util.*;

//On a 2D plane, we place n stones at some integer coordinate points. Each 
//coordinate point may have at most one stone. 
//
// A stone can be removed if it shares either the same row or the same column 
//as another stone that has not been removed. 
//
// Given an array stones of length n where stones[i] = [xi, yi] represents the 
//location of the iᵗʰ stone, return the largest possible number of stones that can 
//be removed. 
//
// 
// Example 1: 
//
// 
//Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//Output: 5
//Explanation: One way to remove 5 stones is as follows:
//1. Remove stone [2,2] because it shares the same row as [2,1].
//2. Remove stone [2,1] because it shares the same column as [0,1].
//3. Remove stone [1,2] because it shares the same row as [1,0].
//4. Remove stone [1,0] because it shares the same column as [0,0].
//5. Remove stone [0,1] because it shares the same row as [0,0].
//Stone [0,0] cannot be removed since it does not share a row/column with 
//another stone still on the plane.
// 
//
// Example 2: 
//
// 
//Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//Output: 3
//Explanation: One way to make 3 moves is as follows:
//1. Remove stone [2,2] because it shares the same row as [2,0].
//2. Remove stone [2,0] because it shares the same column as [0,0].
//3. Remove stone [0,2] because it shares the same row as [0,0].
//Stones [0,0] and [1,1] cannot be removed since they do not share a row/column 
//with another stone still on the plane.
// 
//
// Example 3: 
//
// 
//Input: stones = [[0,0]]
//Output: 0
//Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
// 
//
// 
// Constraints: 
//
// 
// 1 <= stones.length <= 1000 
// 0 <= xi, yi <= 10⁴ 
// No two stones are at the same coordinate point. 
// 
//
// 👍 3496 👎 550


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeStones(int[][] stones) {
        HashMap<Integer, HashSet<Integer>> stonesRow = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> stonesCol = new HashMap<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1];
            HashSet<Integer> stonesOfRow = new HashSet<>();
            HashSet<Integer> stonesOfCol = new HashSet<>();
            if (stonesRow.containsKey(row)) {
                stonesOfRow = stonesRow.get(row);
            }
            if (stonesCol.containsKey(col)) {
                stonesOfCol = stonesCol.get(col);
            }
            stonesOfRow.add(col);
            stonesOfCol.add(row);
            stonesRow.put(row, stonesOfRow);
            stonesCol.put(col, stonesOfCol);
        }
        int maxRemoved = 0;

        HashMap<String, HashSet<String>> stoneNeighbors = new HashMap<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1];
            String stoneKey = String.valueOf(row) + ':' + col;
            HashSet<String> neighbors = new HashSet<>();
            for (int rowNeighbor : stonesRow.get(row)) {
                if (rowNeighbor != col) {
                    String newKey = String.valueOf(row) + ':' + rowNeighbor;
                    neighbors.add(newKey);
                }
            }
            for (int colNeighbor : stonesCol.get(col)) {
                if (colNeighbor != row) {
                    String newKey = String.valueOf(colNeighbor) + ':' + col;
                    neighbors.add(newKey);
                }
            }
            if (neighbors.size() > 0) stoneNeighbors.put(stoneKey, neighbors);
        }
        HashSet<String> removedStones = new HashSet<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1];
            String stoneKey = String.valueOf(row) + ':' + col;
            int removed = countRemoved(stoneKey, removedStones, stoneNeighbors);
            if (removed > 0) removed--;
            maxRemoved += removed;
        }

        return maxRemoved;
    }

    private int countRemoved(String stoneKey, HashSet<String> removedStones, HashMap<String, HashSet<String>> stoneNeighbors) {
        int removed = 0;
        if (!stoneNeighbors.containsKey(stoneKey)) return removed;
        removedStones.add(stoneKey);
        boolean canRemove = false;
        removed = 1;
        for (String nextStone : stoneNeighbors.get(stoneKey)) {
            if (removedStones.contains(nextStone)) continue;
            removed += countRemoved(nextStone, removedStones, stoneNeighbors);
        }

        return removed; //Can be removed
    }

}
//leetcode submit region end(Prohibit modification and deletion)


public class MostStonesRemovedWithSameRowOrColumn extends Solution {
}