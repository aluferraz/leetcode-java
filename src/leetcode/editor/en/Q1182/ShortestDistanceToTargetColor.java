package leetcode.editor.en.Q1182;

import java.util.*;

//You are given an array colors, in which there are three colors: 1, 2 and 3. 
//
// You are also given some queries. Each query consists of two integers i and c,
// return the shortest distance between the given index i and the target color c. 
//If there is no solution return -1. 
//
// 
// Example 1: 
//
// 
//Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//Output: [3,0,3]
//Explanation: 
//The nearest 3 from index 1 is at index 4 (3 steps away).
//The nearest 2 from index 2 is at index 2 itself (0 steps away).
//The nearest 1 from index 6 is at index 3 (3 steps away).
// 
//
// Example 2: 
//
// 
//Input: colors = [1,2], queries = [[0,3]]
//Output: [-1]
//Explanation: There is no 3 in the array.
// 
//
// 
// Constraints: 
//
// 
// 1 <= colors.length <= 5*10^4 
// 1 <= colors[i] <= 3 
// 1 <= queries.length <= 5*10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] < colors.length 
// 1 <= queries[i][1] <= 3 
// 
//
// 👍 471 👎 20


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        TreeSet<Integer> colorOne = new TreeSet<>();
        TreeSet<Integer> colorTwo = new TreeSet<>();
        TreeSet<Integer> colorThree = new TreeSet<>();
        map.put(1, colorOne);
        map.put(2, colorTwo);
        map.put(3, colorThree);

        for (int i = 0; i < colors.length; i++) {
            map.get(colors[i]).add(i);
        }
        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int index = query[0];
            int target = query[1];
            Integer next = map.get(target).ceiling(index);
            Integer prev = map.get(target).floor(index);
            if (next == null && prev == null) {
                result.add(-1);
            } else if (next == null) {
                result.add(index - prev);
            } else if (prev == null) {
                result.add(next - index);
            } else {
                result.add(Math.min(next - index, index - prev));
            }
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


public class ShortestDistanceToTargetColor extends Solution {
}